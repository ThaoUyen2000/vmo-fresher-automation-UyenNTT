package com.vmo.nopcommerce.pageobject;

import com.vmo.nopcommerce.pageobject.homepage.HomePageObject;
import com.vmo.nopcommerce.pageobject.softwarepage.SoftwarePageObject;
import org.openqa.selenium.WebDriver;

public class SoftwarePageGenerator {
    public static SoftwarePageObject getSoftwarePageObject(WebDriver driver){
        return new SoftwarePageObject(driver);
    }
}
