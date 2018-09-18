package com.telran.qa16.manager;

import com.telran.qa16.model.CompanyData;
import com.telran.qa16.model.UserProfileData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ProfileHelper extends HelperBase
{
    public ProfileHelper(WebDriver wd) {
        super(wd);
    }

    public void fillUserCompanyForm(CompanyData companyData)
    {
        type(By.name("wpcf-company-name"),companyData.getName());
        type(By.name("wpcf-position"),companyData.getPositionName());
        type(By.name("wpcf-company-phone"),companyData.getPhone());
        type(By.name("wpcf-company-email"),companyData.getEmail());
        type(By.name("wpcf-company-address2"),companyData.getPhone());

        if (companyData.getCompanyArea() != null) {
            new Select(wd.findElement(By.xpath("//select[@data-wpt-field-title='Company area']")))
                    .selectByVisibleText(companyData.getCompanyArea());
        }
    }

    // user modification

    public void fillUserProfileForm(UserProfileData userData) {
        type(By.name("first_name"), userData.getFirstname());
        type(By.name("last_name"), userData.getLastname());
        type(By.name("wpcf-user-address"), userData.getAddress());
        type(By.name("wpcf-phone"), userData.getPhone());
        type(By.name("user_email"), userData.getEmail());
        type(By.name("wpcf-bithday[display-only]"), userData.getBirthday());

        if (userData.getDayBirthday() != null) {
            new Select(wd.findElement(By.xpath("//td[@data-handler='selectDay']")))
                    .selectByVisibleText(userData.getDayBirthday());
        }

        if (userData.getMonthBirthday() != null) {
            new Select(wd.findElement(By.xpath("//select[@data-handler='selectMonth']")))
                    .selectByVisibleText(userData.getMonthBirthday());
        }

        if (userData.getYearBirthday() != null) {
            new Select(wd.findElement(By.xpath("//select[@data-handler='selectYear']")))
                    .selectByVisibleText(userData.getYearBirthday());
        }

        if (userData.getGender() != null) {
            new Select(wd.findElement(By.xpath("//select[@data-wpt-field-title='Sex']")))
                    .selectByVisibleText(userData.getGender());
        }
    }

    public void submitUserModification() {
        click(By.name("form_submit_1"));
    }

    public void initUserModification()
    {
        click(By.xpath("//a[@class='edit-link']"));
    }

    public void initUserModifyByMenu()
    {
        click((By.xpath("//a[contains(text(),'הגדרות')]")));
    }

    public void userProfileButton()
    {
        click(By.xpath("//a[contains(text(),'הפרופיל שלי')]"));
    }

    public void userBidsButton()
    {
        click(By.xpath("//a[contains(text(),'הצעות שלי')]"));
    }

    public void userProfileExitButton()
    {
        click(By.xpath("//a[contains(text(),'התנתק')]"));
    }

    public void userProfileLogout() throws InterruptedException {
        click(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/section[1]/article[1]/div[2]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/p[1]/a[1]"));
        Thread.sleep(2000);
        //click(By.xpath("//a[contains(text(),'לצאת מהמערכת')]"));
    }




   // -----------------------------------------------


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

    public List<UserProfileData> getContactList()
    {
        List<UserProfileData> contacts = new ArrayList<>(); // create list of the contacts
        List<WebElement> rows = wd.findElements(By.tagName("tr")); // made a List web elements "rows" using
        // elements into location between tags <tr><tr/>

        for (int i = 1; i<rows.size(); i++)
        {
            WebElement row = rows.get(i); // take the object in the row according the "for" cycle
            List<WebElement> cells = row.findElements(By.tagName("td")); // put to the List "cells" all the cells of current row
                                                                        // In this row present some numbers of <td><td/>
            String LastName  = cells.get(1).getText(); // to the String put the text from cell with index [1]
                                                        //( that means that from <td> number 1 take the text  )
            String FirstName = cells.get(2).getText();

            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            // into <tr> we have some <td>, and the first <td> have tag 'input' and in the 'value' it have id number

            UserProfileData contact = new UserProfileData().setFirstname(FirstName).setLastname(LastName).setId(id);
            // create new contact using our new Strings and int id values
            contacts.add(contact); // put new contact to the List of contacts


            System.out.println("Name: " + FirstName + "   Family: " + LastName + "  id: " + id);

        }

        System.out.println(contacts);
        return contacts;
    }






}
