package com.vmo.nopcommerce.pageobject.searchpage;

import com.vmo.nopcommerce.common.BasePage;
import com.vmo.nopcommerce.interfaces.SearchPageUI;
import org.openqa.selenium.WebDriver;

public class SearchPageObject extends BasePage {
    private WebDriver driver;

    public SearchPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public String getProductTitle(){
        return getTextElement(driver, SearchPageUI.PRODUCT_TITLE);
    }
    public boolean isProductTitleDisplay(){
        return isElementDisplay(driver,SearchPageUI.PRODUCT_TITLE);
    }
    public boolean isProductMatchedWithSearchKeyword(String value){
        return getProductTitle().contains(value);
    }
    public String getNoResultMessage(){
        return getTextElement(driver, SearchPageUI.NO_RESULT_MESSAGE);
    }
    public boolean isNoResultMessageCorrect(String expectedMessage){
        return getNoResultMessage().equals(expectedMessage);
    }
}
