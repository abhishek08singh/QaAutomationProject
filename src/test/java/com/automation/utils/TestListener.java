package com.automation.utils;

import com.automation.base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.*;

import java.util.ArrayList;
import java.util.List;

public class TestListener implements ITestListener, IReporter {
    private static final Logger logger = LogManager.getLogger(TestListener.class);
    private List<String> passedTests = new ArrayList<>();
    private List<String> failedTests = new ArrayList<>();
    private List<String> skippedTests = new ArrayList<>();

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("\n********************************************");
        logger.info("🚀 STARTING TEST: " + result.getMethod().getMethodName());
        logger.info("********************************************\n");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("✅ TEST PASSED: " + result.getMethod().getMethodName());
        passedTests.add(result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("❌ TEST FAILED: " + result.getMethod().getMethodName());
        failedTests.add(result.getMethod().getMethodName());

        // Capture screenshot on failure
        Object testInstance = result.getInstance();
        if (testInstance instanceof BaseTest) { // ✅ Check if the test class extends BaseTest
            WebDriver driver = ((BaseTest) testInstance).getDriver(); // Get WebDriver from BaseTest
            if (driver != null) {
                ScreenshotUtil.takeScreenshot(driver, result.getMethod().getMethodName());
            } else {
                logger.error("⚠️ WebDriver is NULL. Screenshot not captured.");
            }
        } else {
            logger.error("⚠️ Test instance is not a BaseTest. Cannot capture screenshot.");
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn("⚠️ TEST SKIPPED: " + result.getMethod().getMethodName());
        skippedTests.add(result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("\n\n********************************************");
        logger.info("🔴 TEST EXECUTION SUMMARY");
        logger.info("********************************************\n");

        logger.info("✅ Passed Tests: " + passedTests.size());
        for (String test : passedTests) {
            logger.info("   - " + test);
        }

        logger.error("❌ Failed Tests: " + failedTests.size());
        for (String test : failedTests) {
            logger.error("   - " + test);
        }

        logger.warn("⚠️ Skipped Tests: " + skippedTests.size());
        for (String test : skippedTests) {
            logger.warn("   - " + test);
        }

        logger.info("\n********************************************\n");
    }
}
