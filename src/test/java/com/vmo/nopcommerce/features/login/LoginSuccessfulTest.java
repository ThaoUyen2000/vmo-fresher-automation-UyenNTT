package com.vmo.nopcommerce.features.login;

import com.vmo.nopcommerce.common.BaseTest;
import com.vmo.nopcommerce.pageobject.homepage.HomePageObject;
import com.vmo.nopcommerce.pageobject.homepage.LoginPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LoginSuccessfulTest extends BaseTest {
    private WebDriver driver;
    private LoginPageObject loginPage;
    private HomePageObject homePage;

    @BeforeSuite
    public void setUp(){
        driver =  new ChromeDriver();
        loginPage = new LoginPageObject(driver);
        homePage = new HomePageObject(driver);
    }

    @Test
    public void Login_01_LoginSuccessful(){
        loginPage.inputUserName("abc");
        loginPage.inputPassword("");
        verifyTrue(loginPage.isLoginButtonDisplayed());
    }
    @AfterSuite
    public WebDriver tearDown(){
        return new ChromeDriver();
    }
}
