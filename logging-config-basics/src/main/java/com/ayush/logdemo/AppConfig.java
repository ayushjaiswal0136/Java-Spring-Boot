package com.ayush.logdemo;

public record AppConfig(String appName, int port, String dbUrl, String dbPassword, boolean debug) {

    // Override toString so the password can never leak into a log line
    @Override
    public String toString() {
        return "AppConfig[appName=" + appName + ", port=" + port + ", dbUrl=" + dbUrl
                + ", dbPassword=****, debug=" + debug + "]";
    }
}