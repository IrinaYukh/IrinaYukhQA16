package com.telran.qa16;

import org.testng.annotations.*;


public class GroupCreationTest extends TestBase
{

    @Test
    public void groupCreationTest()
    {
        goToGroupsPage();
        initGroupCreation();
        fillGroupForm(new GroupData().setName("name").setLogo("logo").setComment("comment"));
        submitGroupCreation();
        returnToGroupPage();

    }

    @Test
    public void groupCreationTestWithoutName()
    {
        goToGroupsPage();
        initGroupCreation();
        fillGroupForm(new GroupData().setName("").setLogo("").setComment(""));
        submitGroupCreation();
        returnToGroupPage();

    }

    @Test
    public void groupCreationTestWithLongName()
    {
        goToGroupsPage();
        initGroupCreation();
        fillGroupForm(new GroupData().setName("nameJJJJOOOOHHHHNNNN").setLogo("logo").setComment("comment25615"));
        submitGroupCreation();
        returnToGroupPage();

    }


}
