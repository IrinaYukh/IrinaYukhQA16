package com.telran.qa16.tests;

import com.telran.qa16.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;


public class GroupModificationTest extends TestBase
{

    @Test
    public void groupModificationTest() throws InterruptedException {
        app.getGroupHelper().goToGroupsPage();

        if (!app.getGroupHelper().isGroupPresent())
        {
            app.getGroupHelper().createGroup();
        }
        int before = app.getGroupHelper().getGroupsSize();
        app.getGroupHelper().selectGroupCheckBox();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData().setName("modifyedName").setLogo("modifyedLogo").setComment("modifyedComment"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupsSize();

        Assert.assertEquals(after, before);
    }

    @Test()
    public void groupModificationTestByIndex1() throws InterruptedException {
        // select and modify last element in the table

        app.getGroupHelper().goToGroupsPage();

        if (!app.getGroupHelper().isGroupPresent())
        {
            app.getGroupHelper().createGroup();
        }

        int before = app.getGroupHelper().getGroupsSize();

        // take the last element (size of table - value of int before)
        app.getGroupHelper().selectGroupByIndex(before-1);
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData().setName("modifyedName2").setLogo("modifyedLogo2").setComment("modifyedComment2"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupsSize();

        Assert.assertEquals(after, before);
    }

    @Test
    public void groupModificationTestList() throws InterruptedException {
        app.getGroupHelper().goToGroupsPage();

        if (!app.getGroupHelper().isGroupPresent())
        {
            app.getGroupHelper().createGroup();
        }

        List<GroupData> groupsListBefore = app.getGroupHelper().getGroupsList();

        app.getGroupHelper().selectGroupCheckBox();
        app.getGroupHelper().initGroupModification();

        GroupData group = new GroupData().setId(groupsListBefore.get(0).getId())
                .setName("F").setLogo("F").setComment("F");

        app.getGroupHelper().fillGroupForm(group);

        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();

        List<GroupData>groupsListAfter = app.getGroupHelper().getGroupsList();
        groupsListBefore.remove(0);
        groupsListBefore.add(group);

        Assert.assertEquals(groupsListAfter.size(), groupsListBefore.size());
        Assert.assertEquals(new HashSet<Object>(groupsListAfter), new HashSet<Object>(groupsListBefore));
    }




}
