package com.vmo.nopcommerce.features.homepage;

import com.vmo.nopcommerce.common.BaseTest;
import com.vmo.nopcommerce.helper.Log;
import com.vmo.nopcommerce.helper.TestNGListener;
import com.vmo.nopcommerce.pageobject.HomePageGenerator;
import com.vmo.nopcommerce.pageobject.NewDetailPageGenerator;
import com.vmo.nopcommerce.pageobject.homepage.HomePageObject;
import com.vmo.nopcommerce.pageobject.newdetailpage.NewDetailPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(TestNGListener.class)
public class ChangeExchangeTest extends BaseTest {
    private WebDriver driver=super.driver;
    private HomePageObject homePage;

    @Parameters({"browser"})
    @BeforeTest
    public void setUp(@Optional("CHROME") String browser){
        Log.info("Setup");
        driver =  getDriverBrowser(browser);
        homePage = HomePageGenerator.getHomePageObject(driver);
    }

    @Test
    public void Change_Exchange(){
        verifyEqual(driver.getCurrentUrl(),"https://demo.nopcommerce.com/");
        homePage.changeExchange("Euro");
        verifyTrue(homePage.isExchangeSelected("Euro"));
        verifyTrue(homePage.isPricesCurrencyChanged("Euro"));
    }
    @AfterTest
    public void tearDown(){
        Log.info("Tear down");
        driver.quit();
    }
}
