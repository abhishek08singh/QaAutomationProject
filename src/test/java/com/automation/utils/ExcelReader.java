package com.automation.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class ExcelReader {
    public static List<Map<String, String>> readExcelData(String filePath, String sheetName) {
        List<Map<String, String>> dataList = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) throw new RuntimeException("❌ Sheet not found: " + sheetName);

            Row headerRow = sheet.getRow(0);
            int columnCount = headerRow.getPhysicalNumberOfCells();

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                Map<String, String> dataMap = new HashMap<>();
                for (int j = 0; j < columnCount; j++) {
                    dataMap.put(headerRow.getCell(j).getStringCellValue(), row.getCell(j).getStringCellValue());
                }
                dataList.add(dataMap);
            }
        } catch (IOException e) {
            throw new RuntimeException("❌ Error reading Excel file: " + filePath, e);
        }
        return dataList;
    }
}
