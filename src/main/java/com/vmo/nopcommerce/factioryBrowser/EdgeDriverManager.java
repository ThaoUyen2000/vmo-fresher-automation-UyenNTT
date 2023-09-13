package com.vmo.nopcommerce.factioryBrowser;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeDriverManager implements BrowserFactory{
    @Override
    public WebDriver getBrowserDriver() {
        EdgeOptions options = new EdgeOptions();
        return new EdgeDriver(options);
    }
}
