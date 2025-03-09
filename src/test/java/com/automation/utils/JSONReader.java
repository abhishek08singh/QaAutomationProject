package com.automation.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class JSONReader {
    public static List<Map<String, String>> readJsonData(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File(filePath), List.class);
        } catch (IOException e) {
            throw new RuntimeException("❌ Error reading JSON file: " + filePath, e);
        }
    }
}
