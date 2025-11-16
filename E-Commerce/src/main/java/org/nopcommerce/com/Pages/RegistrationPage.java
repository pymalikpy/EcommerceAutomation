package org.nopcommerce.com.Pages;

import org.nopcommerce.com.Utilities.RandomUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage{

    private By HEADING = By.xpath("//h1");
    private By PERSONAL_DETAILS_TEXT = By.xpath("//h2[normalize-space()='Your Personal Details']");
    private static final String GENDER_RADIO = "//input[@id='gender-%s']";
    private By FIRST_NAME_INPUTBOX = By.cssSelector("#FirstName");
    private By LAST_NAME_INPUTBOX = By.cssSelector("#LastName");
    private By EMAIL_INPUTBOX = By.cssSelector("#Email");
    private By COMPANY_INPUTBOX = By.cssSelector("#Company");
    private By PASSWORD_INPUTBOX = By.cssSelector("#Password");
    private By CONIRM_PASSWORD_INPUTBOX = By.cssSelector("#ConfirmPassword");
    private By SUCCESS_MSG = By.cssSelector("div.result");
    private By CONTINUE = By.cssSelector("a.button-1");



    public RegistrationPage(WebDriver driver){
        super(driver);
    }

    public RegistrationPage waitUntilLoaded(){
        waitForVisibilityOf(HEADING,shortTimeOut);
        waitForVisibilityOf(PERSONAL_DETAILS_TEXT,shortTimeOut);
        return this;
    }

    public void selectGender(String gender){
        By locator = By.xpath(String.format(GENDER_RADIO,gender.toLowerCase()));
        click(locator,"Gender Radio Button (" + gender + ")");
    }

    public void inputName(String firstName,String lastName){
        inputText(FIRST_NAME_INPUTBOX,firstName, "First Name");
        inputText(LAST_NAME_INPUTBOX,lastName, "Last Name");
    }

    public void inputEmail(String email){
        inputText(EMAIL_INPUTBOX,email, "Email");
    }

    public void inputPassword(String password){
        inputText(PASSWORD_INPUTBOX,password,"Password");
        inputText(CONIRM_PASSWORD_INPUTBOX,password,"Confirm Password");

    }

    public void clickRegister(){
        clickButton("Register");
        waitForPresence(SUCCESS_MSG, mediumShortTimeOut);
    }

    public void addNewUser(String firstName, String lastName, String email, String password){
        selectGender("Male");
        inputName(firstName,lastName);
        inputEmail(email);
        inputPassword(password);
        clickRegister();
        waitForVisibilityOf(SUCCESS_MSG,shortTimeOut);
    }

    public HomePage selectContinue(){
        click(CONTINUE,"User created successfully, click continue");
        return new HomePage(driver).waitUntilLoaded();
    }


}
