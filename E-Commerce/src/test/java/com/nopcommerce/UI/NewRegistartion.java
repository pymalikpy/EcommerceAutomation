package com.nopcommerce.UI;

import com.nopcommerce.Base.TestBase;
import org.nopcommerce.com.Drivers.DriverManager;
import org.nopcommerce.com.Pages.Menu;
import org.nopcommerce.com.Pages.RegistrationPage;
import org.nopcommerce.com.Utilities.RandomUtils;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewRegistartion extends TestBase {

    private static String firstName,lastName,email,password;
    private static RegistrationPage registrationPage;

    @BeforeMethod
    public void setUp() {
        super.setUp();
        registrationPage = new Menu(driver).goToRegistration().waitUntilLoaded();
        firstName = RandomUtils.generateRandomAlphaString(5);
        lastName = RandomUtils.generateRandomAlphaString(6);
        email = firstName + "." + lastName + "@email.com";
        password = RandomUtils.generateRandomAlphaNumericString(9);

    }
    @Test
    public void registerNewUser() {
        driver = new DriverManager().getDriver();
        System.out.println("Page title is: " + driver.getTitle());
        registrationPage.addNewUser(firstName,lastName,email,password);
        registrationPage.selectContinue();

    }

    @AfterMethod
    public void cleanUp(ITestResult result) {
        driver.close();
        super.cleanUp(result);
    }
}
