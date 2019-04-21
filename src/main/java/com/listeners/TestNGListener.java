package com.listeners;

import com.utils.Logger;
import org.testng.*;

public class TestNGListener implements ITestListener {

    public void onTestStart(ITestResult iTestResult) {
        Logger.log(iTestResult.getName() + " started.");
    }

    public void onTestSuccess(ITestResult iTestResult) {
        Logger.log(iTestResult.getName() + " was successful.");
    }

    public void onTestFailure(ITestResult iTestResult) {
        Logger.log(iTestResult.getName() + " failed.");
    }

    public void onTestSkipped(ITestResult iTestResult) {
        Logger.log(iTestResult.getName() + " skipped.");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {
        Logger.log(iTestContext.getName() + " started.");
    }

    public void onFinish(ITestContext iTestContext) {
        Logger.log(iTestContext.getName() + " finished.");
    }
}
