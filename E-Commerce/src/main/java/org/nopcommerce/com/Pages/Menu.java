package org.nopcommerce.com.Pages;

import org.nopcommerce.com.Utilities.LoggerManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

public class Menu extends BasePage{

    private static final Logger logger = LoggerManager.getLogger(BasePage.class);

    private By RESGISTER_LINK = By.xpath("//a[normalize-space()='Register']");
    private By LOGIN = By.cssSelector(".ico-login");



    public Menu(WebDriver driver){
        super(driver);
    }

    public RegistrationPage goToRegistration(){
        click(RESGISTER_LINK,"Register link");
        return new RegistrationPage(driver).waitUntilLoaded();
    }

    public LoginPage goToLogin(){
        click(LOGIN, "Login link");
        return new LoginPage(driver).waitUntilLoaded();

    }

}
