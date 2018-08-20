package com.telran.qa16.tests;

import com.telran.qa16.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;


public class GroupCreationTest extends TestBase
{

    @Test
    public void groupCreationTest() throws InterruptedException {
        app.getGroupHelper().goToGroupsPage();

        int before = app.getGroupHelper().getGroupsSize();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData().setName("name").setLogo("logo").setComment("comment"));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupsSize();

        Assert.assertEquals(after, before + 1);

    }

    @Test
    public void groupCreationTestWithoutName() throws InterruptedException {
        app.getGroupHelper().goToGroupsPage();

        int before = app.getGroupHelper().getGroupsSize();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData().setName("").setLogo("").setComment(""));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupsSize();

        Assert.assertEquals(after, before+1);

    }

    @Test
    public void groupCreationTestWithLongName() throws InterruptedException {
        app.getGroupHelper().goToGroupsPage();

        int before = app.getGroupHelper().getGroupsSize();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData().setName("nameJJJJOOOOHHHHNNNN").setLogo("logo").setComment("comment25615"));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupsSize();

        Assert.assertEquals(after, before+1);

    }

    @Test
    public void groupCreationTestList() throws InterruptedException {
        app.getGroupHelper().goToGroupsPage();

        List<GroupData>groupsListBefore = app.getGroupHelper().getGroupsList();

        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData().setName("name").setLogo("logo").setComment("comment"));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupPage();

        List<GroupData>groupsListAfter = app.getGroupHelper().getGroupsList();

        Assert.assertEquals(groupsListAfter.size(), groupsListBefore.size()+1);
    }

    @Test
    public void groupCreationTestList2() throws InterruptedException {
        app.getGroupHelper().goToGroupsPage();

        List<GroupData>groupsListBefore = app.getGroupHelper().getGroupsList();

        app.getGroupHelper().initGroupCreation();

        GroupData group = new GroupData().setName("listNameG").setLogo("listLogoG").setComment("listCommentG");
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupPage();

        List<GroupData>groupsListAfter = app.getGroupHelper().getGroupsList();

        Assert.assertEquals(groupsListAfter.size(), groupsListBefore.size()+1);

        groupsListBefore.add(group);
        int max = 0;
        for (GroupData gr : groupsListAfter)
        {
            if (gr.getId()>max)
            {
                max = gr.getId();
            }
            group.setId(max);
        }
        Assert.assertEquals(new HashSet<Object>(groupsListAfter), new HashSet<Object>(groupsListBefore));
    }

    @Test
    public void getGroupList()
    {
        app.getGroupHelper().goToGroupsPage();

        app.getGroupHelper().getGroupsList();
    }

}
