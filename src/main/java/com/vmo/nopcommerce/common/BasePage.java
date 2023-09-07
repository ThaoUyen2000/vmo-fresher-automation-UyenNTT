package com.vmo.nopcommerce.common;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    private static int LONG_TIMEOUT= 30;
    private static int EXPLICIT_WAIT_TIME = 30;
    private WebDriverWait wait;
    protected boolean isElementDisplayed(WebDriver driver,String locator) {
        getWait(driver,LONG_TIMEOUT);
        return findElement(driver,locator).isDisplayed();
    }
    protected BasePage waitElementClickable(WebDriver driver,int timeout, String locator) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
        return this;
    }
    protected BasePage waitElementVisible(WebDriver driver,int timeout, String locator) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        return this;
    }
    protected WebElement findElement(WebDriver driver, String locator){
        return driver.findElement(By.xpath(locator));
    }
    protected WebDriverWait getWait(WebDriver driver, int timeout){
        return new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }
    protected void clickElement(WebDriver driver, String locator){
        getWait(driver,LONG_TIMEOUT);
        findElement(driver, locator).click();
    }
    protected void sendKeys(WebDriver driver, String locator, String value){
        waitElementVisible(driver,EXPLICIT_WAIT_TIME,locator);
        findElement(driver,locator).sendKeys(value);
    }
    protected String getText(WebDriver driver, String locator){
        waitElementVisible(driver,EXPLICIT_WAIT_TIME,locator);
        return findElement(driver, locator).getText();
    }
    protected void selectDropdown(WebDriver driver,String locator,String value){
        waitElementVisible(driver,EXPLICIT_WAIT_TIME,locator);
        Select dropdown = new Select(findElement(driver,locator));
        dropdown.selectByValue(value);
    }
}
