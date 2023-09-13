package com.vmo.nopcommerce.features.register;

import com.vmo.nopcommerce.common.BaseTest;
import com.vmo.nopcommerce.pageobject.HomePageGenerator;
import com.vmo.nopcommerce.pageobject.RegistrationPageGenerator;
import com.vmo.nopcommerce.pageobject.homepage.HomePageObject;
import com.vmo.nopcommerce.pageobject.registrationpage.RegistrationPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class UserRegistrationTest extends BaseTest {
    private WebDriver driver;
    private RegistrationPageObject registrationPage;
    private HomePageObject homePage;

    @Parameters({"browser"})
    @BeforeTest
    public void setUp(@Optional("CHROME") String browser){
        driver =  getDriverBrowser(browser);
        registrationPage = RegistrationPageGenerator.getRegistrationPageObject(driver);
        homePage = HomePageGenerator.getHomePageObject(driver);
    }

    @Test
    public void User_registration(){
        verifyTrue(verifyEqual(driver.getCurrentUrl(),"https://demo.nopcommerce.com/"));
        verifyTrue(homePage.isRegisterLinkDisplayed());
        homePage.clickRegisterLink();
        verifyTrue(verifyEqual(registrationPage.getTitle(),"Register"));
        registrationPage.fillRegistrationForm();
        registrationPage.submitForm();
        verifyTrue(verifyEqual(registrationPage.getMessage(),"Your registration completed"));
    }
//    @AfterSuite
//    public WebDriver tearDown(){
//        return new ChromeDriver();
//    }
}
