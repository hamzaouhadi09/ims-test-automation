package com.ims.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import java.util.List;
import com.ims.utils.ExtentManager;

public class CategoriesPage extends BasePage {

    @FindBy(xpath = "//h1[contains(text(),'Categories')]")
    private WebElement pageTitle;

    @FindBy(xpath = "//button[contains(text(),'Add Category')]")
    private WebElement addCategoryButton;

    @FindBy(xpath = "//table//tbody//tr")
    private List<WebElement> categoryRows;

    @FindBy(name = "categoryName")
    private WebElement categoryNameField;

    @FindBy(name = "categoryDescription")
    private WebElement categoryDescriptionField;

    @FindBy(xpath = "//button[contains(text(),'Save Category')]")
    private WebElement saveCategoryButton;

    public CategoriesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isCategoriesPageDisplayed() {
        boolean isDisplayed = isDisplayed(pageTitle);
        ExtentManager.logInfo("Categories page displayed: " + isDisplayed);
        return isDisplayed;
    }

    public void addCategory(String name, String description) {
        ExtentManager.logInfo("Adding category: " + name);
        click(addCategoryButton);
        sendKeys(categoryNameField, name);
        sendKeys(categoryDescriptionField, description);
        click(saveCategoryButton);
        waitForPageLoad();
    }

    public boolean isCategoryDisplayed(String categoryName) {
        for (WebElement row : categoryRows) {
            if (row.getText().contains(categoryName)) {
                ExtentManager.logInfo("Category found: " + categoryName);
                return true;
            }
        }
        ExtentManager.logInfo("Category not found: " + categoryName);
        return false;
    }

    public int getCategoriesCount() {
        return categoryRows.size();
    }

    public void deleteCategory(String categoryName) {
        for (WebElement row : categoryRows) {
            if (row.getText().contains(categoryName)) {
                WebElement deleteButton = row.findElement(
                        By.xpath(".//button[contains(@class,'delete')]"));
                click(deleteButton);
                waitForPageLoad();
                ExtentManager.logInfo("Category deleted: " + categoryName);
                break;
            }
        }
    }
}

