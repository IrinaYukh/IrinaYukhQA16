package com.telran.qa16;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase
{
    @Test
    public void deleteContactTest1()
    {
        // Method for checking if some elements present into the table of Contacts
        if (!app.isContactPresent())
        {
            app.createContact();
        }
        int before = app.getContactsSize();

        app.selectContact();
        app.deleteContact();
        // Confirm alert message during deletion of contact
        app.confirmAlert();

        int after = app.getContactsSize();

        Assert.assertEquals(after, before - 1);
    }

    @Test
    public void deleteContactUsingSelectByIndexTest()
    {
        if (!app.isContactPresent())
        {
            app.createContact();
        }
        int before = app.getContactsSize();

        app.selectContactByIndex(before-2);
        before = app.getContactsSize();
        app.clickEditContactIcon();
        app.deleteContactByEdit();
        int after = app.getContactsSize();

        Assert.assertEquals(after, before-1);

    }

    @Test
    public void deleteContactTestByEditIcon()
    {
        if (!app.isContactPresent())
        {
            app.createContact();
        }
        int before = app.getContactsSize();
        app.selectContact();
        app.clickEditContactIcon();
        app.deleteContactByEdit();
        int after = app.getContactsSize();

        Assert.assertEquals(after, before-1);

    }

    @Test()
    public void deleteAllContactsTest3()
    {
        if (!app.isContactPresent())
        {
            app.createContact();
        }
        int before = app.getContactsSize();
        app.selectAllContacts();
        app.deleteContact();
        app.confirmAlert();
        int after = app.getContactsSize();

        Assert.assertEquals(after, before - before);

    }

}
