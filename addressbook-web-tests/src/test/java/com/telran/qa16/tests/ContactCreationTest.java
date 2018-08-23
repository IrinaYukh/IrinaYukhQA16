package com.telran.qa16.tests;

import com.telran.qa16.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.HashSet;
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

        List<ContactData> contactBefore = app.getContactHelper().getContactList();

        app.getContactHelper().goToAddNewContact();
        ContactData contact = new ContactData().setFirstname("listName")
                .setLastname("listFamily")
                .setAddress("Rehovot,")
                .setEmail("list@mail.com").setPhone("08-654-2222");
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitContactCreation();

        List<ContactData> contactAfter = app.getContactHelper().getContactList();

        Assert.assertEquals(contactAfter.size(), contactBefore.size()+1);

        contactBefore.add(contact);
        int max = 0;
        for (ContactData cont: contactAfter )
        {
            if (cont.getId()>max)
            {
                max = cont.getId();
            }
            contact.setId(max);
        }
        Assert.assertEquals(new HashSet<Object>(contactAfter), new HashSet<Object>(contactBefore));
        System.out.println(contactBefore.toString());
        System.out.println(contactAfter.toString());
    }


}

