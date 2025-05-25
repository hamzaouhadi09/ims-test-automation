package com.ims.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.ims.utils.ExtentManager;

public class AddProductPage extends BasePage {

    @FindBy(name = "name")
    private WebElement productNameField;

    @FindBy(name = "description")
    private WebElement descriptionField;

    @FindBy(name = "price")
    private WebElement priceField;

    @FindBy(name = "quantity")
    private WebElement quantityField;

    @FindBy(name = "category")
    private WebElement categoryDropdown;

    @FindBy(xpath = "//button[contains(text(),'Save') or @type='submit']")
    private WebElement saveButton;

    @FindBy(xpath = "//button[contains(text(),'Cancel')]")
    private WebElement cancelButton;

    @FindBy(xpath = "//div[contains(@class,'error') or contains(@class,'validation')]")
    private WebElement validationError;

    @FindBy(xpath = "//div[contains(@class,'success')]")
    private WebElement successMessage;

    public AddProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void fillProductForm(String name, String description, String price,
                                String quantity, String category) {
        ExtentManager.logInfo("Filling product form for: " + name);

        sendKeys(productNameField, name);
        sendKeys(descriptionField, description);
        sendKeys(priceField, price);
        sendKeys(quantityField, quantity);

        if (isDisplayed(categoryDropdown)) {
            Select categorySelect = new Select(categoryDropdown);
            categorySelect.selectByVisibleText(category);
        }
    }

    public ProductsPage saveProduct() {
        ExtentManager.logInfo("Saving product");
        click(saveButton);
        waitForPageLoad();
        return new ProductsPage(driver);
    }

    public ProductsPage cancelAddProduct() {
        ExtentManager.logInfo("Cancelling add product");
        click(cancelButton);
        waitForPageLoad();
        return new ProductsPage(driver);
    }

    public boolean isValidationErrorDisplayed() {
        return isDisplayed(validationError);
    }

    public String getValidationError() {
        if (isValidationErrorDisplayed()) {
            return getText(validationError);
        }
        return "";
    }

    public boolean isSuccessMessageDisplayed() {
        return isDisplayed(successMessage);
    }
}

