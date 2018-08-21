package com.telran.qa16.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenSiteTest extends TestBase
{
    @Test
    public void testSiteOpened()
    {
      Assert.assertTrue(app.getSessionHelper()
                .isElementPresent(By.xpath("//img[@src='http://autoauction.co.il/wp-content/uploads/2018/05/logo.png']")));
    }
}
