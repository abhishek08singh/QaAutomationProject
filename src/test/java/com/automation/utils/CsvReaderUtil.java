package com.automation.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CsvReaderUtil {
    private static final String FILE_PATH = "src/test/resources/TestData/test-data.csv";
    private static Map<String, String> csvData = new HashMap<>();

    static {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String[] headers = br.readLine().split(","); // First line is header
            String[] values = br.readLine().split(","); // Second line is data

            for (int i = 0; i < headers.length; i++) {
                csvData.put(headers[i].trim(), values[i].trim());
            }
        } catch (IOException e) {
            throw new RuntimeException("❌ Error reading CSV file: " + FILE_PATH, e);
        }
    }

    public static String readCsvData(String key) {
        System.out.println("Reading "+ key +" from CSV file" );
        return csvData.getOrDefault(key, "❌ Key not found: " + key);
    }
}
