package com.ims.tests;


import com.ims.Base.BaseTest;
import com.ims.pages.DashboardPage;
import com.ims.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthenticationTests extends BaseTest {

    @Test
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "Login page should be displayed");

        DashboardPage dashboardPage = loginPage.login("admin@gmail.com", "nimda");
        Assert.assertTrue(dashboardPage.isDashboardDisplayed(), "Dashboard should be visible after login");
    }

    @Test
    public void testInvalidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "Login page should be displayed");

        loginPage.login("wrong@email.com", "wrongpass");
        Assert.assertTrue(loginPage.getMessage().length() > 0, "Error message should be displayed");
    }
}
