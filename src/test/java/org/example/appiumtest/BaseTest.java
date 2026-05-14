package org.example.appiumtest;

import driver.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.net.MalformedURLException;

public class BaseTest {

    @BeforeMethod(description="Launch driver on start", alwaysRun = true)
    public void startDriver() throws MalformedURLException {

        DriverManager.initDriver();
    }

    @AfterMethod(description="Post test teardown", alwaysRun = true)
    public void teardownTest(){
        DriverManager.quitDriver();
    }

    protected  AppiumDriver getDriver(){
        return DriverManager.getDriver();
    }
}
