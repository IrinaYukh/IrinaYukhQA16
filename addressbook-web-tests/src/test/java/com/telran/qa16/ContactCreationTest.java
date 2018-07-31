package com.telran.qa16;

import org.testng.Assert;
import org.testng.annotations.*;


public class ContactCreationTest extends TestBase
{

    @Test
    public void contactCreationTest1()
    {
        int before = app.getContactsSize();

        app.goToAddNewContact();
        app.fillContactForm(new ContactData().setFirstname("Ivan")
                .setLastname("Ivanov")
                .setAddress("Rehovot,25 Herzel Street, apt.7")
                .setEmail("ivan57@mail.com").setPhone("08-654-2222"));
        app.submitContactCreation();

        int after = app.getContactsSize();

        Assert.assertEquals(after,before+1);
    }

    @Test
    public void contactCreationTest2()
    {
        int before = app.getContactsSize();
        app.goToAddNewContact();
        app.fillContactForm(new ContactData().setFirstname("John")
                .setLastname("Smith")
                .setAddress("Ashdod,7 Herzel Street, apt.89")
                .setEmail("jonhsmith@gmail.com")
                .setPhone("08-896-7550"));
        app.submitContactCreation();
        int after = app.getContactsSize();

        Assert.assertEquals(after, before+1);
    }

    @Test
    public void contactCreationTest3()
    {
        int before = app.getContactsSize();
        app.goToAddNewContact();
        app.fillContactForm(new ContactData().setFirstname("")
                .setLastname("")
                .setAddress("")
                .setEmail("")
                .setPhone(""));
        app.submitContactCreation();
        int after = app.getContactsSize();

        Assert.assertEquals(after, before+1);
    }



}

