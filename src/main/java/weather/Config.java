package weather;

//public enum Config {
//
//	public static final String JAR_FILE = "./streampipes-pe-mixed-flink.jar";
//
//	public static final String FLINK_HOST = ClientConfiguration.INSTANCE.getFlinkHost();
//
//	public static final int FLINK_PORT = ClientConfiguration.INSTANCE.getFlinkPort();
//
//	public static final String iconBaseUrl = ClientConfiguration.INSTANCE.getIconUrl() +"/img";
//
//	public static final String getIconUrl(String pictureName) {
//		return iconBaseUrl +"/" +pictureName +".png";
//	}
//}

import org.streampipes.config.SpConfig;

public enum Config {
	INSTANCE;

	private SpConfig config;
	public static final String JAR_FILE = "./streampipes-templates-flink.jar";

	private final static String HOST = "host";
	private final static String PORT = "port";
	private final static String FLINK_HOST = "flink_host";
	private final static String FLINK_PORT = "flink_port";
	private final static String ELASTIC_HOST = "elasticsearch_host";
	private final static String ELASTIC_PORT = "elasticsearch_port";
	private final static String KAFKA_HOST = "kafka_host";
	private final static String KAFKA_PORT = "kafka_port";
	private final static String ZOOKEEPER_HOST = "zookeeper_host";
	private final static String ZOOKEEPER_PORT = "zookeeper_port";

	Config() {
		config = SpConfig.getSpConfig("pe/org.streampipes.pe.mixed.flink");

		config.register(HOST, "pe-flink-samples", "Hostname for the pe mixed flink component");
		config.register(PORT, 8090, "Port for the pe mixed flink component");
		config.register(FLINK_HOST, "jobmanager", "Host for the flink cluster");
		config.register(FLINK_PORT, 6123, "Port for the flink cluster");
		config.register(ELASTIC_HOST, "elasticsearch", "Elastic search host address");
		config.register(ELASTIC_PORT, 9200, "Elasitc search port");
		config.register(KAFKA_HOST, "kafka", "Host for kafka of the pe sinks project");
		config.register(KAFKA_PORT, 9092, "Port for kafka of the pe sinks project");
		config.register(ZOOKEEPER_HOST, "zookeeper", "Host for zookeeper of the pe sinks project");
		config.register(ZOOKEEPER_PORT, 2181, "Port for zookeeper of the pe sinks project");

	}

	public String getHost() {
		return config.getString(HOST);
	}

	public int getPort() {
		return config.getInteger(PORT);
	}

	public String getFlinkHost() {
		return config.getString(FLINK_HOST);
	}

	public int getFlinkPort() {
		return config.getInteger(FLINK_PORT);
	}

	public String getElasticsearchHost() {
		return config.getString(ELASTIC_HOST);
	}

	public int getElasticsearchPort() {
		return config.getInteger(ELASTIC_PORT);
	}

	public static final String iconBaseUrl = Config.INSTANCE.getHost() + "/img";

	public static final String getIconUrl(String pictureName) {
		return iconBaseUrl + "/" + pictureName + ".png";
	}
}