package com.ims.utils;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    private static ExtentReports extent;
    private static ExtentTest test;

    public static void initReports() {
        if (extent == null) {
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
            sparkReporter.config().setDocumentTitle("IMS Test Report");
            sparkReporter.config().setReportName("Inventory Management System - Test Results");
            sparkReporter.config().setTheme(Theme.STANDARD);

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            extent.setSystemInfo("Application", "IMS - Inventory Management System");
            extent.setSystemInfo("Environment", "Test");
            extent.setSystemInfo("Tester", "HAMZA");
        }
    }

    public static void startTest(String testName) {
        test = extent.createTest(testName);
    }

    public static void logInfo(String message) {
        if (test != null) {
            test.info(message);
        }
    }

    public static void logPass(String message) {
        if (test != null) {
            test.pass(message);
        }
    }

    public static void logFail(String message) {
        if (test != null) {
            test.fail(message);
        }
    }

    public static void logError(String message) {
        if (test != null) {
            test.fail(message);
        }
    }

    public static void endTest() {
        // Test automatically ends when moving to next test
    }

    public static void flushReports() {
        if (extent != null) {
            extent.flush();
        }
    }
}
