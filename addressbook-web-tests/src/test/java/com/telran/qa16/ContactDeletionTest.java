package com.telran.qa16;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase
{
    @Test
    public void deleteContactTest1()
    {
        int before = getContactsSize();

        selectContact();
        deleteContact();
        // Confirm alert message during deletion of contact
        confirmAlert();

        int after = getContactsSize();

        Assert.assertEquals(after, before - 1);
    }

    @Test
    public void deleteContactTest2()
    {
        int before = getContactsSize();

        selectContact();
        clickEditContactIcon();
        deleteContactByEdit();

        int after = getContactsSize();

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
