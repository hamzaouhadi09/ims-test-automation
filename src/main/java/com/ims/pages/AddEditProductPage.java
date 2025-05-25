package com.ims.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AddEditProductPage {
    private WebDriver driver;

    private By nameInput = By.xpath("//label[text()='Product Name']/following-sibling::input");
    private By skuInput = By.xpath("//label[text()='Sku']/following-sibling::input");
    private By stockInput = By.xpath("//label[text()='Stock Quantity']/following-sibling::input");
    private By priceInput = By.xpath("//label[text()='Price']/following-sibling::input");
    private By descTextarea = By.xpath("//label[text()='Description']/following-sibling::textarea");
    private By categorySelect = By.xpath("//label[text()='Category']/following-sibling::select");
    private By imageInput = By.xpath("//input[@type='file']");
    private By submitButton = By.xpath("//button[@type='submit']");
    private By messageBox = By.cssSelector(".message");

    public AddEditProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillProductForm(String name, String sku, String stock, String price, String desc, String categoryId) {
        driver.findElement(nameInput).sendKeys(name);
        driver.findElement(skuInput).sendKeys(sku);
        driver.findElement(stockInput).sendKeys(stock);
        driver.findElement(priceInput).sendKeys(price);
        driver.findElement(descTextarea).sendKeys(desc);
        new Select(driver.findElement(categorySelect)).selectByValue(categoryId);
    }

    public void uploadImage(String absoluteFilePath) {
        driver.findElement(imageInput).sendKeys(absoluteFilePath);
    }

    public void submitProductForm() {
        driver.findElement(submitButton).click();
    }

    public String getMessage() {
        try {
            return driver.findElement(messageBox).getText();
        } catch (Exception e) {
            return "";
        }
    }

    public boolean isSuccessMessageDisplayed() {
        return getMessage().toLowerCase().contains("success");
    }
}
