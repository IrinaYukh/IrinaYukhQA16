package com.telran.qa16;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class GroupDeletionTest {
    WebDriver wd;  // driver

    @BeforeMethod
    public void setUp() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/");
        login("admin", "secret");
    }

    @Test
    public void groupDeletionTest() {
        clickGroupsButton();
        selectDeletedGroupCheckBox();
        clickDeleteGroupsButton();
        returnToGroupPage();
    }


    private void login(String user, String password) {
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys(user);

        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys(password);

        //wd.findElement(By.xpath("//*[@id=\'LoginForm\']/input[3]")).click();
        wd.findElement(By.xpath("//*[@type='submit']")).click();
    }

    private void clickGroupsButton() {
        wd.findElement(By.xpath("//*[@id=\"nav\"]/ul/li[3]/a")).click();
        //wd.findElement(By.xpath("//*[@href='group.php']")).click();
    }

    private void selectDeletedGroupCheckBox() {
        wd.findElement(By.name("selected[]")).click();
    }

    private void clickDeleteGroupsButton() {
        wd.findElement(By.name("delete")).click();
    }

    public void returnToGroupPage()
    {
        wd.findElement(By.xpath("//*[@id=\"content\"]/div/i/a")).click();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown()
    {
        // Make a pause before close browser
        try
        {
            Thread.sleep(5000);
        } catch(InterruptedException e)
        {
            e.printStackTrace();
        }

        wd.quit();
    }


    private boolean isElementPresent(By locator)
    {
        try
        {
            wd.findElement(locator);
            return true;
        }
        catch (NoSuchElementException e)
        {
            return false;
        }
    }
}

