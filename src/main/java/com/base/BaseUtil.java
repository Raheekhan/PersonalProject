package com.base;

import com.exceptions.NoSuchBrowserException;
import com.exceptions.NoSuchPlatformException;
import com.experitest.appium.SeeTestCapabilityType;
import com.experitest.reporter.testng.Listener;
import com.utils.Logger;
import com.utils.PropertiesHelper;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

@Listeners(Listener.class)
public class BaseUtil {

    protected RemoteWebDriver driver;
    protected DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

    private PropertiesHelper propertiesHelper = new PropertiesHelper();

    @BeforeMethod
    @Parameters({"platformName", "browserName", "browserVersion"})
    public void setUp(@Optional("Windows") String platformName, @Optional("Chrome") String browserName,
                      @Optional("70") String browserVersion, @Optional Method method) throws MalformedURLException, NoSuchBrowserException, NoSuchPlatformException {

        desiredCapabilities.setCapability(SeeTestCapabilityType.TEST_NAME, method.getName());
        desiredCapabilities.setCapability(SeeTestCapabilityType.ACCESS_KEY, propertiesHelper.getProperty("accessKey"));
        desiredCapabilities.setCapability(CapabilityType.PLATFORM, getPlatform(platformName));
        desiredCapabilities.setCapability(CapabilityType.BROWSER_NAME, getBrowserName(browserName));
        desiredCapabilities.setCapability(CapabilityType.BROWSER_VERSION, browserVersion);

        try {
            driver = new RemoteWebDriver(new URL(propertiesHelper.getProperty("cloudURL")), desiredCapabilities);
        } catch (NoSuchSessionException e) {
            e.printStackTrace();
            Logger.log("Failed to initiate driver: " + e.getCause().toString());
        }
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        if (driver != null) {
            Logger.log("Quitting driver.");
            driver.quit();
        }

    }

    public String getPlatform(String platformName) throws NoSuchPlatformException {

        if (platformName.equalsIgnoreCase(Platform.MAC.toString())) {
            platformName = Platform.MAC.toString();
        } else if (platformName.equalsIgnoreCase(Platform.WINDOWS.toString())) {
            platformName = Platform.WINDOWS.toString();
        } else {
            throw new NoSuchPlatformException("No Such Platform Found. You entered: '" + platformName + "'." +
            " Following options available: " + Platform.MAC.toString() + " / " + Platform.WINDOWS.toString());
        }

        Logger.log("Choose platform '" + platformName + "'.");
        return platformName;

    }

    public String getBrowserName(String browserName) throws NoSuchBrowserException {

        if (browserName.equalsIgnoreCase("Chrome")) {
            browserName = BrowserType.CHROME;
        } else if (browserName.equalsIgnoreCase("Firefox")) {
            browserName = BrowserType.FIREFOX;
        } else if (browserName.equalsIgnoreCase("IE")) {
            browserName = BrowserType.IE;
        } else if (browserName.equalsIgnoreCase("Edge")) {
            browserName = BrowserType.EDGE;
        } else if (browserName.equalsIgnoreCase("Safari")) {
            browserName = BrowserType.SAFARI;
        } else {
            throw new NoSuchBrowserException("No Such Browser Found. You entered: '" + browserName + "'." +
            " Following options available: " + BrowserType.CHROME + " / " + BrowserType.FIREFOX + " / ie" +
            " / edge / " + BrowserType.SAFARI + ".");
        }

        Logger.log("Started '" + browserName + "'.");
        return browserName;

    }

}
