package com.orangehrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private By username = By.xpath("//input[contains(@name, 'username')]");
    private By password = By.xpath("//input[contains(@name, 'password')]");
    private By loginBtn = By.xpath("//button[@type='submit']");
    private By dashboard = By.xpath("//h6[text()='Dashboard']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String user, String pass) throws InterruptedException {
    	Thread.sleep(10000);
        driver.findElement(username).sendKeys(user);
        Thread.sleep(3000);
        driver.findElement(password).sendKeys(pass);
        Thread.sleep(3000);
        driver.findElement(loginBtn).click();
    }

    public boolean isLoginSuccessful() throws InterruptedException {
    	Thread.sleep(3000);
        return driver.findElements(dashboard).size() > 0;
    }
}
