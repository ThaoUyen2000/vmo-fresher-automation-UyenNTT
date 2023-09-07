package com.vmo.nopcommerce.features.register;

import com.vmo.nopcommerce.common.BaseTest;
import com.vmo.nopcommerce.pageobject.homepage.HomePageObject;
import com.vmo.nopcommerce.pageobject.homepage.LoginPageObject;
import com.vmo.nopcommerce.pageobject.registration.RegistrationPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class UserRegistrationTest extends BaseTest {
    private WebDriver driver;
    private RegistrationPageObject registrationPage;
    private HomePageObject homePage;

    @BeforeSuite
    public void setUp(){
        driver =  new ChromeDriver();
        registrationPage = new RegistrationPageObject(driver);
        homePage = new HomePageObject(driver);
        driver.get("https://demo.nopcommerce.com/");
    }

    @Test
    public void User_registration(){
        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/");
        verifyTrue(homePage.isRegisterLinkDisplayed());
        homePage.clickRegisterLink();
        Assert.assertEquals(registrationPage.getTitle(),"Register");
        registrationPage.fillRegistrationForm();
        registrationPage.submitForm();
        Assert.assertEquals(registrationPage.getMessage(),"Your registration completed");
    }
//    @AfterSuite
//    public WebDriver tearDown(){
//        return new ChromeDriver();
//    }
}
