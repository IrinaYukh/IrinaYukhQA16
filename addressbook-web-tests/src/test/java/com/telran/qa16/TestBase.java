package com.telran.qa16;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase
{

    public static ApplicationManager app = new ApplicationManager();

    @BeforeSuite
    public void setUp(){
        app.start();
    }


    @AfterSuite(alwaysRun = true)
    public void tearDown(){
        app.stop();
    }


}
