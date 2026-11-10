package com.ayush.logdemo;

import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigDemo {

    private static final Logger log = LoggerFactory.getLogger(ConfigDemo.class);

    public static void main(String[] args) {
        Properties file = ConfigLoader.loadProperties("/application.properties");
        AppConfig config = ConfigLoader.load(file, System.getenv());

        log.info("Loaded config: {}", config);
        log.info("Java version (a system property): {}", System.getProperty("java.version"));
        log.info("Custom -D property app.mode: {}", System.getProperty("app.mode", "not set"));
    }
}