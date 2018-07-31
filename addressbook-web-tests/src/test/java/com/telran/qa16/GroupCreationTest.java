package com.telran.qa16;

import org.testng.Assert;
import org.testng.annotations.Test;


public class GroupCreationTest extends TestBase
{

    @Test
    public void groupCreationTest()
    {
        app.goToGroupsPage();

        int before = app.getGroupHelper().getGroupsSize();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData().setName("name").setLogo("logo").setComment("comment"));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupsSize();

        Assert.assertEquals(after, before + 1);

    }

    @Test
    public void groupCreationTestWithoutName()
    {
        app.goToGroupsPage();

        int before = app.getGroupHelper().getGroupsSize();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData().setName("").setLogo("").setComment(""));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupsSize();

        Assert.assertEquals(after, before+1);

    }

    @Test
    public void groupCreationTestWithLongName()
    {
        app.goToGroupsPage();

        int before = app.getGroupHelper().getGroupsSize();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData().setName("nameJJJJOOOOHHHHNNNN").setLogo("logo").setComment("comment25615"));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupsSize();

        Assert.assertEquals(after, before+1);

    }


}
