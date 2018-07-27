package com.telran.qa16;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {

    WebDriver wd;  // driver


    @BeforeClass
    public void setUp() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/");
        login("admin", "secret");
    }

    public void login(String user, String password) {
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys(user);

        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys(password);

        wd.findElement(By.xpath("//*[@type='submit']")).click();
    }

    // Create Group

    public void goToGroupsPage() {
        //wd.findElement(By.cssSelector("[href='group.php']")).click();
        wd.findElement(By.xpath("//*[@href='group.php']")).click();
    }

    public void initGroupCreation() {

        wd.findElement(By.xpath("//*[@name='new']")).click();
        //wd.findElement(By.name("new")).click();
    }

    public void submitGroupCreation() {
        wd.findElement(By.xpath("//input[@value='Enter information']")).click();
    }

    public void returnToGroupPage() {
        wd.findElement(By.xpath("//a[contains(text(),'group page')]")).click();
    }

    public void createGroup() {
        initGroupCreation();
        fillGroupForm(new GroupData().setName("nameFromTestBase")
                .setLogo("logoFromTestBase")
                .setComment("commentFromTestBase"));
        submitGroupCreation();
        returnToGroupPage();
    }


    //Edit Group

    public void initGroupModification() {
        wd.findElement(By.name("edit")).click();
    }

    public void selectGroupCheckBox() {
        wd.findElement(By.name("selected[]")).click();
    }

    public void selectGroupByIndex(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();

    }

    public void fillGroupForm(GroupData groupData) {
        wd.findElement(By.name("group_name")).click();
        wd.findElement(By.name("group_name")).clear();
        wd.findElement(By.name("group_name")).sendKeys(groupData.getName());

        wd.findElement(By.name("group_header")).click();
        wd.findElement(By.name("group_header")).clear();
        wd.findElement(By.name("group_header")).sendKeys(groupData.getLogo());

        wd.findElement(By.name("group_footer")).click();
        wd.findElement(By.name("group_footer")).clear();
        wd.findElement(By.name("group_footer")).sendKeys(groupData.getComment());

    }

    public void submitGroupModification() {
        wd.findElement(By.name("update")).click();
    }


    //Delete Group

    public void initGroupDeletion() {
        wd.findElement(By.name("delete")).click();
    }


    // Add Contact

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
        fillContactForm(new ContactData().setFirstname("John").setLastname("Doe")
                .setAddress("Israel")
                .setEmail("johnDoe@mail.com").setPhone("03-363-1234"));
        submitContactCreation();
    }


    // Edit Contact

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

    public void selectContactByIndex(int index) {

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


    // Delete Contact

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

    public boolean isGroupPresent() {
        return isElementPresent(By.name("selected[]"));
    }


    @AfterClass(alwaysRun = true)
    public void tearDown() {
        wd.quit();
    }


    public int getContactsSize() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public int getGroupsSize() {
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


}
