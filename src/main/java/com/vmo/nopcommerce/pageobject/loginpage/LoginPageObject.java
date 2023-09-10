package com.vmo.nopcommerce.pageobject.loginpage;

import com.vmo.nopcommerce.common.BasePage;
import com.vmo.nopcommerce.interfaces.LoginPageUI;
import org.openqa.selenium.WebDriver;

public class LoginPageObject extends BasePage {
    WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickForgotPasswordLink() {
        clickToElement(driver, LoginPageUI.FORGET_PASSWORD_LINK);
    }
}
