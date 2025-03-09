package com.automation.base;

import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.utils.ConfigReader;
import com.automation.utils.TestListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.time.Duration;

@Listeners(TestListener.class)
public class BaseTest {
    protected WebDriver driver;
    protected static final Logger logger = LogManager.getLogger(BaseTest.class);

    protected LoginPage loginPage;
    protected HomePage homePage;

    @BeforeClass
    public void setup() {
        // Read browser type from config file
        String browser = ConfigReader.getProperty("browser");
        logger.info("📌 Selected Browser: " + browser);

        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("❌ Unsupported browser: " + browser);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Initialize Page Objects
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    protected void navigateToUrl(String key) {
        String url = ConfigReader.getProperty(key);
        if (url == null) {
            throw new RuntimeException("❌ URL not found in config file for key: " + key);
        }
        driver.get(url);
        logger.info("🌍 Navigated to: " + url);
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
            logger.info("🛑 Browser closed successfully.");
        }

    }
}
