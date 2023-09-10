package com.vmo.nopcommerce.common;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest{
    protected WebDriver driver = new ChromeDriver();
    @BeforeSuite
    public void setUp(){
        driver.get("https://demo.nopcommerce.com/");
    }
    protected  void verifyTrue(boolean value){
        Assert.assertTrue(value);
    }
    protected  void verifyCurrentPage(String URL){
        Assert.assertEquals(driver.getCurrentUrl(),URL);
    }
}
