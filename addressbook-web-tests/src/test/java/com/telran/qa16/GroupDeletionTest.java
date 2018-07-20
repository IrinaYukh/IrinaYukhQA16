package com.telran.qa16;


import org.testng.annotations.Test;


public class GroupDeletionTest extends TestBase
{

    @Test
    public void groupDeletionTest()
    {
        goToGroupsPage();
        selectGroupCheckBox();
        initGroupDeletion();
        returnToGroupPage();
    }


}

