package com.telran.qa16.tests;

import com.telran.qa16.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.*;


public class ContactCreationTest extends TestBase
{

    @Test
    public void contactCreationTest1()
    {
        app.getContactHelper().isOnContactPage();

        int before = app.getContactHelper().getContactsSize();
        app.getContactHelper().goToAddNewContact();
        app.getContactHelper().fillContactForm(new ContactData().setFirstname("Ivan")
                .setLastname("Ivanov")
                .setAddress("Rehovot,25 Herzel Street, apt.7")
                .setEmail("ivan57@mail.com").setPhone("08-654-2222"));
        app.getContactHelper().submitContactCreation();

        int after = app.getContactHelper().getContactsSize();

        Assert.assertEquals(after,before+1);
    }

    @Test
    public void contactCreationTest2()
    {
        app.getContactHelper().isOnContactPage();

        int before = app.getContactHelper().getContactsSize();
        app.getContactHelper().goToAddNewContact();
        app.getContactHelper().fillContactForm(new ContactData().setFirstname("John")
                .setLastname("Smith")
                .setAddress("Ashdod,7 Herzel Street, apt.89")
                .setEmail("jonhsmith@gmail.com")
                .setPhone("08-896-7550"));
        app.getContactHelper().submitContactCreation();
        int after = app.getContactHelper().getContactsSize();

        Assert.assertEquals(after, before+1);
    }

    @Test
    public void contactCreationTest3()
    {
        app.getContactHelper().isOnContactPage();

        int before = app.getContactHelper().getContactsSize();
        app.getContactHelper().goToAddNewContact();
        app.getContactHelper().fillContactForm(new ContactData().setFirstname("")
                .setLastname("")
                .setAddress("")
                .setEmail("")
                .setPhone(""));
        app.getContactHelper().submitContactCreation();
        int after = app.getContactHelper().getContactsSize();

        Assert.assertEquals(after, before+1);
    }

}

