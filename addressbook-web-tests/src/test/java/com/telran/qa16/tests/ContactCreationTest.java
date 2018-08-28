package com.telran.qa16.tests;

import com.telran.qa16.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;


public class ContactCreationTest extends TestBase
{

    @Test
    public void contactCreationTestWithPhotoAttach()  // in this Test have method attach Photo
    {
        app.getContactHelper().isOnContactPage();

        int before = app.getContactHelper().getContactsSize();
        app.getContactHelper().goToAddNewContact();

        File photo = new File("src/test/resources/cat.jpg");


        app.getContactHelper().fillContactForm(new ContactData().setFirstname("1Ivan")
                .setLastname("1Ivanov")
                .setAddress("Rehovot,25 Herzel Street, apt.7")
                .setEmail("ivan57@mail.com").setPhone("08-654-2222").setPhoto(photo).setGroup("aa"));
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
                .setEmail("list@mail.com").setPhone("08-654-2222").setGroup("aa");
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

    @DataProvider
    public Iterator<Object[]>validContacts() throws IOException {
        List<Object[]>list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")));

        String line = reader.readLine();

        while(line != null)
        {
            String[] split = line.split(",");
            list.add(new Object[]{new ContactData()
                    .setFirstname(split[0]).setLastname(split[1]).setAddress(split[2]).setGroup("aa")});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @Test(dataProvider = "validContacts")
    public void contactCreationTestWithProvider(ContactData contact)
    {
        app.getContactHelper().isOnContactPage();

        List<ContactData> contactBefore = app.getContactHelper().getContactList();

        app.getContactHelper().goToAddNewContact();
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitContactCreation();
        List<ContactData> contactAfter = app.getContactHelper().getContactList();

        Assert.assertEquals(contactAfter.size(), contactBefore.size()+1);
    }

}

