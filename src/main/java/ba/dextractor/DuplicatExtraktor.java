package ba.dextractor;

import java.util.HashMap;
import java.util.Map;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.util.Collector;

public class DuplicatExtraktor implements FlatMapFunction<Map<String, Object>, Map<String, Object>> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String propertyName;
	@SuppressWarnings("unused")
	private Integer timeWindowSize;
	private String timestamp;
	private Map<String, Long> keyMap;

	public DuplicatExtraktor(String propertyName, Integer timeWindowSize, String time) {
		this.propertyName = propertyName;
		this.timeWindowSize = timeWindowSize;
		this.timestamp = time;
		this.keyMap = new HashMap<>();
	}

	public void flatMap(Map<String, Object> in, Collector<Map<String, Object>> out) throws Exception {
		if (keyMap.containsKey(in.get(propertyName))) {
			Long old = keyMap.get(in.get(propertyName));
			Long test = ((Long) in.get(timestamp)).longValue();
			
//			System.out.println(old);
//			System.out.println(test);
			if (old < test) {
				keyMap.put((String) in.get(propertyName), test);
				out.collect(in);
//				System.out.println("Updated: " + in.toString());
				System.out.println(in.get(propertyName));
			}
		} else {
			keyMap.put((String) in.get(propertyName), ((Long) in.get(timestamp)).longValue());
			out.collect(in);
			System.out.println(in.get(propertyName));
//			System.out.println("Newly added " + in.get(propertyName).toString());
		}
	}
}
