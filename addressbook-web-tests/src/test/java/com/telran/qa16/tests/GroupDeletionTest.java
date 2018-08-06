package com.telran.qa16.tests;


import org.testng.Assert;
import org.testng.annotations.Test;


public class GroupDeletionTest extends TestBase
{

    @Test
    public void groupDeletionTest()
    {
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
    public void groupDeletionTestByIndex()
    {
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




}

