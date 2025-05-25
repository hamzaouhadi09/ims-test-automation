package com.ims.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import java.util.List;
import com.ims.utils.ExtentManager;

public class ProductsPage extends BasePage {

    @FindBy(xpath = "//h1[contains(text(),'Products')]")
    private WebElement pageTitle;

    @FindBy(xpath = "//button[contains(text(),'Add Product') or contains(@class,'add-product')]")
    private WebElement addProductButton;

    @FindBy(xpath = "//input[@placeholder='Search products' or @name='search']")
    private WebElement searchInput;

    @FindBy(xpath = "//button[contains(text(),'Search') or @type='submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//table//tbody//tr")
    private List<WebElement> productRows;

    @FindBy(xpath = "//div[contains(@class,'no-data') or contains(text(),'No products')]")
    private WebElement noDataMessage;

    public ProductsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isProductsPageDisplayed() {
        boolean isDisplayed = isDisplayed(pageTitle);
        ExtentManager.logInfo("Products page displayed: " + isDisplayed);
        return isDisplayed;
    }

    public AddProductPage clickAddProduct() {
        ExtentManager.logInfo("Clicking Add Product button");
        click(addProductButton);
        waitForPageLoad();
        return new AddProductPage(driver);
    }

    public void searchProduct(String productName) {
        ExtentManager.logInfo("Searching for product: " + productName);
        sendKeys(searchInput, productName);
        click(searchButton);
        waitForPageLoad();
    }

    public int getProductsCount() {
        return productRows.size();
    }

    public boolean isProductDisplayed(String productName) {
        for (WebElement row : productRows) {
            if (row.getText().contains(productName)) {
                ExtentManager.logInfo("Product found: " + productName);
                return true;
            }
        }
        ExtentManager.logInfo("Product not found: " + productName);
        return false;
    }

    public void deleteProduct(String productName) {
        for (WebElement row : productRows) {
            if (row.getText().contains(productName)) {
                WebElement deleteButton = row.findElement(
                        By.xpath(".//button[contains(@class,'delete') or contains(text(),'Delete')]"));
                click(deleteButton);

                // Handle confirmation dialog if present
                try {
                    WebElement confirmButton = driver.findElement(
                            By.xpath("//button[contains(text(),'Confirm') or contains(text(),'Yes')]"));
                    click(confirmButton);
                } catch (Exception e) {
                    // No confirmation dialog
                }

                waitForPageLoad();
                ExtentManager.logInfo("Product deleted: " + productName);
                break;
            }
        }
    }

    public void editProduct(String productName) {
        for (WebElement row : productRows) {
            if (row.getText().contains(productName)) {
                WebElement editButton = row.findElement(
                        By.xpath(".//button[contains(@class,'edit') or contains(text(),'Edit')]"));
                click(editButton);
                waitForPageLoad();
                ExtentManager.logInfo("Editing product: " + productName);
                break;
            }
        }
    }
}
