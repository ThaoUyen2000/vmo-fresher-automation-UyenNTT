package com.vmo.nopcommerce.features.homepage;

import com.vmo.nopcommerce.common.BaseTest;
import com.vmo.nopcommerce.common.GlobalConstants;
import com.vmo.nopcommerce.helper.Log;
import com.vmo.nopcommerce.pageobject.HomePageGenerator;
import com.vmo.nopcommerce.pageobject.RegistrationPageGenerator;
import com.vmo.nopcommerce.pageobject.SearchPageGenerator;
import com.vmo.nopcommerce.pageobject.SoftwarePageGenerator;
import com.vmo.nopcommerce.pageobject.homepage.HomePageObject;
import com.vmo.nopcommerce.pageobject.registrationpage.RegistrationPageObject;
import com.vmo.nopcommerce.pageobject.searchpage.SearchPageObject;
import com.vmo.nopcommerce.pageobject.softwarepage.SoftwarePageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class ProductTest extends BaseTest {
    private WebDriver driver;
    private SearchPageObject searchPage;
    private HomePageObject homePage;
    private SoftwarePageObject softwarePage;

    @Parameters({"browser"})
    @BeforeTest
    public void setUp(@Optional("CHROME") String browser){
        Log.info("Setup");
        driver =  getDriverBrowser(browser);
        searchPage = SearchPageGenerator.getSearchPageObject(driver);
        homePage = HomePageGenerator.getHomePageObject(driver);
        softwarePage = SoftwarePageGenerator.getSoftwarePageObject(driver);
    }

    @Test
    public void Product_Search_Founded(){
        verifyEqual(driver.getCurrentUrl(),"https://demo.nopcommerce.com/");
        homePage.inputSearchBar("Nokia");
        homePage.clickSearchBtn();
        verifyEqual(driver.getCurrentUrl(),"https://demo.nopcommerce.com/search?q=Nokia");
        if(searchPage.isProductTitleDisplay()){
            verifyTrue(searchPage.isProductMatchedWithSearchKeyword("Nokia"));
        } else {
            verifyTrue(searchPage.isNoResultMessageCorrect("No products were found that matched your criteria."));
        }
    }
    @Test
    public void Product_Search_NotFound(){
        verifyEqual(driver.getCurrentUrl(),"https://demo.nopcommerce.com/");
        homePage.inputSearchBar("Nokiaa");
        homePage.clickSearchBtn();
        verifyEqual(driver.getCurrentUrl(),"https://demo.nopcommerce.com/search?q=Nokiaa");
        if(searchPage.isProductTitleDisplay()){
            verifyTrue(searchPage.isProductMatchedWithSearchKeyword("Nokia"));
        } else {
            verifyTrue(searchPage.isNoResultMessageCorrect("No products were found that matched your criteria."));
        }
    }
    @Test
    public void Product_Sort_And_Filter(){
        verifyEqual(driver.getCurrentUrl(),"https://demo.nopcommerce.com/");
        homePage.hoverOnComputerMenu();
        homePage.clickSoftwareMenu();
        verifyEqual(driver.getCurrentUrl(),"https://demo.nopcommerce.com/software");
        softwarePage.selectSortBy("Name: Z to A");
        verifyTrue(softwarePage.isSortSelected("Name: Z to A"));
        verifyTrue(softwarePage.isSortZtoAWorked());
    }
    @AfterTest
    public void tearDown(){
        Log.info("Tear down");
        driver.quit();
    }
}
