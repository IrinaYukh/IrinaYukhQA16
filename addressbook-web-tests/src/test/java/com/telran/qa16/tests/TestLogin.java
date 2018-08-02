package com.telran.qa16.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestLogin extends TestBase
{
    @BeforeTest
    public void precondition()
    {
        app.getSessionHelper().logout();
    }

    @Test

    public void loginPositiveTest()
    {
        app.getSessionHelper().login("admin","secret");

        Assert.assertTrue(app.getSessionHelper().isElementPresent(By.xpath("//a[@onclick='document.logout.submit();']")));

    }


    @Test
    public void loginNegativeTest()
    {
        app.getSessionHelper().login("admin","pops");

        Assert.assertFalse(app.getSessionHelper().isElementPresent(By.xpath("//a[@onclick='document.logout.submit();']")));

    }


}
