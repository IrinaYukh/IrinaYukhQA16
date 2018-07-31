package com.telran.qa16;

import org.testng.Assert;
import org.testng.annotations.Test;

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

}
