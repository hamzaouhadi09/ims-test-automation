package com.ims.dataproviders;



import org.testng.annotations.DataProvider;
import com.ims.models.Product;
import com.ims.models.User;

public class TestDataProvider {

    @DataProvider(name = "validUsers")
    public Object[][] getValidUsers() {
        return new Object[][] {
                {"admin", "admin123", "admin"},
                {"user", "user123", "user"}
        };
    }

    @DataProvider(name = "invalidUsers")
    public Object[][] getInvalidUsers() {
        return new Object[][] {
                {"admin", "wrongpass", "admin"},
                {"wronguser", "admin123", "admin"},
                {"", "", ""},
                {"admin", "", "admin"},
                {"", "admin123", "admin"}
        };
    }

    @DataProvider(name = "validProducts")
    public Object[][] getValidProducts() {
        return new Object[][] {
                {"Laptop Dell", "High performance laptop", "1200.00", "10", "Electronics"},
                {"iPhone 13", "Latest Apple smartphone", "999.99", "15", "Electronics"},
                {"Office Chair", "Ergonomic office chair", "250.00", "25", "Furniture"},
                {"Desk Lamp", "LED desk lamp", "45.99", "50", "Furniture"}
        };
    }

    @DataProvider(name = "invalidProducts")
    public Object[][] getInvalidProducts() {
        return new Object[][] {
                {"", "Description", "100.00", "10", "Electronics"}, // Empty name
                {"Product", "", "100.00", "10", "Electronics"}, // Empty description
                {"Product", "Description", "-100", "10", "Electronics"}, // Negative price
                {"Product", "Description", "abc", "10", "Electronics"}, // Invalid price
                {"Product", "Description", "100.00", "-5", "Electronics"} // Negative quantity
        };
    }
}
