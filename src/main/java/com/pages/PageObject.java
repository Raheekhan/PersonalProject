package com.pages;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {

    protected RemoteWebDriver driver;
    protected WebDriverWait wait;

    public PageObject(RemoteWebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 3);
        PageFactory.initElements(driver, this);
    }

}
