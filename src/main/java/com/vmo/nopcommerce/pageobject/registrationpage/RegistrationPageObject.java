package com.vmo.nopcommerce.pageobject.registrationpage;

import com.vmo.nopcommerce.common.BasePage;
import com.vmo.nopcommerce.interfaces.RegistrationPageUI;
import org.openqa.selenium.WebDriver;

public class RegistrationPageObject extends BasePage {
    private WebDriver driver;

    public RegistrationPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle(){
        return getTextElement(driver, RegistrationPageUI.TITLE);
    }
    public void fillRegistrationForm() {
        clickToElement(driver,RegistrationPageUI.GENDER_FEMALE);
        sendKeyToElement(driver,RegistrationPageUI.FIRST_NAME_INPUT,"Ashley");
        sendKeyToElement(driver,RegistrationPageUI.LAST_NAME_INPUT,"Nguyen");
        selectItemInDefaultDropdownByText(driver,RegistrationPageUI.SELECT_DAY,"6");
        selectItemInDefaultDropdownByText(driver,RegistrationPageUI.SELECT_MONTH,"October");
        selectItemInDefaultDropdownByText(driver,RegistrationPageUI.SELECT_YEAR,"2000");
        sendKeyToElement(driver,RegistrationPageUI.EMAIL_INPUT,"uyenntt1@yopmail.com");
        sendKeyToElement(driver,RegistrationPageUI.PASSWORD_INPUT,"Uyen06102000");
        sendKeyToElement(driver,RegistrationPageUI.CONFIRM_PASSWORD_INPUT,"Uyen06102000");
    }
    public void submitForm(){
        clickToElement(driver,RegistrationPageUI.REGISTER_BTN);
    }
    public String getMessage(){
        return getTextElement(driver, RegistrationPageUI.REGISTRATION_MESSAGE);
    }
}
