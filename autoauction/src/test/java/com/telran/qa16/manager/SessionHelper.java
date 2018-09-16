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

    public void loginUser(String userName, String password) throws InterruptedException {
        click(By.xpath("//span[contains(text(),'התחבר')]"));
        Thread.sleep(1000);
        type(By.xpath("//div[@class='userpro-input']//input[@data-condition_fields='username_or_email'][@type='text']"),userName);
        Thread.sleep(1000);
        type(By.xpath("//div[@class='userpro-input']//input[@data-condition_fields='username_or_email'][@type='password']"),password);
        Thread.sleep(3000);
       // click(By.xpath("//input[@class='userpro-button']"));
        click(By.xpath("/html[1]/body[1]/div[3]/header[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[7]/input[1]"));
    }

    public void logout() {
        click(By.xpath("//a[@title='Exit']"));
    //    click(By.cssSelector("a.logout"));
    }

    public boolean isLoggedIn()
    {
        return isElementPresent(By.cssSelector("div.user-main-info"));
    }
}
