package com.nopcommerce.UI;

import com.nopcommerce.Base.TestBase;
import org.nopcommerce.com.Drivers.DriverManager;
import org.nopcommerce.com.Pages.HomePage;
import org.nopcommerce.com.Pages.Menu;
import org.nopcommerce.com.Pages.RegistrationPage;
import org.nopcommerce.com.Utilities.RandomUtils;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddProductAndCheckout extends TestBase {

    private static String firstName,lastName,email,password;
    private static HomePage homePage;

    @BeforeMethod
    public void setUp() {
        super.setUp();



    }
    @Test
    public void addProductToCart() {
        String productName = "Iphone 16";
        driver = new DriverManager().getDriver();
        System.out.println("Page title is: " + driver.getTitle());
        homePage = new HomePage(driver);
        homePage.searchProduct(productName);
        homePage.selectProduct(productName);

    }

    @AfterMethod
    public void cleanUp(ITestResult result) {
        driver.close();
        super.cleanUp(result);
    }
}
