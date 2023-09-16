package com.vmo.nopcommerce.pageobject.newdetailpage;

import com.vmo.nopcommerce.common.BasePage;
import com.vmo.nopcommerce.helper.Log;
import com.vmo.nopcommerce.interfaces.NewDetailPageUI;
import com.vmo.nopcommerce.interfaces.PasswordRecoveryPageUI;
import com.vmo.nopcommerce.interfaces.RegistrationPageUI;
import org.openqa.selenium.WebDriver;

public class NewDetailPageObject extends BasePage {
    WebDriver driver;

    public NewDetailPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isArticleTitleCorrect(String title) {
        Log.info("Check Article Title Correct");
        return getTextElement(driver, NewDetailPageUI.NEW_TITLE).contains(title);
    }

    public void inputComment(String title, String comment) {
        Log.info("Input comment");
        sendKeyToElement(driver, NewDetailPageUI.TITLE_FIELD,title);
        sendKeyToElement(driver,NewDetailPageUI.COMMENT_FIELD,comment);
    }

    public void clickNewCommentBtn() {
        Log.info("Click New comment button");
        clickToElement(driver, NewDetailPageUI.NEW_COMMENT_BTN);
    }

    public boolean isCommentResultCorrect(String text) {
        Log.info("Check comment result correct");
        return getTextElement(driver, NewDetailPageUI.COMMENT_RESULT).contains(text);
    }

    public boolean isCommentAdded(String title, String comment) {
        Log.info("Check comment added");
        String titleLocator = getDynamiLocator(NewDetailPageUI.COMMENT_TITLE,title);
        String commentLocator = getDynamiLocator(NewDetailPageUI.COMMENT_BODY,comment);
        scrollToElement(driver,titleLocator);
        if (isElementDisplay(driver,titleLocator) && isElementDisplay(driver,commentLocator)){
            return true;
        } else{
            return false;
        }
    }
}
