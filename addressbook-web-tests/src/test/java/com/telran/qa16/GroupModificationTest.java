package com.telran.qa16;

import org.testng.Assert;
import org.testng.annotations.Test;


public class GroupModificationTest extends TestBase
{

    @Test
    public void groupModificationTest()
    {
        goToGroupsPage();

        if (!isGroupPresent())
        {
            createGroup();
        }

        int before = getGroupsSize();
        selectGroupCheckBox();
        initGroupModification();
        fillGroupForm(new GroupData().setName("modifyedName").setLogo("modifyedLogo").setComment("modifyedComment"));
        submitGroupModification();
        returnToGroupPage();
        int after = getGroupsSize();

        Assert.assertEquals(after, before);
    }

    @Test()
    public void groupModificationTestByIndex1()
    {
        // select and modify last element in the table

        goToGroupsPage();

        if (!isGroupPresent())
        {
            createGroup();
        }

        int before = getGroupsSize();

        // take the last element (size of table - value of int before)
        selectGroupByIndex(before-1);
        initGroupModification();
        fillGroupForm(new GroupData().setName("modifyedName2").setLogo("modifyedLogo2").setComment("modifyedComment2"));
        submitGroupModification();
        returnToGroupPage();
        int after = getGroupsSize();

        Assert.assertEquals(after, before);
    }




}
