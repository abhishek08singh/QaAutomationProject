package com.automation.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelReader {
    private static final String FILE_PATH = "src/test/resources/TestData/test-data.xlsx";
    private static Map<String, String> excelData = new HashMap<>();

    static {
        try (FileInputStream fis = new FileInputStream(FILE_PATH);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0); // Read from the first sheet
            Row headerRow = sheet.getRow(0); // Assuming first row is header
            Row dataRow = sheet.getRow(1); // Assuming second row contains data

            if (headerRow != null && dataRow != null) {
                for (int i = 0; i < headerRow.getPhysicalNumberOfCells(); i++) {
                    String key = headerRow.getCell(i).getStringCellValue();
                    String value = dataRow.getCell(i).getStringCellValue();
                    excelData.put(key, value);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("❌ Error reading Excel file: " + FILE_PATH, e);
        }
    }

    public static String readExcelData(String key) {
        System.out.println("Reading "+ key +" from Excel file" );
        return excelData.getOrDefault(key, "❌ Key not found: " + key);
    }
}
//Data in Excel assuming is stored in this format then this code will work
/*username	     password
standard_user	secret_sauce*/