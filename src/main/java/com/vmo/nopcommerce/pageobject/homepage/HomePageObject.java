package com.vmo.nopcommerce.pageobject.homepage;

import com.vmo.nopcommerce.common.BasePage;
import com.vmo.nopcommerce.helper.Log;
import com.vmo.nopcommerce.interfaces.HomePageUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HomePageObject extends BasePage {
    private WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isRegisterLinkDisplayed() {
        Log.info("Check register link display");
        return isElementDisplay(driver, HomePageUI.REGISTER_LINK);
    }
    public void clickRegisterLink() {
        Log.info("Click register link");
        clickToElement(driver, HomePageUI.REGISTER_LINK);
    }
    public void inputSearchBar(String value){
        Log.info("Input search bar");
        sendKeyToElement(driver,HomePageUI.SEARCH_BAR,value);
    }
    public void clickSearchBtn(){
        Log.info("Click search button");
        clickToElement(driver,HomePageUI.SEARCH_BTN);
    }

    public void hoverOnComputerMenu() {
        Log.info("Hover on Computer Menu");
        hoverMouseToElement(driver,HomePageUI.COMPUTER_MENU);
    }

    public void clickSoftwareMenu() {
        Log.info("Click Software menu");
        clickToElement(driver, HomePageUI.SOFTWARE_MENU);
    }

    public void clickLoginLink() {
        Log.info("Click Login link");
        clickToElement(driver, HomePageUI.LOGIN_LINK);
    }

    public void clickNewsArticle(String title) {
        Log.info("Click News Article");
        scrollToElement(driver,HomePageUI.NEWS_LIST);
        String locator = getDynamiLocator(HomePageUI.NEW_TITLE,title);
        clickToElement(driver,locator);
    }

    public void changeExchange(String option) {
        Log.info("Change Exchange");
        selectItemInDefaultDropdownByText(driver,HomePageUI.CURRENCY_SELECT,option);
    }

    public boolean isExchangeSelected(String option) {
        Log.info("Check exchange selected");
        return getTextElement(driver,HomePageUI.CURRENCY_SELECT).contains(option);
    }

    public boolean isPricesCurrencyChanged(String currency) {
        Log.info("Check price currency changed");
        scrollToElement(driver,HomePageUI.FEATURED_PRODUCTS);
        List<WebElement> pricesList = getListWebElements(driver,HomePageUI.PRODUCTS_PRICE);
        List<String> prices = new ArrayList<>();
        for (WebElement price:pricesList) {
            prices.add(price.getText());
        }
        boolean check = true;
        switch (currency){
            case  "Euro":
                for (String p: prices) {
                    if (!p.contains("€")){
                        check = false;
                    }
                }
                break;
            case  "US Dollar":
                for (String p: prices) {
                    if (!p.contains("$")){
                        check = false;
                    }
                }
                break;
            default:
        }
        return check;
    }

    public void clickSocialMedia(String social) {
        Log.info("Click Social media");
        String locator = getDynamiLocator(HomePageUI.SOCIAL_MEDIA,social);
        clickToElement(driver, locator);
    }

    public boolean isCorrectSocialMediaOpened(String socialMedia) {
        Log.info("Check correct Social media opened");
        Set<String> windowHandles = driver.getWindowHandles();
        boolean check = true;
        switch (socialMedia){
            case  "Facebook":
                for (String windowHandle : windowHandles) {
                    driver.switchTo().window(windowHandle);
                    if (!driver.getTitle().equals("NopCommerce | Facebook")) {
                        check =true;
                        break;
                    }
                }
                break;
            case  "Twitter":
                for (String windowHandle : windowHandles) {
                    driver.switchTo().window(windowHandle);
                    if (!driver.getTitle().equals("nopCommerce (@nopCommerce) / X")) {
                        check =true;
                        break;
                    }
                }
                break;
            case  "Youtube":
                for (String windowHandle : windowHandles) {
                    driver.switchTo().window(windowHandle);
                    if (!driver.getTitle().equals("nopCommerce - YouTub")) {
                        check =true;
                        break;
                    }
                }
                break;
            default:
        }
        return check;
    }
}
