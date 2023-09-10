package com.vmo.nopcommerce.pageobject;

import com.vmo.nopcommerce.pageobject.homepage.HomePageObject;
import org.openqa.selenium.WebDriver;

public class HomePageGenerator {
    public static HomePageObject getHomePageObject(WebDriver driver){
        return new HomePageObject(driver);
    }
}
