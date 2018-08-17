package com.telran.qa16.tests;

import com.telran.qa16.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;


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

    @Test
    public void getContactList()
    {
        app.getContactHelper().isOnContactPage();

        app.getContactHelper().getContactList();
    }

    @Test
    public void contactCreationByListTest()
    {
        app.getContactHelper().isOnContactPage();

        List<ContactData> contactListBefore = app.getContactHelper().getContactList();

        app.getContactHelper().goToAddNewContact();
        app.getContactHelper().fillContactForm(new ContactData().setFirstname("listName")
                .setLastname("listFamily")
                .setAddress("Rehovot,")
                .setEmail("list@mail.com").setPhone("08-654-2222"));
        app.getContactHelper().submitContactCreation();

        List<ContactData> contactListAfter = app.getContactHelper().getContactList();

        Assert.assertEquals(contactListAfter.size(), contactListBefore.size()+1);
    }

}

