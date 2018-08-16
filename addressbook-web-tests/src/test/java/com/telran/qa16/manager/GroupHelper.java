package com.telran.qa16.manager;

import com.telran.qa16.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class GroupHelper extends HelperBase
{
    // constructor
    public GroupHelper(WebDriver wd)
    {
        super(wd);
    }


    // create Group

    public void goToGroupsPage() {
       if (!isElementPresent(By.xpath("//h1[contains(text(),'GROUPS')]"))&& !isElementPresent(By.name("new")))
       {
           wd.findElement(By.xpath("//*[@href='group.php']")).click();
       }
    }


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

    public void fillGroupForm(GroupData group) {
        type(By.name("group_name"), group.getName());
        type(By.name("group_header"), group.getLogo());
        type(By.name("group_footer"), group.getComment());
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


    public List<GroupData> getGroupsList()
    {
        List<GroupData> groups = new ArrayList<>();

        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element: elements)
        {
            String name = element.getText();
            GroupData group = new GroupData().setName(name);
            groups.add(group);

        }
        System.out.println(groups);
        return groups;
    }
}
