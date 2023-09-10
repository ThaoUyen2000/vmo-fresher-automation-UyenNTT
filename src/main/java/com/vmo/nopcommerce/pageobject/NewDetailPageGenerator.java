package com.vmo.nopcommerce.pageobject;

import com.vmo.nopcommerce.pageobject.loginpage.LoginPageObject;
import com.vmo.nopcommerce.pageobject.newdetailpage.NewDetailPageObject;
import org.openqa.selenium.WebDriver;

public class NewDetailPageGenerator {
    public static NewDetailPageObject getNewDetailPageObject(WebDriver driver){
        return new NewDetailPageObject(driver);
    }
}
