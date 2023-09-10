package com.vmo.nopcommerce.features.homepage;

import com.vmo.nopcommerce.common.BaseTest;
import com.vmo.nopcommerce.pageobject.HomePageGenerator;
import com.vmo.nopcommerce.pageobject.NewDetailPageGenerator;
import com.vmo.nopcommerce.pageobject.homepage.HomePageObject;
import com.vmo.nopcommerce.pageobject.newdetailpage.NewDetailPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ChangeExchangeTest extends BaseTest {
    private WebDriver driver=super.driver;
    private HomePageObject homePage;
    private NewDetailPageObject newDetailPage;

    @BeforeTest
    public void setUp(){
        homePage = HomePageGenerator.getHomePageObject(driver);
        newDetailPage = NewDetailPageGenerator.getNewDetailPageObject(driver);
        driver.get("https://demo.nopcommerce.com/");
    }

    @Test
    public void Change_Exchange(){
        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/");
        homePage.changeExchange("Euro");
        verifyTrue(homePage.isExchangeSelected("Euro"));
        verifyTrue(homePage.isPricesCurrencyChanged("Euro"));
    }
//    @AfterSuite
//    public WebDriver tearDown(){
//        return new ChromeDriver();
//    }
}
