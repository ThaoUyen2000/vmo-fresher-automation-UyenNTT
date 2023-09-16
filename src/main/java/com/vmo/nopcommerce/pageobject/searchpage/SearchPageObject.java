package com.vmo.nopcommerce.pageobject.searchpage;

import com.vmo.nopcommerce.common.BasePage;
import com.vmo.nopcommerce.helper.Log;
import com.vmo.nopcommerce.interfaces.SearchPageUI;
import org.openqa.selenium.WebDriver;

public class SearchPageObject extends BasePage {
    private WebDriver driver;

    public SearchPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public String getProductTitle(){
        Log.info("Get product title");
        return getTextElement(driver, SearchPageUI.PRODUCT_TITLE);
    }
    public boolean isProductTitleDisplay(){
        Log.info("Check product title display");
        return isElementDisplay(driver,SearchPageUI.PRODUCT_TITLE);
    }
    public boolean isProductMatchedWithSearchKeyword(String value){
        Log.info("Check product matched with search keyword");
        return getProductTitle().contains(value);
    }
    public String getNoResultMessage(){
        Log.info("Get No result messsage");
        return getTextElement(driver, SearchPageUI.NO_RESULT_MESSAGE);
    }
    public boolean isNoResultMessageCorrect(String expectedMessage){
        Log.info("Check No result message correct");
        return getNoResultMessage().equals(expectedMessage);
    }
}
