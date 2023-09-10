package com.vmo.nopcommerce.pageobject;

import com.vmo.nopcommerce.pageobject.registrationpage.RegistrationPageObject;
import org.openqa.selenium.WebDriver;

public class RegistrationPageGenerator {
    public static RegistrationPageObject getRegistrationPageObject(WebDriver driver){
        return new RegistrationPageObject(driver);
    }
}
