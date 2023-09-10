package com.vmo.nopcommerce.pageobject;

import com.vmo.nopcommerce.pageobject.loginpage.LoginPageObject;
import com.vmo.nopcommerce.pageobject.passwordrecoverypage.PasswordRecoveryPageObject;
import org.openqa.selenium.WebDriver;

public class PasswordRecoveryPageGenerator {
    public static PasswordRecoveryPageObject getPasswordRecoverynPageObject(WebDriver driver){
        return new PasswordRecoveryPageObject(driver);
    }
}
