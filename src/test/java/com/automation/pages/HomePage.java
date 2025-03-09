package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage extends BasePage{

    @FindBy(xpath= "//span[text()='Products']")
    private WebElement products;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void validateUserHasLandedOnHomePage(){
        Assert.assertTrue(products.isDisplayed(),"User is NOT on the Home Page!");
        logger.info("Test completed: Valid Login");
    }
}
