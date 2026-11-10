package com.ayush.logdemo;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.Map;
import java.util.Properties;

public final class ConfigLoader {

    private ConfigLoader() {
    }

    // Reads a file from the classpath (src/main/resources)
    public static Properties loadProperties(String classpathResource) {
        Properties props = new Properties();
        try (InputStream in = ConfigLoader.class.getResourceAsStream(classpathResource)) {
            if (in == null) {
                throw new IllegalStateException("Config file not found on classpath: " + classpathResource);
            }
            props.load(in);
        } catch (IOException e) {
            throw new UncheckedIOException("Could not read " + classpathResource, e);
        }
        return props;
    }

    // The environment is a PARAMETER (not System.getenv() inside), so tests can pass any values
    public static AppConfig load(Properties file, Map<String, String> env) {
        String appName = value("app.name", "APP_NAME", "app", file, env);
        int port = parsePort(value("app.port", "APP_PORT", "8080", file, env));
        String dbUrl = value("db.url", "DB_URL", "jdbc:postgresql://localhost:5432/app", file, env);
        String dbPassword = required("db.password", "DB_PASSWORD", file, env);
        boolean debug = Boolean.parseBoolean(value("app.debug", "APP_DEBUG", "false", file, env));
        return new AppConfig(appName, port, dbUrl, dbPassword, debug);
    }

    // Priority: environment variable > properties file > default
    private static String value(String key, String envKey, String defaultValue,
                                Properties file, Map<String, String> env) {
        String fromEnv = env.get(envKey);
        if (fromEnv != null && !fromEnv.isBlank()) {
            return fromEnv.trim();
        }
        String fromFile = file.getProperty(key);
        if (fromFile != null && !fromFile.isBlank()) {
            return fromFile.trim();
        }
        return defaultValue;
    }

    // No default allowed: fail fast with a clear message
    private static String required(String key, String envKey,
                                   Properties file, Map<String, String> env) {
        String value = value(key, envKey, null, file, env);
        if (value == null) {
            throw new IllegalStateException(
                    "Missing required config: " + key + " (or environment variable " + envKey + ")");
        }
        return value;
    }

    private static int parsePort(String raw) {
        try {
            int port = Integer.parseInt(raw);
            if (port < 1 || port > 65535) {
                throw new IllegalStateException("app.port must be between 1 and 65535 but was: " + raw);
            }
            return port;
        } catch (NumberFormatException e) {
            throw new IllegalStateException("app.port must be a number but was: " + raw, e);
        }
    }
}