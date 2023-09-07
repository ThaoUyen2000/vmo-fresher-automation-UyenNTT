package com.vmo.nopcommerce.pageobject.homepage;

import com.vmo.nopcommerce.common.BasePage;
import com.vmo.nopcommerce.interfaces.LoginPageUI;
import org.openqa.selenium.WebDriver;

public class LoginPageObject extends BasePage {
    private WebDriver driver;
    public LoginPageObject(WebDriver driver){
        this.driver=driver;
    }
    public void inputUserName(String username) {
        sendKeys(driver, LoginPageUI.USERNAME_TXT, username);
    }

    public void inputPassword(String password) {
        sendKeys(driver, LoginPageUI.PASSWORD_TXT, password);
    }

    public boolean isLoginButtonDisplayed() {
        return isElementDisplayed(driver,LoginPageUI.PASSWORD_TXT);
    }
}
