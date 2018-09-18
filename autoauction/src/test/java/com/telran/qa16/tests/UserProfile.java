package com.telran.qa16.tests;

import com.telran.qa16.model.CompanyData;
import com.telran.qa16.model.UserProfileData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserProfile extends TestBase
{
    @BeforeMethod
    public void openUserProfile() throws InterruptedException {
        if(!app.getSessionHelper().isLoggedIn())
        {
            app.getSessionHelper().loginUser("iytest18@gmail.com","aa123456");
        }
    }
    @Test
    public void createUserCompanyProfile()
    {
        app.getProfileHelper().initUserModification();

        app.getProfileHelper().fillUserCompanyForm(new CompanyData().setName("Arias")
            .setPositionName("seller").setAddress("Tel-Aviv, 6 Alenbi Street").setEmail("test@arias.co.il")
            .setPhone("03-362-2221").setCompanyArea("בנק"));

        app.getProfileHelper().submitUserModification();

        Assert.assertTrue(app.getSessionHelper().isElementPresent(By.cssSelector("div.user-main-info")));
    }

    @Test
    public void updateUserProfile()
    {
        app.getProfileHelper().initUserModification();

        app.getProfileHelper().fillUserProfileForm(new UserProfileData().setFirstname("name3")
                .setLastname("family3").setAddress("Ashdod,Israel")
                .setEmail("test3@mail.ru").setPhone("050-333-6547"));

        app.getProfileHelper().submitUserModification();

        Assert.assertTrue(app.getSessionHelper().isElementPresent(By.cssSelector("div.user-main-info")));
    }

    @Test
    public void updateUserProfileByRightMenu()
    {
        app.getProfileHelper().initUserModifyByMenu();

        app.getProfileHelper().fillUserProfileForm(new UserProfileData().setFirstname("nameEdit")
                .setLastname("editMenu").setAddress("Ashdod,Israel")
                .setEmail("test3@mail.ru").setPhone("050-333-6547"));

        app.getProfileHelper().submitUserModification();

        Assert.assertTrue(app.getSessionHelper().isElementPresent(By.cssSelector("div.user-main-info")));
    }

    @Test
    public void modifyUserCompanyProfile() throws InterruptedException {
        app.getProfileHelper().initUserModification();

        app.getProfileHelper().fillUserCompanyForm(new CompanyData().setName("Lotus")
                .setPositionName("seller").setAddress("Tel-Aviv, 6 Dizengoff Street").setEmail("test@lotus.co.il")
                .setPhone("072-111-3541").setCompanyArea("סוכנות רכב"));

        Thread.sleep(1000);
        app.getProfileHelper().submitUserModification();

        Assert.assertTrue(app.getSessionHelper().isElementPresent(By.cssSelector("div.user-main-info")));
    }

    @Test()
    public void userProfileRightMenuTest() throws InterruptedException {
        app.getProfileHelper().initUserModifyByMenu();
        app.getProfileHelper().userProfileButton();
        app.getProfileHelper().userBidsButton();
        app.getProfileHelper().userProfileExitButton();
        app.getProfileHelper().userProfileLogout();

        Assert.assertTrue(app.getSessionHelper().isElementPresent(By.xpath("//div[@class='row search-buttons']")));
    }

    @Test()
    public void updateMonth() throws InterruptedException {
        app.getProfileHelper().initUserModification();

        app.getSessionHelper().click(By.name("wpcf-bithday[display-only]"));

        WebElement listMonth = app.getSessionHelper().wd
                .findElement(By.xpath("//select[@class='ui-datepicker-month']"));
        app.getSelectTest().getSelect(listMonth);
        app.getSelectTest().select.selectByValue("0");

        Thread.sleep(2000);

        app.getProfileHelper().submitUserModification();
        Thread.sleep(2000);

        Assert.assertTrue(app.getSessionHelper().isElementPresent(By.cssSelector("div.user-main-info")));
    }

    @Test()
    public void updateYear() throws InterruptedException {
        app.getProfileHelper().initUserModification();

        app.getSessionHelper().click(By.name("wpcf-bithday[display-only]"));

        WebElement listYear = app.getSessionHelper().wd
                .findElement(By.xpath("//select[@class='ui-datepicker-year']"));
        app.getSelectTest().getSelect(listYear);
        app.getSelectTest().select.selectByValue("1950");
        Thread.sleep(2000);
        //listYear.sendKeys(Keys.ENTER);


        app.getProfileHelper().submitUserModification();

        Assert.assertTrue(app.getSessionHelper().isElementPresent(By.cssSelector("div.user-main-info")));
    }
}
