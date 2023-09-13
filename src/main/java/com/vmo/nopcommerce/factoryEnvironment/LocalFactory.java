package com.vmo.nopcommerce.factoryEnvironment;

import com.vmo.nopcommerce.factioryBrowser.BrowserNotSupportedException;
import com.vmo.nopcommerce.factioryBrowser.ChromeDriverManager;
import com.vmo.nopcommerce.factioryBrowser.EdgeDriverManager;
import com.vmo.nopcommerce.factioryBrowser.FireFoxDriverManager;
import org.openqa.selenium.WebDriver;

public class LocalFactory {
    private WebDriver driver;
    public WebDriver createDriver(String browser){
        browser = browser.toUpperCase();
        switch (browser){
            case "CHROME":
                driver  = new ChromeDriverManager().getBrowserDriver();
                break;
            case "FIREFOX":
                driver  = new FireFoxDriverManager().getBrowserDriver();
                break;
            case "EDGE":
                driver  = new EdgeDriverManager().getBrowserDriver();
                break;
            default:
                throw new BrowserNotSupportedException(browser);
        }
        return driver;
    }
}
