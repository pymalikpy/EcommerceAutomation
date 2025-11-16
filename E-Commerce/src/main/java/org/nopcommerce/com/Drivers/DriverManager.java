package org.nopcommerce.com.Drivers;

import org.nopcommerce.com.Pages.HomePage;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DriverManager {

    private static ThreadLocal <WebDriver> driver = new ThreadLocal<>();
    private Properties config;

    public DriverManager(){
        loadConfig();
    }

    private void loadConfig(){
        config = new Properties();
        try{
            FileInputStream inputStream = new FileInputStream("src/main/resources/config.properties");
            config.load(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public WebDriver getDriver() {
        if(driver.get()==null){
        String browserType = config.getProperty("browser.type");
        boolean headless = Boolean.parseBoolean(config.getProperty("browser.headless"));
        boolean maximize = Boolean.parseBoolean(config.getProperty("browser.maximize"));
        boolean ignoreCertErrors = Boolean.parseBoolean(config.getProperty("browser.ignoreCertErrors"));

        WebDriver newDriver = WebDriverFactory.createDriver(browserType, headless, maximize, ignoreCertErrors);
        driver.set(newDriver);}
        return driver.get();
    }
    public void quitDriver() {
        if (driver != null) {
            driver.get().quit();
            driver.remove();
        }
    }
    public void navigateToApp(){
        String appURL = config.getProperty("app.url");
        System.out.println("Navigating to: " + appURL);
        getDriver().get(appURL);
    }
}
