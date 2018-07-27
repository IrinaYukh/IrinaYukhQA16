package com.telran.qa16;

import org.testng.Assert;
import org.testng.annotations.Test;


public class GroupCreationTest extends TestBase
{

    @Test
    public void groupCreationTest()
    {
        goToGroupsPage();

        int before = getGroupsSize();
        initGroupCreation();
        fillGroupForm(new GroupData().setName("name").setLogo("logo").setComment("comment"));
        submitGroupCreation();
        returnToGroupPage();
        int after = getGroupsSize();

        Assert.assertEquals(after, before + 1);

    }

    @Test
    public void groupCreationTestWithoutName()
    {
        goToGroupsPage();

        int before = getGroupsSize();
        initGroupCreation();
        fillGroupForm(new GroupData().setName("").setLogo("").setComment(""));
        submitGroupCreation();
        returnToGroupPage();
        int after = getGroupsSize();

        Assert.assertEquals(after, before+1);

    }

    @Test
    public void groupCreationTestWithLongName()
    {
        goToGroupsPage();

        int before = getGroupsSize();
        initGroupCreation();
        fillGroupForm(new GroupData().setName("nameJJJJOOOOHHHHNNNN").setLogo("logo").setComment("comment25615"));
        submitGroupCreation();
        returnToGroupPage();
        int after = getGroupsSize();

        Assert.assertEquals(after, before+1);

    }


}
