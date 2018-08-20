package com.telran.qa16.tests;

import com.telran.qa16.manager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class TestBase
{
    //create the logger for current test Class
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    public static ApplicationManager app
            = new ApplicationManager(System.getProperty("browser",BrowserType.CHROME));

    @BeforeMethod
    public void logTestStart(Method m)
    {
        logger.info("Start test " + m.getName());
    }

    @AfterMethod( alwaysRun = true)
    public void logTestStop(Method m)
    {
        logger.info("Stop " + m.getName());
    }


    @BeforeSuite
    public void setUp(){
        app.start();
    }


    @AfterSuite(alwaysRun = true)
    public void tearDown(){
        app.stop();
    }


}
