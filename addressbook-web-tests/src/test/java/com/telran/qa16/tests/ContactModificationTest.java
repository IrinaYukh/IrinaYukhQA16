package com.telran.qa16.tests;

import com.telran.qa16.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTest extends TestBase
{
    @Test
    public void modifyContactTest()
    {
        // Method for checking if some elements present into the table of Contacts
        if (!app.getContactHelper().isContactPresent())
        {
            app.getContactHelper().createContact();
        }
        int before = app.getContactHelper().getContactsSize();
        app.getContactHelper().selectContact();
        app.getContactHelper().clickEditContactIcon();
        app.getContactHelper().fillContactForm(new ContactData().setFirstname("Sema").setLastname("Fishman").setAddress("Rehovot,8 Wiezman Street, apt.9").setEmail("fishman552@mail.com").setPhone("08-946-3300"));
        app.getContactHelper().submitContactModification();
        int after = app.getContactHelper().getContactsSize();

        Assert.assertEquals(after, before);
    }

    @Test
    public void modifyContactTest1()
    {
        if (!app.getContactHelper().isContactPresent())
        {
            app.getContactHelper().createContact();
        }
        int before = app.getContactHelper().getContactsSize();
        app.getContactHelper().selectContact();
        app.getContactHelper().clickEditContactIcon();
        app.getContactHelper().fillContactForm(new ContactData().setFirstname("Richard").setLastname("Lockey").setAddress("Tel-Aviv,2 Lincoln Street, apt.2").setEmail("richardloc@yahoo.com").setPhone("03-310-9612"));
        app.getContactHelper().submitContactModification();
        int after = app.getContactHelper().getContactsSize();

        Assert.assertEquals(after, before);
    }

    @Test
    public void modifyContactUsingSelectByIndexTest() {
        if (!app.getContactHelper().isContactPresent())
        {
            app.getContactHelper().createContact();
        }
        int before = app.getContactHelper().getContactsSize();
        app.getContactHelper().selectContactByIndex(before-2);
        before = app.getContactHelper().getContactsSize();
        app.getContactHelper().clickEditContactIcon();
        app.getContactHelper().fillContactForm(new ContactData().setFirstname("Maya").setLastname("Smith").setAddress("Raanana,56 Snow Street").setEmail("smithM@yahoo.com").setPhone("03-621-9001"));
        app.getContactHelper().submitContactModification();
        int after = app.getContactHelper().getContactsSize();

        Assert.assertEquals(after, before);
    }

    @Test
    public void modifyContactUsingListTest()
    {
        if (!app.getContactHelper().isContactPresent())
        {
            app.getContactHelper().createContact();
        }

        List<ContactData>contactListBefore = app.getContactHelper().getContactList();

        app.getContactHelper().selectContact();
        app.getContactHelper().clickEditContactIcon();

        ContactData tmpContact = new ContactData().setId(contactListBefore.get(0).getId()).setFirstname("changeIDname")
                .setLastname("changeIDfamily");
        app.getContactHelper().fillContactForm(tmpContact);

        app.getContactHelper().submitContactModification();

        List<ContactData>contactListAfter = app.getContactHelper().getContactList();
        contactListBefore.remove(0);
        contactListBefore.add(tmpContact);

        Assert.assertEquals(contactListAfter.size(),contactListBefore.size());
        Assert.assertEquals(new HashSet<Object>(contactListAfter), new HashSet<Object>(contactListBefore));
    }

}
