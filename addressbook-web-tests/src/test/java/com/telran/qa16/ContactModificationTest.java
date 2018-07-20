package com.telran.qa16;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase
{
    @Test
    public void modifyContactTest()
    {
        selectContact();
        clickEditContactIcon();
        fillContactForm(new ContactData().setFirstname("Sema").setLastname("Fishman").setAddress("Rehovot,8 Wiezman Street, apt.9").setEmail("fishman552@mail.com").setPhone("08-946-3300"));
        submitContactModification();
    }

    @Test
    public void modifyContactTest1()
    {
        selectContact();
        clickEditContactIcon();
        fillContactForm(new ContactData().setFirstname("Richard").setLastname("Lockey").setAddress("Tel-Aviv,2 Lincoln Street, apt.2").setEmail("richardloc@yahoo.com").setPhone("03-310-9612"));
        submitContactModification();
    }


}
