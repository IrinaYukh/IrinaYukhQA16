package com.telran.qa16.tests;


import com.telran.qa16.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class GroupDeletionTest extends TestBase
{

    @Test
    public void groupDeletionTest() throws InterruptedException {
        app.getGroupHelper().goToGroupsPage();
        if (!app.getGroupHelper().isGroupPresent())
        {
            app.getGroupHelper().createGroup();
        }
        int before = app.getGroupHelper().getGroupsSize();
        app.getGroupHelper().selectGroupCheckBox();
        app.getGroupHelper().initGroupDeletion();
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupsSize();

        Assert.assertEquals(after, before-1);
    }

    @Test
    public void groupDeletionTestByIndex() throws InterruptedException {
        app.getGroupHelper().goToGroupsPage();

        if (!app.getGroupHelper().isGroupPresent())
        {
            app.getGroupHelper().createGroup();
        }

        int before = app.getGroupHelper().getGroupsSize();

        // select last element of table for deletion
        app.getGroupHelper().selectGroupByIndex(before-1);
        app.getGroupHelper().initGroupDeletion();
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupsSize();

        Assert.assertEquals(after, before-1);
    }

    @Test
    public void groupDeletionTestByIndexWithList() throws InterruptedException {
        app.getGroupHelper().goToGroupsPage();

        if (!app.getGroupHelper().isGroupPresent())
        {
            app.getGroupHelper().createGroup();
        }

        List<GroupData> groupsListBefore = app.getGroupHelper().getGroupsList();

        app.getGroupHelper().selectGroupByIndex(groupsListBefore.size()-1);
        app.getGroupHelper().initGroupDeletion();
        app.getGroupHelper().returnToGroupPage();

        List<GroupData>groupsListAfter = app.getGroupHelper().getGroupsList();

        groupsListBefore.remove(groupsListBefore.size()-1);

        Assert.assertEquals(groupsListAfter.size(), groupsListBefore.size());
        Assert.assertEquals(groupsListAfter, groupsListBefore);
    }

    @Test
    public void groupDeletionTestList() throws InterruptedException {
        app.getGroupHelper().goToGroupsPage();

        if (!app.getGroupHelper().isGroupPresent())
        {
            app.getGroupHelper().createGroup();
        }

        List<GroupData> groupsListBefore = app.getGroupHelper().getGroupsList();

        app.getGroupHelper().selectGroupCheckBox();
        app.getGroupHelper().initGroupDeletion();
        app.getGroupHelper().returnToGroupPage();

        List<GroupData>groupsListAfter = app.getGroupHelper().getGroupsList();

        groupsListBefore.remove(0);

        Assert.assertEquals(groupsListAfter.size(), groupsListBefore.size());
        Assert.assertEquals(groupsListAfter, groupsListBefore);
    }



}

