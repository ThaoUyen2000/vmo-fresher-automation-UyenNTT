package com.vmo.nopcommerce.features.homepage;

import com.vmo.nopcommerce.common.BaseTest;
import com.vmo.nopcommerce.helper.Log;
import com.vmo.nopcommerce.pageobject.HomePageGenerator;
import com.vmo.nopcommerce.pageobject.homepage.HomePageObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class SocialMediaTest extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;

    @Parameters({"browser"})
    @BeforeTest
    public void setUp(@Optional("CHROME") String browser){
        Log.info("Setup");
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
    @AfterTest
    public void tearDown(){
        Log.info("Tear down");
        driver.quit();
    }
}

