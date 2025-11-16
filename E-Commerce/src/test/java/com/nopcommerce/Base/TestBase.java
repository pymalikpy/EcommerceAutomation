package com.nopcommerce.Base;

import org.nopcommerce.com.Drivers.DriverManager;
import org.nopcommerce.com.Utilities.ScreenshotUtility;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected WebDriver driver;
    private DriverManager driverManager;

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        driverManager = new DriverManager();
        driver = driverManager.getDriver();
        driverManager.navigateToApp();
    }

    @AfterMethod(alwaysRun = true)
    public void cleanUp(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus()){
            ScreenshotUtility.takeScreenshot(driver,result.getName());
        }
        if(driverManager!=null){
            driverManager.quitDriver();
        }

    }
}
