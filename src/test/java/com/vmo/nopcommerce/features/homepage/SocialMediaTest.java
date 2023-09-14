package com.vmo.nopcommerce.features.homepage;

import com.vmo.nopcommerce.common.BaseTest;
import com.vmo.nopcommerce.pageobject.HomePageGenerator;
import com.vmo.nopcommerce.pageobject.homepage.HomePageObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SocialMediaTest extends BaseTest {
    private WebDriver driver=super.driver;
    private HomePageObject homePage;

    @Parameters({"browser"})
    @BeforeTest
    public void setUp(@Optional("CHROME") String browser){
        driver =  getDriverBrowser(browser);
        homePage = HomePageGenerator.getHomePageObject(driver);
        driver.get("https://demo.nopcommerce.com/");
    }

    @Test
    public void Change_Exchange(){
        verifyEqual(driver.getCurrentUrl(),"https://demo.nopcommerce.com/");
        homePage.clickSocialMedia("Facebook");
        verifyTrue(homePage.isCorrectSocialMediaOpened("Facebook"));
    }
//    @AfterSuite
//    public WebDriver tearDown(){
//        return new ChromeDriver();
//    }
}

