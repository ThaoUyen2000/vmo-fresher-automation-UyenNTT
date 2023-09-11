package com.vmo.nopcommerce.pageobject.softwarepage;

import com.vmo.nopcommerce.common.BasePage;
import com.vmo.nopcommerce.common.GlobalConstants;
import com.vmo.nopcommerce.interfaces.SoftwarePageUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SoftwarePageObject extends BasePage {
    WebDriver driver;

    public SoftwarePageObject(WebDriver driver) {
        this.driver = driver;
    }
    public void selectSortBy(String option){
        selectItemInDefaultDropdownByText(driver, SoftwarePageUI.SORT_BY,option);
    }

    public String getSelectedSortBy() {
        return getSelectedItemInDefaultDropdown(driver, SoftwarePageUI.SORT_BY);
    }

    public boolean isSortZtoAWorked() {
        overrideImplicitTimeOut(driver, GlobalConstants.LONG_TIMEOUT);
        List<String> productNames = getTextElements(driver, SoftwarePageUI.PRODUCT_LIST);
        List<String> sortedProductNames = new ArrayList<>(productNames);
        Collections.sort(sortedProductNames, Collections.reverseOrder());
        System.out.println(productNames);
        System.out.println(sortedProductNames);
        if (productNames.equals(sortedProductNames)) {
            return true;
        } else {
            return false;
        }
    }

    public void isSortSelected(String option) {
        if (getSelectedSortBy().equals(option)) {
            System.out.println("Sort option is selected.");
        } else {
            System.out.println("Sort option verification failed.");
        }
    }
}
