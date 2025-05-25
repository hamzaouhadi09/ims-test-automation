package com.ims.tests;
// ProductTests.java


import com.ims.Base.BaseTest;
import com.ims.pages.AddEditProductPage;
import com.ims.pages.DashboardPage;
import com.ims.pages.LoginPage;
import com.ims.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductTests extends BaseTest {

    private ProductPage productPage;

    @BeforeMethod
    public void loginAndNavigateToProductPage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin@gmail.com", "nimda");

        DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.isDashboardDisplayed(), "Dashboard should be displayed");

        productPage = dashboardPage.goToProductPage();
        Assert.assertTrue(productPage.isProductPageDisplayed(), "Product page should be displayed");
    }

    @Test(description = "TC101: Add a new product with valid data")
    public void testAddProductValidData() {
        productPage.clickAddProduct();
        AddEditProductPage form = new AddEditProductPage(driver);

        form.fillProductForm("Laptop Pro", "SKU12345", "15", "1299.99", "High-end laptop", "1");
        form.uploadImage("C:\\Users\\HAMZA\\Desktop");
        form.submitProductForm();

        Assert.assertTrue(form.isSuccessMessageDisplayed(), "Product should be successfully added");
    }

    @Test(description = "TC102: Attempt to add product with invalid/missing data")
    public void testAddProductInvalidData() {
        productPage.clickAddProduct();
        AddEditProductPage form = new AddEditProductPage(driver);

        // Leave required fields empty or invalid
        form.fillProductForm("hdf", "", "-5", "", "", "");
        form.submitProductForm();
        String message = form.getMessage();
        System.out.println("Captured message: " + message);
        Assert.assertTrue(message != null && !message.isEmpty(), "Expected an error or feedback message for invalid product submission.");
    }
}
