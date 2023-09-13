package com.vmo.nopcommerce.features.homepage;

import com.vmo.nopcommerce.common.BaseTest;
import com.vmo.nopcommerce.pageobject.HomePageGenerator;
import com.vmo.nopcommerce.pageobject.NewDetailPageGenerator;
import com.vmo.nopcommerce.pageobject.homepage.HomePageObject;
import com.vmo.nopcommerce.pageobject.newdetailpage.NewDetailPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NewsTest extends BaseTest {
    private WebDriver driver=super.driver;
    private HomePageObject homePage;
    private NewDetailPageObject newDetailPage;

    @Parameters({"browser"})
    @BeforeTest
    public void setUp(@Optional("CHROME") String browser){
        driver =  getDriverBrowser(browser);
        homePage = HomePageGenerator.getHomePageObject(driver);
        newDetailPage = NewDetailPageGenerator.getNewDetailPageObject(driver);
    }

    @Test
    public void Read_News_And_Leave_Comment(){
        verifyTrue(verifyEqual(driver.getCurrentUrl(),"https://demo.nopcommerce.com/"));
        homePage.clickNewsArticle("New online store is open!");
        verifyTrue(newDetailPage.isArticleTitleCorrect("New online store is open!"));
        newDetailPage.inputComment("abc","xyz");
        newDetailPage.clickNewCommentBtn();
        verifyTrue(newDetailPage.isCommentResultCorrect("News comment is successfully added."));
        verifyTrue(newDetailPage.isCommentAdded("abc","xyz"));
    }
//    @AfterSuite
//    public WebDriver tearDown(){
//        return new ChromeDriver();
//    }
}
