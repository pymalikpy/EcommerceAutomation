package org.nopcommerce.com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.lang.System.in;

public class HomePage extends BasePage{

    private By LOGO = By.cssSelector("img[alt='nopCommerce demo store']");
    private By TOP_MENU = By.xpath("//ul[@class='top-menu notmobile']");
    private By TOP_MENU_LIST = By.xpath("//ul[@class='top-menu notmobile']//li");
    private By SEARCH_BOX = By.id("small-searchterms");
    private By SEARCH_BTN = By.cssSelector(".search-box-button");


    public static final String ADD_TO_CART = "//article[contains(.,'%s')]//button[contains(.,'Add to cart')]";

    public HomePage(WebDriver driver){
        super(driver);
    }

    public HomePage waitUntilLoaded(){
        waitForVisibilityOf(LOGO,shortTimeOut);
        waitForVisibilityOf(TOP_MENU,shortTimeOut);
        return this;
    }

    public void getProductsList(){
        List<WebElement> eleList = driver.findElements((TOP_MENU_LIST));

        for(WebElement ele: eleList){
            String eleName = ele.getText();
            logger.info("The element name is " + eleName);
        }

    }

    public void searchProduct(String productName){
        inputText(SEARCH_BOX,productName,"Search box");
        selectSearch();
    }

    public void selectSearch(){
        click(SEARCH_BOX,"Search box");
    }

    public void selectProduct(String productName){
        By locator = By.xpath(String.format(ADD_TO_CART,productName));
        click(locator,"Add to cart button");
    }





}
