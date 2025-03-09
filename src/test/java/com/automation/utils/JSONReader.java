package com.automation.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class JSONReader {
    private static final String FILE_PATH = "src/test/resources/TestData/test-data.json";
    private static Map<String, String> jsonData;

    // Load JSON data once to avoid multiple file reads
    static {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<Map<String, String>> dataList = objectMapper.readValue(new File(FILE_PATH), List.class);
            if (!dataList.isEmpty()) {
                jsonData = dataList.get(0); // Assuming the first object in JSON contains the required data
            }
        } catch (IOException e) {
            throw new RuntimeException("❌ Error reading JSON file: " + FILE_PATH, e);
        }
    }

    // Fetch any key dynamically
    public static String readJsonData(String key) {
        System.out.println("Reading "+ key +" from JSOn file" );
        return jsonData.getOrDefault(key, "❌ Key not found: " + key);
    }
}
