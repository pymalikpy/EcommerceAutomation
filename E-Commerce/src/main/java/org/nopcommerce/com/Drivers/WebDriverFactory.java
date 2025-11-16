package org.nopcommerce.com.Drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverFactory {

    public static WebDriver createDriver(String browserType,boolean headless, boolean maximize, boolean ignoreCerts){
        WebDriver driver = null;

        switch (browserType.toUpperCase()){
            case "FIREFOX":
                driver = createFirefoxDriver(headless,maximize,ignoreCerts);
                break;
            case "CHROME":
                driver = createChromeDriver(headless, maximize, ignoreCerts);
                break;
            case "EDGE":
                driver = createEdgeDriver(headless,maximize,ignoreCerts);
            default:
                throw new IllegalArgumentException("Unknow browser type: " + browserType);
        }
        return driver;

    }

    private static WebDriver createChromeDriver(boolean headless, boolean maximize, boolean ignoreCerts){
        ChromeOptions options = new ChromeOptions();

        if(headless){
            options.addArguments("--headless");
        }
        if(maximize){
            options.addArguments("--start-maximized");
        }
        if(ignoreCerts){
            options.addArguments("--ignore-certificate-errors");
        }
        options.addArguments("--remote-allow-origins=*");

        options.setAcceptInsecureCerts(true);
        return new ChromeDriver(options);
    }

    private static WebDriver createFirefoxDriver(boolean headless, boolean maximize, boolean ignoreCertErrors) {
        FirefoxOptions options = new FirefoxOptions();

        if (headless) {
            options.addArguments("--headless");
        }
        if (maximize) {
            options.addArguments("--width=1920", "--height=1080");
        }
        if (ignoreCertErrors) {
            options.setAcceptInsecureCerts(true);
        }

        return new FirefoxDriver(options);
    }

    private static WebDriver createEdgeDriver(boolean headless, boolean maximize, boolean ignoreCertErrors) {
        EdgeOptions options = new EdgeOptions();

        if (headless) {
            options.addArguments("--headless");
        }
        if (maximize) {
            options.addArguments("--start-maximized");
        }
        if (ignoreCertErrors) {
            options.addArguments("--ignore-certificate-errors");
        }
        return new EdgeDriver(options);
    }
}
