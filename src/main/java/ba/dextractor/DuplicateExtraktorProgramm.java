package ba.dextractor;

import java.util.Map;

import org.apache.flink.streaming.api.datastream.DataStream;
import org.streampipes.wrapper.flink.FlinkSepaRuntime;


public class DuplicateExtraktorProgramm extends FlinkSepaRuntime<DuplicateExtraktoParam>{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateExtraktorProgramm(DuplicateExtraktoParam params) {
		super(params);
	}

	@Override
	protected DataStream<Map<String, Object>> getApplicationLogic(DataStream<Map<String, Object>>... arg0) {
		return arg0[0].flatMap(new DuplicatExtraktor(params.getPropertyName(), params.getTimeWindowValue(), params.getTimestamp()));
	}

}
