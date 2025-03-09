package com.automation.tests;

import com.automation.base.BaseTest;
import com.automation.utils.*;
import com.opencsv.CSVReader;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class LoginTest extends BaseTest {

    @Test
    public void launchUrl() {
        navigateToUrl("saucedemo");
    }

    //Read credentials from config.properties file
    //@Test
    public void testValidLogin1() {
        String username = ConfigReader.getProperty("username");
        String password = ConfigReader.getProperty("password");
        loginPage.login(username, password);
        homePage.validateUserHasLandedOnHomePage();
    }

    //Read credentials from JSON file
    //@Test
    public void testValidLogin2() {
        String username = JSONReader.readJsonData("username");
        String password = JSONReader.readJsonData("password");
        loginPage.login(username, password);
        homePage.validateUserHasLandedOnHomePage();
    }

    //Read credentials from Yaml file
    //@Test
    public void testValidLogin3() {
        String username = YamlReader.readYamlData("username");
        String password = YamlReader.readYamlData("password");
        loginPage.login(username, password);
        homePage.validateUserHasLandedOnHomePage();
    }

    //Read credentials from Excel file
    //@Test
    public void testValidLogin4() {
        String username = ExcelReader.readExcelData("username");
        String password = ExcelReader.readExcelData("password");;
        loginPage.login(username, password);
        homePage.validateUserHasLandedOnHomePage();
    }

    //Read credentials from CCV file
    @Test
    public void testValidLogin5() {
        String username = CsvReaderUtil.readCsvData("username");
        String password = CsvReaderUtil.readCsvData("password");;
        loginPage.login(username, password);
        homePage.validateUserHasLandedOnHomePage();
    }
}
