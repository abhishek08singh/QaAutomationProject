package com.automation.utils;

import org.yaml.snakeyaml.Yaml;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class YamlReader {
    public static List<Map<String, String>> readYamlData(String filePath) {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            Yaml yaml = new Yaml();
            return yaml.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("❌ Error reading YAML file: " + filePath, e);
        }
    }
}
