package ba.dextractor;

import org.streampipes.model.impl.graph.SepaDescription;
import org.streampipes.model.impl.graph.SepaInvocation;
import org.streampipes.sdk.builder.ProcessingElementBuilder;
import org.streampipes.sdk.extractor.ProcessingElementParameterExtractor;
import org.streampipes.sdk.helpers.EpRequirements;
import org.streampipes.sdk.helpers.OutputStrategies;
import org.streampipes.sdk.helpers.SupportedFormats;
import org.streampipes.sdk.helpers.SupportedProtocols;
import org.streampipes.wrapper.flink.AbstractFlinkAgentDeclarer;
import org.streampipes.wrapper.flink.FlinkSepaRuntime;

public class DuplicateExtraktorCont extends AbstractFlinkAgentDeclarer<DuplicateExtraktoParam> {

	public SepaDescription declareModel() {
		return ProcessingElementBuilder
				.create("duplicateExtractor", "Duplicat Extractor",
						"Compares the Timestamps for a specific ID and sends the Data through when it is new and not in the Timewindow intervall. The Timestamp must be in Unix-Format")
				.stream1PropertyRequirementWithUnaryMapping(EpRequirements.anyProperty(), "property-filter",
						"The property to filter", "Must be a identifier")
				.stream1PropertyRequirementWithUnaryMapping(EpRequirements.timestampReq(), "Timestamp",
						"Timestamp to compare", "Must be in Unix-Time format")
				.requiredIntegerParameter("time-window-value", "Time in seconds the new Value must be newer", "")
				.outputStrategy(OutputStrategies.keep()).supportedProtocols(SupportedProtocols.kafka())
				.supportedFormats(SupportedFormats.jsonFormat()).build();
	}

	@Override
	protected FlinkSepaRuntime<DuplicateExtraktoParam> getRuntime(SepaInvocation arg0) {

		ProcessingElementParameterExtractor extractor = ProcessingElementParameterExtractor.from(arg0);

		String propertyName = extractor.mappingPropertyValue("property-filter");
		String timestamp = extractor.mappingPropertyValue("Timestamp");
		Integer timeWindowValue = extractor.singleValueParameter("time-window-value", Integer.class);

		DuplicateExtraktoParam staticParams = new DuplicateExtraktoParam(arg0, propertyName, timeWindowValue,
				timestamp);
		return new DuplicateExtraktorProgramm(staticParams);
	}

}
