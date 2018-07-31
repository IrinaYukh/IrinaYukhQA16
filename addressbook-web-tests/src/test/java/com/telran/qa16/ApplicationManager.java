package com.telran.qa16;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager
{
    SessionHelper sessionHelper;
    GroupHelper groupHelper;
    private WebDriver wd;

    public void start()
    {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        sessionHelper = new SessionHelper(wd);
        sessionHelper.openSite("http://localhost/addressbook/");
        sessionHelper.login("admin", "secret");
        groupHelper = new GroupHelper(wd);
    }


    public void goToGroupsPage() {
        //wd.findElement(By.cssSelector("[href='group.php']")).click();
        wd.findElement(By.xpath("//*[@href='group.php']")).click();
    }


    public void goToAddNewContact() {
        wd.findElement(By.xpath("//a[contains(text(),'ADD_NEW')]")).click();
    }

    public void fillContactForm(ContactData contactData) {
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstname());

        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys(contactData.getLastname());

        wd.findElement(By.name("address")).click();
        wd.findElement(By.name("address")).clear();
        wd.findElement(By.name("address")).sendKeys(contactData.getAddress());

        wd.findElement(By.name("home")).click();
        wd.findElement(By.name("home")).clear();
        wd.findElement(By.name("home")).sendKeys(contactData.getPhone());

        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys(contactData.getEmail());

    }

    public void submitContactCreation() {
        wd.findElement(By.name("submit")).click();
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

    public void selectContact() {
        wd.findElement(By.name("selected[]")).click();
    }

    public void clickEditContactIcon() {
        wd.findElement(By.xpath("//img[@title='EDIT']")).click();
    }

    public void submitContactModification() {
        wd.findElement(By.name("update")).click();
    }

    public boolean isContactPresent() {
        return isElementsPresent(By.name("selected[]"));
    }

    public void
    selectContactByIndex(int index) {

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

    public void deleteContact() {
        wd.findElement(By.xpath("//*[@value='DELETE']")).click();
    }

    public void confirmAlert() {
        wd.switchTo().alert().accept();
    }

    public void deleteContactByEdit() {
        wd.findElement(By.xpath("//*[@value='DELETE']")).click();
    }

    public void selectAllContacts() {
        wd.findElement(By.id("MassCB")).click();
    }

    public void dismissAlert() {
        wd.switchTo().alert().dismiss();
    }


    public void stop() {
        wd.quit();
    }

    public int getContactsSize() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementsPresent(By locator) {
        return wd.findElements(locator).size() > 0;
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }

    public void openSite(String url) {
        sessionHelper.openSite(url);
    }

    public void login(String user, String password) {
        sessionHelper.login(user, password);
    }
}
