package com.ims.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    private WebDriver driver;

    private By dashboardText = By.cssSelector("div.dashboard-page");
    private By productNavLink = By.cssSelector("a[href='/product']");
    private By dashboardNavLink = By.cssSelector("a[href='/dashboard']");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDashboardDisplayed() {
        return driver.findElement(dashboardText).isDisplayed();
    }

    public ProductPage goToProductPage() {
        driver.findElement(productNavLink).click();
        return new ProductPage(driver);
    }

    public DashboardPage goToDashboardPage() {
        driver.findElement(dashboardNavLink).click();
        return this;
    }
}
