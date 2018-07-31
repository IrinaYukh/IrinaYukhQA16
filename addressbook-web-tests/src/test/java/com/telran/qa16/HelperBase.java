package com.telran.qa16;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class HelperBase
{
    public WebDriver wd;

    public HelperBase(WebDriver wd)
    {
        this.wd = wd;
    }

    public void click(By locator)
    {
        wd.findElement(locator).click();
    }

    public boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementsPresent(By locator) {
        return wd.findElements(locator).size() > 0;
    }

}
