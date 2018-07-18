package com.telran.qa16;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class ContactCreationTest
{
    WebDriver wd;

    @BeforeClass
    public void setUp()
    {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        wd.navigate().to("http://localhost/addressbook");
        login("admin", "secret");
    }

    @Test
    public void contactCreationTest1()
    {
        clickAddNewButton();
        addNewEntry("Ivan","Ivanov","Rehovot,25 Herzel Street, apt.7","ivan57@mail.com","08-654-2222");
    }

    @Test
    public void contactCreationTest2()
    {
        clickAddNewButton();
        addNewEntry("John","Smith","Ashdod,7 Herzel Street, apt.89","jonhsmith@gmail.com","08-896-7550");
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

    private void clickAddNewButton()
    {
        wd.findElement(By.xpath("//*[@id=\"nav\"]/ul/li[2]/a")).click();
    }

    private void addNewEntry(String firstname, String lastname, String address, String email, String phone)
    {
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(firstname);

        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys(lastname);

        wd.findElement(By.name("address")).click();
        wd.findElement(By.name("address")).clear();
        wd.findElement(By.name("address")).sendKeys(address);

        wd.findElement(By.xpath("//*[@id=\"content\"]/form/input[10]")).click();
        wd.findElement(By.xpath("//*[@id=\"content\"]/form/input[10]")).clear();
        wd.findElement(By.xpath("//*[@id=\"content\"]/form/input[10]")).sendKeys(phone);

        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys(email);

        wd.findElement(By.name("submit")).click();
    }


    @AfterClass(alwaysRun = true)
    public void tearDown()
    {
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

