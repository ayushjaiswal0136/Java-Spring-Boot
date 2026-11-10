package com.ayush.logdemo;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import org.yaml.snakeyaml.Yaml;

public class YamlDemo {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        try (InputStream in = YamlDemo.class.getResourceAsStream("/application.yml")) {
            Map<String, Object> root = new Yaml().load(in);

            Map<String, Object> app = (Map<String, Object>) root.get("app");
            List<String> features = (List<String>) root.get("features");

            Object port = app.get("port");
            Object debug = app.get("debug");

            System.out.println("app.name  = " + app.get("name"));
            System.out.println("app.port  = " + port + " (" + port.getClass().getSimpleName() + ")");
            System.out.println("app.debug = " + debug + " (" + debug.getClass().getSimpleName() + ")");
            System.out.println("features  = " + features);
        }
    }
}