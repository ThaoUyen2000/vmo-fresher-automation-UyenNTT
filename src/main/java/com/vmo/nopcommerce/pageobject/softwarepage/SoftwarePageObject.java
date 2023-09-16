package com.vmo.nopcommerce.pageobject.softwarepage;

import com.vmo.nopcommerce.common.BasePage;
import com.vmo.nopcommerce.common.GlobalConstants;
import com.vmo.nopcommerce.helper.Log;
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
        Log.info("Select Sort by");
        selectItemInDefaultDropdownByText(driver, SoftwarePageUI.SORT_BY,option);
    }

    public String getSelectedSortBy() {
        Log.info("Get selected Sort by");
        return getSelectedItemInDefaultDropdown(driver, SoftwarePageUI.SORT_BY);
    }

    public boolean isSortZtoAWorked() {
        Log.info("Check sort A-Z worked");
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

    public boolean isSortSelected(String option) {
        Log.info("Check sort selected");
        if (getSelectedSortBy().equals(option)) {
            return true;
        } else {
            return false;
        }
    }
}
