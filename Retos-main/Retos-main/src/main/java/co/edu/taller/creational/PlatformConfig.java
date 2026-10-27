package co.edu.taller.creational;

import java.util.HashMap;
import java.util.Map;

public class PlatformConfig {

    private static volatile PlatformConfig INSTANCE;

    private final Map<String, String> config = new HashMap<>();

    private PlatformConfig() {
        config.put("environment", "production");
    }

    public static PlatformConfig instance() {

        if (INSTANCE == null) {

            synchronized (PlatformConfig.class) {

                if (INSTANCE == null) {
                    INSTANCE = new PlatformConfig();
                }
            }
        }

        return INSTANCE;
    }

    public String get(String key) {

        if (key == null || key.isBlank()) {
            throw new IllegalArgumentException("Key is required");
        }

        return config.get(key);
    }
}