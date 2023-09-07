package com.vmo.nopcommerce.pageobject.registration;

import com.vmo.nopcommerce.common.BasePage;
import com.vmo.nopcommerce.common.BaseTest;
import com.vmo.nopcommerce.interfaces.HomePageUI;
import com.vmo.nopcommerce.interfaces.LoginPageUI;
import com.vmo.nopcommerce.interfaces.RegistrationPageUI;
import org.openqa.selenium.WebDriver;

public class RegistrationPageObject extends BasePage {
    private WebDriver driver;

    public RegistrationPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle(){
        return getText(driver, RegistrationPageUI.TITLE);
    }
    public void fillRegistrationForm() {
        clickElement(driver,RegistrationPageUI.GENDER_FEMALE);
        sendKeys(driver,RegistrationPageUI.FIRST_NAME_INPUT,"Ashley");
        sendKeys(driver,RegistrationPageUI.LAST_NAME_INPUT,"Nguyen");
        selectDropdown(driver,RegistrationPageUI.SELECT_DAY,"6");
        selectDropdown(driver,RegistrationPageUI.SELECT_MONTH,"10");
        selectDropdown(driver,RegistrationPageUI.SELECT_YEAR,"2000");
        sendKeys(driver,RegistrationPageUI.EMAIL_INPUT,"uyenntt1@vmogroup.com");
        sendKeys(driver,RegistrationPageUI.PASSWORD_INPUT,"Uyen06102000");
        sendKeys(driver,RegistrationPageUI.CONFIRM_PASSWORD_INPUT,"Uyen06102000");
    }
    public void submitForm(){
        clickElement(driver,RegistrationPageUI.REGISTER_BTN);
    }
    public String getMessage(){
        return getText(driver, RegistrationPageUI.REGISTRATION_MESSAGE);
    }
}
