package com.telran.qa16;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class GroupCreationTest
{
    WebDriver wd;  // driver

    @BeforeClass
    public void setUp()
    {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/");
        login("admin", "secret");
    }

    @Test
    public void groupCreationTest()
    {
        clickGroupsButton();
        clickCreateNewGroupButton();
        createGroup("name","logo","comment");
        returnToCreateGroupPage();

    }

    @Test
    public void groupCreationTestWithoutName()
    {
        clickGroupsButton();
        clickCreateNewGroupButton();
        createGroup("","","");
        returnToCreateGroupPage();

    }

    @Test
    public void groupCreationTestWithLongName()
    {
        clickGroupsButton();
        clickCreateNewGroupButton();
        createGroup("nameJJJJOOOOHHHHNNNN","logo","comment25615");
        returnToCreateGroupPage();

    }

    private void login(String user, String password)
    {
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys(user);

        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys(password);

        //wd.findElement(By.xpath("//*[@id=\'LoginForm\']/input[3]")).click();
        wd.findElement(By.xpath("//*[@type='submit']")).click();
    }
    private void clickGroupsButton()
    {
        wd.findElement(By.xpath("//*[@id=\"nav\"]/ul/li[3]/a")).click();
        //wd.findElement(By.xpath("//*[@href='group.php']")).click();
    }

    private void clickCreateNewGroupButton()
    {
        wd.findElement(By.xpath("//*[@id=\"content\"]/form/input[4]")).click();
    }

    private void createGroup(String name, String logo, String comment)
    {
        wd.findElement(By.name("group_name")).click();
        wd.findElement(By.name("group_name")).clear();
        wd.findElement(By.name("group_name")).sendKeys(name);

        wd.findElement(By.name("group_header")).click();
        wd.findElement(By.name("group_header")).clear();
        wd.findElement(By.name("group_header")).sendKeys(logo);

        wd.findElement(By.name("group_footer")).click();
        wd.findElement(By.name("group_footer")).clear();
        wd.findElement(By.name("group_footer")).sendKeys(comment);

        wd.findElement(By.xpath("//*[@id=\"content\"]/form/input[2]")).click();

    }

    public void returnToCreateGroupPage()
    {
        wd.findElement(By.xpath("//*[@id=\"content\"]/div/i/a")).click();
    }


    @AfterClass(alwaysRun = true)
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
