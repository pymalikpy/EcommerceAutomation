package com.nopcommerce.UI;

import com.nopcommerce.Base.TestBase;
import org.nopcommerce.com.Drivers.DriverManager;
import org.nopcommerce.com.Pages.Menu;
import org.nopcommerce.com.Pages.RegistrationPage;
import org.nopcommerce.com.Utilities.RandomUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class NavigationTest extends TestBase {

    @BeforeMethod
    public void setUp() {
        super.setUp();

    }
    @Test
    public void sampleTest() {
        driver = new DriverManager().getDriver();
        System.out.println("Page title is: " + driver.getTitle());
        RegistrationPage register = new Menu(driver).goToRegistration();
        register.waitUntilLoaded();
        register.selectGender("male");
        String firstName = RandomUtils.generateRandomAlphaString(5);
        String lastName = RandomUtils.generateRandomAlphaString(6);
        register.inputName(firstName,lastName);
    }

    @AfterMethod
    public void cleanUp(ITestResult result) {
        driver.close();
        super.cleanUp(result);
    }
}
