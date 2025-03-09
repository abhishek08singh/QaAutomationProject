package com.automation.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static void takeScreenshot(WebDriver driver, String testName) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String timestamp = formatter.format(new Date());

        // Get the absolute path of the Screenshots folder under resources
        String screenshotDir = System.getProperty("user.dir") + "/src/test/resources/Screenshots";
        File dir = new File(screenshotDir);
        if (!dir.exists()) {
            dir.mkdirs();  // Create directory if it doesn't exist
        }

        // Define the screenshot file path
        String destPath = screenshotDir + "/" + testName + "_" + timestamp + ".png";
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(srcFile, new File(destPath));
            System.out.println("Screenshot saved at: " + destPath);
        } catch (IOException e) {
            System.out.println("Failed to take screenshot: " + e.getMessage());
        }
    }
}
