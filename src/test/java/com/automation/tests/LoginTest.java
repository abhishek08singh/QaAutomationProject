package com.automation.tests;

import com.automation.base.BaseTest;
import com.automation.utils.ConfigReader;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void launchUrl() {
        navigateToUrl("saucedemo");
    }

    @Test
    public void testValidLogin() {
        loginPage.login("standard_user", "secret_sauce");
        homePage.validateUserHasLandedOnHomePage();
    }
}
