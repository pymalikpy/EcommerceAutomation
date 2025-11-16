package org.nopcommerce.com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    private By HEADING = By.xpath("//h1");
    private By EMAIL = By.id("#Email");
    private By PASSWORD = By.id("#Password");
    private By LOGIN_BTN = By.xpath("//button[normalize-space()='Log in']");



    public LoginPage(WebDriver driver){
        super(driver);
    }

    public LoginPage waitUntilLoaded(){
        waitForVisibilityOf(HEADING,shortTimeOut);
        waitForVisibilityOf(PASSWORD,shortTimeOut);
        return this;
    }

    public HomePage login(String email,String password){
        inputText(EMAIL, email, "Email input box");
        inputText(PASSWORD, password, "Password input box");
        clickButton("Log in");
        return new HomePage(driver).waitUntilLoaded();
    }



}
