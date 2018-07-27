package com.telran.qa16;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase
{
    @Test
    public void deleteContactTest1()
    {
        // Method for checking if some elements present into the table of Contacts
        if (!isContactPresent())
        {
            createContact();
        }
        int before = getContactsSize();

        selectContact();
        deleteContact();
        // Confirm alert message during deletion of contact
        confirmAlert();

        int after = getContactsSize();

        Assert.assertEquals(after, before - 1);
    }

    @Test
    public void deleteContactUsingSelectByIndexTest()
    {
        if (!isContactPresent())
        {
            createContact();
        }
        int before = getContactsSize();

        selectContactByIndex(before-2);
        before = getContactsSize();
        clickEditContactIcon();
        deleteContactByEdit();
        int after = getContactsSize();

        Assert.assertEquals(after, before-1);

    }

    @Test
    public void deleteContactTestByEditIcon()
    {
        if (!isContactPresent())
        {
            createContact();
        }
        int before = getContactsSize();
        selectContact();
        clickEditContactIcon();
        deleteContactByEdit();
        int after = getContactsSize();

        Assert.assertEquals(after, before-1);

    }

    @Test()
    public void deleteAllContactsTest3()
    {
        if (!isContactPresent())
        {
            createContact();
        }
        int before = getContactsSize();
        selectAllContacts();
        deleteContact();
        confirmAlert();
        int after = getContactsSize();

        Assert.assertEquals(after, before - before);

    }

}
