package com.telran.qa16;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase
{
    @Test
    public void modifyContactTest()
    {
        int before = getContactsSize();
        selectContact();
        clickEditContactIcon();
        fillContactForm(new ContactData().setFirstname("Sema").setLastname("Fishman").setAddress("Rehovot,8 Wiezman Street, apt.9").setEmail("fishman552@mail.com").setPhone("08-946-3300"));
        submitContactModification();
        int after = getContactsSize();

        Assert.assertEquals(after, before);
    }

    @Test
    public void modifyContactTest1()
    {
        int before = getContactsSize();
        selectContact();
        clickEditContactIcon();
        fillContactForm(new ContactData().setFirstname("Richard").setLastname("Lockey").setAddress("Tel-Aviv,2 Lincoln Street, apt.2").setEmail("richardloc@yahoo.com").setPhone("03-310-9612"));
        submitContactModification();
        int after = getContactsSize();

        Assert.assertEquals(after, before);
    }


}
