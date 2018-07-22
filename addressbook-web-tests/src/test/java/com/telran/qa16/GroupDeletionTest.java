package com.telran.qa16;


import org.testng.Assert;
import org.testng.annotations.Test;


public class GroupDeletionTest extends TestBase
{

    @Test
    public void groupDeletionTest()
    {
        goToGroupsPage();

        int before = getGroupsSize();
        selectGroupCheckBox();
        initGroupDeletion();
        returnToGroupPage();
        int after = getGroupsSize();

        Assert.assertEquals(after, before-1);
    }


}

