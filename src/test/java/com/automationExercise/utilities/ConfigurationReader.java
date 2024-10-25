package com.automationExercise.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private static final Properties properties = new Properties();

    static {
        try {
            // Dosya yolunu kontrol edin
            FileInputStream file = new FileInputStream("src/test/resources/configuration.properties");
            properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load configuration file.");
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
