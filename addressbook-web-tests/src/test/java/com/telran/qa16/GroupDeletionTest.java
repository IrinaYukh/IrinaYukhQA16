package com.telran.qa16;


import org.testng.Assert;
import org.testng.annotations.Test;


public class GroupDeletionTest extends TestBase
{

    @Test
    public void groupDeletionTest()
    {
        goToGroupsPage();
        if (!isGroupPresent())
        {
            createGroup();
        }
        int before = getGroupsSize();
        selectGroupCheckBox();
        initGroupDeletion();
        returnToGroupPage();
        int after = getGroupsSize();

        Assert.assertEquals(after, before-1);
    }

    @Test
    public void groupDeletionTestByIndex()
    {
        goToGroupsPage();
        if (!isGroupPresent())
        {
            createGroup();
        }
        int before = getGroupsSize();
        // select last element of table for deletion
        selectGroupByIndex(before-1);
        initGroupDeletion();
        returnToGroupPage();
        int after = getGroupsSize();

        Assert.assertEquals(after, before-1);
    }




}

