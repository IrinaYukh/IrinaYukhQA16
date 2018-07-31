package com.telran.qa16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper extends HelperBase
{
    public ContactHelper(WebDriver wd)
    {
        super(wd);
    }

    public void goToAddNewContact(){
        click(By.xpath("//a[contains(text(),'ADD_NEW')]"));
    }

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void selectContactByIndex(int index)
    {
        if (index < 0)
        {
            int size = (-(index));
            for (int i = 0; i < size; i++)
            {
                createContact();
            }
            int newIndex = getContactsSize()-getContactsSize();
            wd.findElements(By.name("selected[]")).get(newIndex).click();

        } else {

            wd.findElements(By.name("selected[]")).get(index).click();

        }

    }

    public void selectAllContacts() {
        click(By.id("MassCB"));
    }


    // verifications of existing

    public boolean isContactPresent() {
        return isElementsPresent(By.name("selected[]"));
    }

    public void createContact() {
        goToAddNewContact();
        fillContactForm(new ContactData().setFirstname("John")
                .setLastname("Doe")
                .setAddress("Israel")
                .setEmail("johnDoe@mail.com")
                .setPhone("03-363-1234"));
        submitContactCreation();
    }


    // contact creation

    public void fillContactForm(ContactData contactData)
    {
        type(By.name("firstname"),contactData.getFirstname());
        type(By.name("lastname"),contactData.getLastname());
        type(By.name("address"),contactData.getAddress());
        type(By.name("home"),contactData.getPhone());
        type(By.name("email"),contactData.getEmail());
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }


    // contact modification

    public void clickEditContactIcon() {
        click(By.xpath("//img[@title='EDIT']"));
    }

    public void submitContactModification() {
        click(By.name("update"));
    }


    // contact deletion

    public void deleteContact() {
        click(By.xpath("//*[@value='DELETE']"));
    }

    public void deleteContactByEdit() {
        click(By.xpath("//*[@value='DELETE']"));
    }

    public int getContactsSize() {
        return wd.findElements(By.name("selected[]")).size();
    }



    public void confirmAlert() {
        wd.switchTo().alert().accept();
    }

    public void dismissAlert() {
        wd.switchTo().alert().dismiss();
    }






}
