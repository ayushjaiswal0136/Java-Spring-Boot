package com.ayush.logdemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;
import java.util.Properties;
import org.junit.jupiter.api.Test;

class ConfigLoaderTest {

    private Properties fileWithPassword() {
        Properties p = new Properties();
        p.setProperty("db.password", "file-secret");
        return p;
    }

    @Test
    void usesDefaultWhenNothingIsProvided() {
        AppConfig config = ConfigLoader.load(fileWithPassword(), Map.of());
        assertEquals(8080, config.port());
        assertEquals("app", config.appName());
    }

    @Test
    void fileOverridesDefault() {
        Properties file = fileWithPassword();
        file.setProperty("app.port", "9000");
        assertEquals(9000, ConfigLoader.load(file, Map.of()).port());
    }

    @Test
    void environmentOverridesFile() {
        Properties file = fileWithPassword();
        file.setProperty("app.port", "9000");
        AppConfig config = ConfigLoader.load(file, Map.of("APP_PORT", "7000"));
        assertEquals(7000, config.port());
    }

    @Test
    void nonNumericPortFailsFast() {
        IllegalStateException ex = assertThrows(IllegalStateException.class,
                () -> ConfigLoader.load(fileWithPassword(), Map.of("APP_PORT", "abc")));
        assertTrue(ex.getMessage().contains("app.port"));
    }

    @Test
    void portOutOfRangeFailsFast() {
        assertThrows(IllegalStateException.class,
                () -> ConfigLoader.load(fileWithPassword(), Map.of("APP_PORT", "70000")));
    }

    @Test
    void missingPasswordFailsFast() {
        IllegalStateException ex = assertThrows(IllegalStateException.class,
                () -> ConfigLoader.load(new Properties(), Map.of()));
        assertTrue(ex.getMessage().contains("DB_PASSWORD"));
    }

    @Test
    void toStringNeverShowsThePassword() {
        AppConfig config = ConfigLoader.load(fileWithPassword(), Map.of());
        assertFalse(config.toString().contains("file-secret"));
    }
}