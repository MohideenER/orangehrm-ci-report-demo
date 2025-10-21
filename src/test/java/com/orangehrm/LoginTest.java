package com.orangehrm;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "Verify valid login to OrangeHRM")
    @Description("Test Description: Login with valid credentials and verify dashboard is displayed.")
    public void testLogin() throws InterruptedException {
        LoginPage login = new LoginPage(driver);
        login.login("Admin", "admin123");
        Assert.assertTrue(login.isLoginSuccessful(), "Login should be successful.");
    }
}
