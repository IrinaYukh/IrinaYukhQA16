package com.telran.qa16.tests;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class MyListener extends AbstractWebDriverEventListener
{
    //create the logger for current test Class
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver)
    {
        System.out.println("element  " + by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver)
    {
        logger.info( by + "found");
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {

        // create temp file
        File temp = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        File screen = new File("screen - " + System.currentTimeMillis()+ " .png");

        try {
            Files.copy(temp,screen);  // copy from temp to screen
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.error("ERROR!!! from Log" + screen + throwable);
    }
}
