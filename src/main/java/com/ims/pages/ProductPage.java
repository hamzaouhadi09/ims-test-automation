package com.ims.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import java.util.List;
import com.ims.utils.ExtentManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ProductPage {

    private WebDriver driver;

    // Locators
    private By productPageContainer = By.cssSelector(".product-page");
    private By addProductButton = By.cssSelector(".add-product-btn");
    private By productItems = By.cssSelector(".product-item");
    private By messageBox = By.cssSelector(".message");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductPageDisplayed() {
        return driver.findElement(productPageContainer).isDisplayed();
    }

    public void clickAddProduct() {
        driver.findElement(addProductButton).click();
    }

    public boolean isProductListed(String productName) {
        List<WebElement> products = driver.findElements(productItems);
        for (WebElement item : products) {
            String name = item.findElement(By.cssSelector(".name")).getText();
            if (name.equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }

    public void deleteProductByName(String productName) {
        List<WebElement> products = driver.findElements(productItems);
        for (WebElement item : products) {
            String name = item.findElement(By.cssSelector(".name")).getText();
            if (name.equalsIgnoreCase(productName)) {
                item.findElement(By.cssSelector(".delete-btn")).click();
                driver.switchTo().alert().accept(); // confirm alert
                break;
            }
        }
    }

    public String getMessage() {
        try {
            return driver.findElement(messageBox).getText();
        } catch (Exception e) {
            return "";
        }
    }

    public boolean isErrorMessageDisplayed() {
        return !getMessage().isEmpty();
    }
}
