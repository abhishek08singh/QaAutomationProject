package com.automation.utils;

import org.yaml.snakeyaml.Yaml;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Logger;

public class YamlReader {
    private static final String FILE_PATH = "src/test/resources/TestData/test-data.yaml";
    private static Map<String, String> yamlData;

    // Load YAML data once to avoid multiple file reads
    static {
        try (FileInputStream fis = new FileInputStream(FILE_PATH)) {
            Yaml yaml = new Yaml();
            yamlData = yaml.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("❌ Error reading YAML file: " + FILE_PATH, e);
        }
    }

    // Fetch any key dynamically
    public static String readYamlData(String key) {
        System.out.println("Reading "+ key +" from Yaml file" );
        return yamlData.getOrDefault(key, "❌ Key not found: " + key);
    }
}
