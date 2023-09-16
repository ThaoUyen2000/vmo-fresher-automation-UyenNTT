package com.vmo.nopcommerce.helper;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Start");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Success");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Failure");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Skipped");
    }
    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Finish");
    }
}
