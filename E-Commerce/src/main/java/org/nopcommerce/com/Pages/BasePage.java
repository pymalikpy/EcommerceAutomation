package org.nopcommerce.com.Pages;

import org.nopcommerce.com.Helpers.TestError;
import org.nopcommerce.com.Utilities.LoggerManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Logger;

public abstract class BasePage {

    public static int veryLongTimeOut = 120;
    public static int longTimeOut = 60;
    public static int mediumTimeOut = 30;
    public static int mediumShortTimeOut = 10;
    public static int shortTimeOut = 6;
    public static int veryShortTimeOut = 1;
    protected Logger logger;
    protected WebDriver driver;
    protected WebDriverWait wait;

    public static final String BUTTON = "(//button[normalize-space()='%s'])[1]";

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(mediumTimeOut));
        this.logger = LoggerManager.getLogger(this.getClass());
    }

    public Logger getLogger(){
        if(logger==null){
            throw new TestError("Found a null logger from the super class page object");
        }
        return logger;
    }

    //====================================
    //Common wait methods
    //====================================

    public BasePage waitForVisibilityOf(By screenElementLocator, int seconds){
        logger.info("Wait for element" + screenElementLocator + " to be visible for: " + seconds+ " seconds");
        new WebDriverWait(driver,Duration.ofSeconds(seconds)).until(ExpectedConditions.
                visibilityOfElementLocated(screenElementLocator));
        return this;
    }

    public BasePage waitForClickable(By screenElementLocator, int seconds){
        logger.info("Wait for element" + screenElementLocator + " to be clickable after: " + seconds+ " seconds");
        new WebDriverWait(driver,Duration.ofSeconds(seconds)).until(ExpectedConditions.
                elementToBeClickable(screenElementLocator));
        return this;
    }

    public BasePage waitForPresence(By screenElementLocator, int seconds){
        logger.info("Wait for element" + screenElementLocator + " to be present after: " + seconds+ " seconds");
        new WebDriverWait(driver,Duration.ofSeconds(seconds)).until(ExpectedConditions.
                presenceOfElementLocated(screenElementLocator));
        return this;
    }

    public BasePage waitForTitle(String expectedTitle, int seconds){
        logger.info("Wait for title " + expectedTitle + " to be present after: " + seconds+ " seconds");
        new WebDriverWait(driver,Duration.ofSeconds(seconds)).until(ExpectedConditions.
                titleIs(expectedTitle));
        return this;
    }

    //Common Element action

    public void click (By locator, String elementName){
        waitForVisibilityOf(locator,shortTimeOut);
        logger.info("Clicking on element name, " + elementName);
        driver.findElement(locator).click();
    }
    public void clickButton(String BtnName){
        By locator = By.xpath(String.format(BUTTON,BtnName));
        click(locator, BtnName + " clicked ");
    }

    public void inputText(By locator, String textToType, String elementName){
        waitForVisibilityOf(locator,shortTimeOut);
        logger.info("Typing '" + textToType + "' into: " + elementName);
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(textToType);
    }

    public String getText(By locator, String elementName){
        waitForVisibilityOf(locator,shortTimeOut);
        logger.info("Getting text from: " + elementName);
        return driver.findElement(locator).getText();
    }

    public boolean isVisible(By locator, int timeoutInSeconds){
        try{
            new WebDriverWait(driver,Duration.ofSeconds(mediumTimeOut)).until(
                    ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //Js helpers

    public void jsClick(By locator, String elementName){
        logger.info("Clicking via JavaScript on: " + elementName);
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",element);
    }

    public void scrollToElement(By locator, String elementName){
        logger.info("Scrolling to: " + elementName);
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",element);
    }


    public void sleep(int secs){
        try {
            logger.info("Sleeping for " + secs + " seconds");
            Thread.sleep(secs * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }














}
