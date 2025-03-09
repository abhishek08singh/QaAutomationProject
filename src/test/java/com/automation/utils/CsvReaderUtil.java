package com.automation.utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CsvReaderUtil {
    public static List<Map<String, String>> readCsvData(String filePath) {
        List<Map<String, String>> dataList = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> data = reader.readAll();
            if (data.isEmpty()) return dataList;

            String[] headers = data.get(0);
            for (int i = 1; i < data.size(); i++) {
                Map<String, String> row = new HashMap<>();
                for (int j = 0; j < headers.length; j++) {
                    row.put(headers[j], data.get(i)[j]);
                }
                dataList.add(row);
            }
        } catch (IOException | CsvException e) {
            throw new RuntimeException("❌ Error reading CSV file: " + filePath, e);
        }
        return dataList;
    }
}

