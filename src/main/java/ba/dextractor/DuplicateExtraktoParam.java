package ba.dextractor;

import org.streampipes.model.impl.graph.SepaInvocation;
import org.streampipes.wrapper.BindingParameters;

public class DuplicateExtraktoParam extends BindingParameters{

	private String propertyName;
	private Integer timeWindowValue;
	private String timestamp;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateExtraktoParam(SepaInvocation graph, String propertyName, Integer timeWindowValue, String timestamp) {
		super(graph);
		this.propertyName = propertyName;
		this.timeWindowValue = timeWindowValue;
		this.timestamp = timestamp;
		// TODO Auto-generated constructor stub
	}

	public String getPropertyName() {
		return propertyName;
	}

	public Integer getTimeWindowValue() {
		return timeWindowValue;
	}
	public String getTimestamp(){
		return timestamp;
	}

}
