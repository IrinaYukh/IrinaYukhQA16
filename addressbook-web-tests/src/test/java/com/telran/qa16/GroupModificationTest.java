package com.telran.qa16;

import org.testng.Assert;
import org.testng.annotations.Test;


public class GroupModificationTest extends TestBase
{

    @Test
    public void groupModificationTest()
    {
        app.goToGroupsPage();

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
    public void groupModificationTestByIndex1()
    {
        // select and modify last element in the table

        app.goToGroupsPage();

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




}
