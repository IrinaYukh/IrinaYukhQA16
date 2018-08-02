package com.telran.qa16.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase
{

    public SessionHelper(WebDriver wd)
    {
        super(wd);
    }

    public void openSite(String url) {
        wd.get(url);
    }

    public void login(String userName, String password) {
        type(By.name("user"),userName);
        type(By.name("pass"),password);
        // click on logIn button
        click(By.xpath("//*[@type='submit']"));
    }


    public void logout() {
        click(By.xpath("//a[@onclick='document.logout.submit();']"));
    }
}
