package com.telran.qa16.tests;

import com.telran.qa16.manager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class TestBase extends MyListener
{

    public static ApplicationManager app
            = new ApplicationManager(System.getProperty("browser",BrowserType.CHROME));

    @BeforeMethod
    public void logTestStart(Method m)
    {
        logger.info("Start test " + m.getName());
    }

    @AfterMethod(alwaysRun = true)
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
