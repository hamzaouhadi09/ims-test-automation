package com.ims.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private By emailInput = By.xpath("//input[@type='email']");
    private By passwordInput = By.xpath("//input[@type='password']");
    private By loginButton = By.xpath("//button[text()='Login']");
    private By messageBox = By.cssSelector(".message");
    private By heading = By.xpath("//h2[text()='Login']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isLoginPageDisplayed() {
        return driver.findElement(heading).isDisplayed();
    }

    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public String getMessage() {
        return driver.findElement(messageBox).getText();
    }

    public DashboardPage login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLogin();
        return new DashboardPage(driver);
    }
}
