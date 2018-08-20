package com.telran.qa16.tests;

import com.telran.qa16.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactDeletionTest extends TestBase
{
    @Test
    public void deleteContactTest1() throws InterruptedException {

        app.getContactHelper().isOnContactPage();

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
        app.getContactHelper().isOnContactPage();

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
        app.getContactHelper().isOnContactPage();

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
    public void deleteAllContactsTest3() throws InterruptedException {
        app.getContactHelper().isOnContactPage();

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

    @Test
    public void deleteContactByIndexUsingListTest()
    {
        app.getContactHelper().isOnContactPage();

        if (!app.getContactHelper().isContactPresent())
        {
            app.getContactHelper().createContact();
        }
        List<ContactData>contactListBefore = app.getContactHelper().getContactList();

        app.getContactHelper().selectContactByIndex(contactListBefore.size()-2);
        contactListBefore = app.getContactHelper().getContactList();
        app.getContactHelper().clickEditContactIcon();
        app.getContactHelper().deleteContactByEdit();


        List<ContactData>contactListAfter = app.getContactHelper().getContactList();

        contactListBefore.remove(contactListBefore.size()-2);

        Assert.assertEquals(contactListAfter.size(), contactListBefore.size());
        Assert.assertEquals(contactListAfter, contactListBefore);

    }

    @Test
    public void deleteContactWithListTest() throws InterruptedException {

        app.getContactHelper().isOnContactPage();

        // Method for checking if some elements present into the table of Contacts
        if (!app.getContactHelper().isContactPresent())
        {
            app.getContactHelper().createContact();
        }

        List<ContactData>contactBefore = app.getContactHelper().getContactList();

        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContact();
        // Confirm alert message during deletion of contact
        app.getContactHelper().confirmAlert();

        List<ContactData>contactAfter = app.getContactHelper().getContactList();
        contactBefore.remove(0); // remove from the List, that was created before the deletion
                                            // into the table, object with index [0]

        Assert.assertEquals(contactAfter.size(), contactBefore.size());
        Assert.assertEquals(contactAfter,contactBefore);

    }

}
