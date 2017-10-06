package ba.dextractor;

import java.util.HashMap;
import java.util.Map;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.util.Collector;

/**
 * @author Michael Jahns
 * Here is finally the programlogic to filter the stream
 */
public class DuplicatExtraktor implements FlatMapFunction<Map<String, Object>, Map<String, Object>> {

	private static final long serialVersionUID = 1L;

	private String propertyName;
	private Integer timeWindowSize;
	private String timestamp;
	private Map<String, Long> keyMap;

	public DuplicatExtraktor(String propertyName, Integer timeWindowSize, String time) {
		this.propertyName = propertyName;
		this.timeWindowSize = timeWindowSize;
		this.timestamp = time;
		this.keyMap = new HashMap<>();

	}

	/* (non-Javadoc)
	 * @see org.apache.flink.api.common.functions.FlatMapFunction#flatMap(java.lang.Object, org.apache.flink.util.Collector)
	 */
	public void flatMap(Map<String, Object> in, Collector<Map<String, Object>> out) {

		Long old = keyMap.get(in.get(propertyName));
		Long test = (Long) in.get(timestamp);
		if (keyMap.containsKey(in.get(propertyName))) {

			System.out.println((old - test) + " - "+ timeWindowSize *1000+" for " + in.get(propertyName));
			// System.out.println(test);
			if (old < (test - (Long.valueOf(timeWindowSize) * 1000))) {
				System.out.println("test");
				keyMap.put((String) in.get(propertyName), test);
				out.collect(in);
			}
		} else {
			keyMap.put((String) in.get(propertyName), ((Long) in.get(timestamp)).longValue());
			out.collect(in);
		}
	}
}
