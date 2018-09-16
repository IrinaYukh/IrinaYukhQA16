package com.telran.qa16.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestLogin extends TestBase
{
    @BeforeMethod
    public void precondition()
    {
        if (app.getSessionHelper().isLoggedIn())
        {
            app.getSessionHelper().logout();
        }
    }

    @Test
    public void loginPositiveTest() throws InterruptedException {
        app.getSessionHelper().loginUser("iytest18@gmail.com","aa123456");

        Assert.assertTrue(app.getSessionHelper().isElementPresent(By.cssSelector("div.user-main-info")));
    }

    @Test
    public void loginNegativeTest() throws InterruptedException {
        app.getSessionHelper().loginUser("iytest18@gmail.com", "friendly");
        // Checking If warning message exist as enter correct password
        if (app.getSessionHelper().isElementPresent(By.xpath("//div[@class='userpro-warning']"))) {
            Thread.sleep(1000);
            app.getSessionHelper().type(By.xpath
                    ("//div[@class='userpro-input']//input[@data-condition_fields='username_or_email'][@type='password']"), "aa123456");
            Thread.sleep(1000);
            app.getSessionHelper().click(By.xpath
                    ("/html[1]/body[1]/div[3]/header[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[7]/input[1]"));
        }
        Assert.assertTrue(app.getSessionHelper().isElementPresent(By.cssSelector("div.user-main-info")));
    }


    @AfterMethod
    public void postConditionAfterLoginTest() throws InterruptedException {
        Thread.sleep(1000);
        if (!app.getSessionHelper().isElementPresent(By.cssSelector("div.user-main-info")))
        {
            app.getSessionHelper().loginUser("iytest18@gmail.com", "aa123456");
        }
    }


}
