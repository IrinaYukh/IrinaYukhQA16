package com.telran.qa16;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase
{
    @Test
    public void deleteContactTest1()
    {
        int before = wd.findElements(By.name("selected[]")).size();

        selectContact();
        deleteContact();
        // Confirm alert message during deletion of contact
        confirmAlert();

        int after = wd.findElements(By.name("selected[]")).size();

        Assert.assertEquals(after, before - 1);
    }

    @Test
    public void deleteContactTest2()
    {
        int before = wd.findElements(By.name("selected[]")).size();

        selectContact();
        clickEditContactIcon();
        deleteContactByEdit();

        int after = wd.findElements(By.name("selected[]")).size();

        Assert.assertEquals(after, before - 1);
    }

    @Test
    public void deleteAllContactsTest3()
    {
        selectAllContacts();
        deleteContact();
        confirmAlert();

    }

}
