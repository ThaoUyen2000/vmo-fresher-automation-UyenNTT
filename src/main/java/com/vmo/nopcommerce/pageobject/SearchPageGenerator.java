package com.vmo.nopcommerce.pageobject;

import com.vmo.nopcommerce.pageobject.searchpage.SearchPageObject;
import org.openqa.selenium.WebDriver;

public class SearchPageGenerator {
    public static SearchPageObject getSearchPageObject(WebDriver driver){
        return new SearchPageObject(driver);
    }
}
