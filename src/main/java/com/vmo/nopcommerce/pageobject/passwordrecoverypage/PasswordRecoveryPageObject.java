package com.vmo.nopcommerce.pageobject.passwordrecoverypage;

import com.vmo.nopcommerce.common.BasePage;
import com.vmo.nopcommerce.helper.Log;
import com.vmo.nopcommerce.interfaces.PasswordRecoveryPageUI;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PasswordRecoveryPageObject extends BasePage {
    WebDriver driver;

    public PasswordRecoveryPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public void inputEmailAddress(String email){
        Log.info("Input email address");
        sendKeyToElement(driver, PasswordRecoveryPageUI.EMAIL_ADDRESS_FIELD,email);
    }

    public void clickRecoverBtn() {
        Log.info("Click Recover button");
        clickToElement(driver,PasswordRecoveryPageUI.RECORY_BTN);
    }

    public boolean isNotificationCorrect(String messsage) {
        Log.info("Check notification correct");
        return getTextElement(driver,PasswordRecoveryPageUI.NOTIFICATION_BAR).contains(messsage);
    }
}
