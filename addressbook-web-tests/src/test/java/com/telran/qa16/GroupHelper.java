package com.telran.qa16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupHelper extends HelperBase
{
    // constructor
    public GroupHelper(WebDriver wd)
    {
        super(wd);
    }


    // create Group

    public void initGroupCreation() {

        click(By.xpath("//*[@name='new']"));
    }

    public void submitGroupCreation() {
        click(By.xpath("//input[@value='Enter information']"));
    }

    public void returnToGroupPage() {
        click(By.xpath("//a[contains(text(),'group page')]"));
    }

    public void createGroup() {
        initGroupCreation();
        fillGroupForm(new GroupData().setName("nameFromTestBase")
                .setLogo("logoFromTestBase")
                .setComment("commentFromTestBase"));
        submitGroupCreation();
        returnToGroupPage();
    }

    // modify Group

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void selectGroupCheckBox() {
        click(By.name("selected[]"));
    }

    public void selectGroupByIndex(int index)
    {
        wd.findElements(By.name("selected[]")).get(index).click();

    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getLogo());
        type(By.name("group_footer"), groupData.getComment());
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }


    // delete Group

    public void initGroupDeletion() {
        click(By.name("delete"));
    }



    public int getGroupsSize() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public boolean isGroupPresent()
    {
        return isElementPresent(By.name("selected[]"));
    }


}
