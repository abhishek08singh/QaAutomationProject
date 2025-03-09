package com.automation.pages;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected static final Logger logger = LogManager.getLogger(BasePage.class);
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        logger.info("Clicked on element: " + element);
    }

    public void enterText(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
        logger.info("Entered text '" + text + "' in element: " + element);
    }

    public String getText(WebElement element) {
        String text = wait.until(ExpectedConditions.visibilityOf(element)).getText();
        logger.info("Extracted text: " + text);
        return text;
    }
}
