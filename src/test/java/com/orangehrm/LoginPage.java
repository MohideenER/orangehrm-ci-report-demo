package com.orangehrm;
 
import java.time.Duration;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
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
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    	WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(username));
    	name.sendKeys(user);		
 
        Thread.sleep(3000);
        WebElement passwd = wait.until(ExpectedConditions.visibilityOfElementLocated(password));
    	passwd.sendKeys(pass);
        Thread.sleep(3000);
        WebElement loginbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(loginBtn));
        loginbtn.click();
    }
 
    public boolean isLoginSuccessful() throws InterruptedException {
    	Thread.sleep(3000);
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    	WebElement dashboardHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(dashboard));
        return dashboardHeader.isDisplayed();
    }
}
