package com.vmo.nopcommerce.pageobject;

import com.vmo.nopcommerce.pageobject.homepage.HomePageObject;
import com.vmo.nopcommerce.pageobject.loginpage.LoginPageObject;
import org.openqa.selenium.WebDriver;

public class LoginPageGenerator {
    public static LoginPageObject getLoginPageObject(WebDriver driver){
        return new LoginPageObject(driver);
    }
}
