package com.telran.qa16.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase
{
    @Test
    public void deleteContactTest1()
    {
        // Method for checking if some elements present into the table of Contacts
        if (!app.getContactHelper().isContactPresent())
        {
            app.getContactHelper().createContact();
        }
        int before = app.getContactHelper().getContactsSize();

        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContact();
        // Confirm alert message during deletion of contact
        app.getContactHelper().confirmAlert();

        int after = app.getContactHelper().getContactsSize();

        Assert.assertEquals(after, before - 1);
    }

    @Test
    public void deleteContactUsingSelectByIndexTest()
    {
        if (!app.getContactHelper().isContactPresent())
        {
            app.getContactHelper().createContact();
        }
        int before = app.getContactHelper().getContactsSize();

        app.getContactHelper().selectContactByIndex(before-2);
        before = app.getContactHelper().getContactsSize();
        app.getContactHelper().clickEditContactIcon();
        app.getContactHelper().deleteContactByEdit();
        int after = app.getContactHelper().getContactsSize();

        Assert.assertEquals(after, before-1);

    }

    @Test
    public void deleteContactTestByEditIcon()
    {
        if (!app.getContactHelper().isContactPresent())
        {
            app.getContactHelper().createContact();
        }
        int before = app.getContactHelper().getContactsSize();
        app.getContactHelper().selectContact();
        app.getContactHelper().clickEditContactIcon();
        app.getContactHelper().deleteContactByEdit();
        int after = app.getContactHelper().getContactsSize();

        Assert.assertEquals(after, before-1);

    }

    @Test()
    public void deleteAllContactsTest3()
    {
        if (!app.getContactHelper().isContactPresent())
        {
            app.getContactHelper().createContact();
        }
        int before = app.getContactHelper().getContactsSize();
        app.getContactHelper().selectAllContacts();
        app.getContactHelper().deleteContact();
        app.getContactHelper().confirmAlert();
        int after = app.getContactHelper().getContactsSize();

        Assert.assertEquals(after, before - before);

    }

}
