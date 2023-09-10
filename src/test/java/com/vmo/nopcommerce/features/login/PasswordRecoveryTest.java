package com.vmo.nopcommerce.features.login;

import com.vmo.nopcommerce.common.BaseTest;
import com.vmo.nopcommerce.pageobject.*;
import com.vmo.nopcommerce.pageobject.homepage.HomePageObject;
import com.vmo.nopcommerce.pageobject.loginpage.LoginPageObject;
import com.vmo.nopcommerce.pageobject.passwordrecoverypage.PasswordRecoveryPageObject;
import com.vmo.nopcommerce.pageobject.searchpage.SearchPageObject;
import com.vmo.nopcommerce.pageobject.softwarepage.SoftwarePageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PasswordRecoveryTest extends BaseTest {
    private WebDriver driver = super.driver;
    private PasswordRecoveryPageObject passwordRecoveryPage;
    private HomePageObject homePage;
    private LoginPageObject loginPage;

    @BeforeTest
    public void setUp(){
        passwordRecoveryPage = PasswordRecoveryPageGenerator.getPasswordRecoverynPageObject(driver);
        homePage = HomePageGenerator.getHomePageObject(driver);
        loginPage = LoginPageGenerator.getLoginPageObject(driver);
        driver.get("https://demo.nopcommerce.com/");
    }
    @Test
    public void Password_Recovery(){
        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/");
        homePage.clickLoginLink();
        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/login?returnUrl=%2F");
        loginPage.clickForgotPasswordLink();
        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/passwordrecovery");
        passwordRecoveryPage.inputEmailAddress("uyenntt1@yopmail.com");
        passwordRecoveryPage.clickRecoverBtn();
        verifyTrue(passwordRecoveryPage.isNotificationCorrect("Email with instructions has been sent to you."));
    }
}