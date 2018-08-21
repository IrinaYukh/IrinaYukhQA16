package com.telran.qa16.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager
{
    ContactHelper contactHelper;
    SessionHelper sessionHelper;
    GroupHelper groupHelper;

    private WebDriver wd;
    private String browser;

    public ApplicationManager(String browser) {

        this.browser = browser;
    }


    public void start()
    {
        if (browser.equals(BrowserType.CHROME))
        {
            wd = new ChromeDriver();
        }
        else if(browser.equals(BrowserType.FIREFOX))
        {
            wd=new FirefoxDriver();
        }

        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        sessionHelper = new SessionHelper(wd);
        sessionHelper.openSite("http://autoauction.co.il/%d7%a8%d7%90%d7%a9%d7%99/");
 //     sessionHelper.login("admin", "secret");
        groupHelper = new GroupHelper(wd);
        contactHelper = new ContactHelper(wd);
    }

    public void stop() {
        wd.quit();
    }



    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }


    public ContactHelper getContactHelper() {
        return contactHelper;
    }
}
