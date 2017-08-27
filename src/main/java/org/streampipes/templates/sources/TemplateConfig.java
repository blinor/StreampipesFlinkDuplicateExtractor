package org.streampipes.templates.sources;

import org.streampipes.config.SpConfig;

public enum TemplateConfig {
    INSTANCE;

    private SpConfig config;
    private final static String HOST = "host";
    private final static String PORT = "port";
    private final static String KAFKA_HOST = "kafka_host";
    private final static String KAFKA_PORT = "kafka_port";
    private final static String ZOOKEEPER_HOST = "zookeeper_host";
    private final static String ZOOKEEPER_PORT = "zookeeper_port";



    public final static String serverUrl;
    public final static String iconBaseUrl;

    TemplateConfig() {
        config = SpConfig.getSpConfig("pe/org.streampipes.templates.sources");
        config.register(HOST, "template-sources", "Hostname for the pe templates project");
        config.register(PORT, 8090, "Port for the pe slack integration");
        config.register(KAFKA_HOST, "kafka", "Host for kafka of the pe sinks project");
        config.register(KAFKA_PORT, 9092, "Port for kafka of the pe sinks project");
        config.register(ZOOKEEPER_HOST, "zookeeper", "Host for zookeeper of the pe sinks project");
        config.register(ZOOKEEPER_PORT, 2181, "Port for zookeeper of the pe sinks project");
    }

    static {
        serverUrl = TemplateConfig.INSTANCE.getHost() + ":" + TemplateConfig.INSTANCE.getPort();
        iconBaseUrl = TemplateConfig.INSTANCE.getHost() + ":" + TemplateConfig.INSTANCE.getPort() +"/img";
    }

    public String getHost() {
        return config.getString(HOST);
    }

    public int getPort() {
        return config.getInteger(PORT);
    }

    public String getKafkaHost() {
        return config.getString(KAFKA_HOST);
    }

    public int getKafkaPort() {
        return config.getInteger(KAFKA_PORT);
    }

    public String getKafkaUrl() {
        return getKafkaHost() + ":" + getKafkaPort();
    }

    public String getZookeeperHost() {
        return config.getString(ZOOKEEPER_HOST);
    }

    public int getZookeeperPort() {
        return config.getInteger(ZOOKEEPER_PORT);
    }

}
