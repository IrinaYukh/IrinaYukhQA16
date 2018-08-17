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

    public void returnToGroupPage() throws InterruptedException {
        click(By.xpath("//a[contains(text(),'group page')]"));
        Thread.sleep(2000);
    }

    public void createGroup() throws InterruptedException {
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
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            GroupData group = new GroupData().setId(id).setName(name);
            groups.add(group);
        }
        System.out.println(groups);
        return groups;
    }
}
