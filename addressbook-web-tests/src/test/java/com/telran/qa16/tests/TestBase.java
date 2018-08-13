package com.telran.qa16.tests;

import com.telran.qa16.manager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase
{

    public static ApplicationManager app
            = new ApplicationManager(System.getProperty("browser",BrowserType.CHROME));

    @BeforeSuite
    public void setUp(){
        app.start();
    }


    @AfterSuite(alwaysRun = true)
    public void tearDown(){
        app.stop();
    }


}
