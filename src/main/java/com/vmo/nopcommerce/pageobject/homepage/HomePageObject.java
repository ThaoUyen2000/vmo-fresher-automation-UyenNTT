package com.vmo.nopcommerce.pageobject.homepage;

import com.vmo.nopcommerce.common.BasePage;
import com.vmo.nopcommerce.interfaces.HomePageUI;
import com.vmo.nopcommerce.interfaces.RegistrationPageUI;
import org.openqa.selenium.WebDriver;

public class HomePageObject extends BasePage {
    private WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isRegisterLinkDisplayed() {
        return isElementDisplayed(driver, HomePageUI.REGISTER_LINK);
    }
    public void clickRegisterLink() {
        clickElement(driver, HomePageUI.REGISTER_LINK);
    }
}
