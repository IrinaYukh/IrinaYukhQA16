package com.telran.qa16;

import org.testng.Assert;
import org.testng.annotations.Test;


public class GroupModificationTest extends TestBase
{

    @Test
    public void groupModificationTest()
    {
        goToGroupsPage();

        int before = getGroupsSize();
        selectGroupCheckBox();
        initGroupModification();
        fillGroupForm(new GroupData().setName("modifyedName").setLogo("modifyedLogo").setComment("modifyedComment"));
        submitGroupModification();
        returnToGroupPage();
        int after = getGroupsSize();

        Assert.assertEquals(after, before);
    }


}
