package com.telran.qa16.manager;

import com.telran.qa16.model.ContactData;
import com.telran.qa16.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase
{
    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void goToAddNewContact() {
        click(By.xpath("//a[@href='edit.php']"));
    }

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void selectContactByIndex(int index) {
        if (index < 0) {
            int size = (-(index));
            for (int i = 0; i < size; i++) {
                createContact();
            }
            int newIndex = getContactsSize() - getContactsSize();
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

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getPhone());
        type(By.name("email"), contactData.getEmail());
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }


    // contact modification

    public void clickEditContactIcon() {
        click(By.xpath("//img[@src='icons/pencil.png']"));
    }

    public void submitContactModification() {
        click(By.name("update"));
    }


    // contact deletion

    public void deleteContact() {
        click(By.xpath("//input[@type='button'][@onclick='DeleteSel()']"));
    }

    public void deleteContactByEdit() {
        click(By.xpath("//form[@action='delete.php']/input[@type='submit']"));
    }

    public int getContactsSize() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public void confirmAlert() throws InterruptedException {
        wd.switchTo().alert().accept();
        Thread.sleep(2000);
    }

    public void dismissAlert() {
        wd.switchTo().alert().dismiss();
    }

    public void isOnContactPage() {
        if (!isElementPresent(By.xpath("//table[@id='maintable']")))
        {
            click(By.xpath("//a[contains(text(),'HOME')]"));
        }
    }

    public List<ContactData> getContactList()
    {
        List<ContactData> contacts = new ArrayList<>();
        List<WebElement> rows = wd.findElements(By.tagName("tr"));

        for (int i = 1; i<rows.size(); i++)
        {
            WebElement row = rows.get(i);
            List<WebElement> cells = row.findElements(By.tagName("td"));
            String LastName  = cells.get(1).getText();
            String FirstName = cells.get(2).getText();

            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));

            ContactData contact = new ContactData().setFirstname(FirstName).setLastname(LastName).setId(id);
            contacts.add(contact);


            System.out.println("Name: " + FirstName + "   Family: " + LastName + "  id: " + id);

        }

        System.out.println(contacts);
        return contacts;
    }






}
