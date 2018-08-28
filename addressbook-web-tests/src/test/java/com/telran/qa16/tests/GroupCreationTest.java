package com.telran.qa16.tests;

import com.telran.qa16.model.GroupData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
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
        // on this line compare the group lists before and after creation the new group (object into the list)
    }

    @Test
    public void getGroupList()
    {
        app.getGroupHelper().goToGroupsPage();

        app.getGroupHelper().getGroupsList();
    }

    @DataProvider

    public Iterator<Object[]>validGroups() throws IOException
    {
        List<Object[]>list = new ArrayList<>();

     /*   list.add(new Object[]{new GroupData().setName("aa").setLogo("aa").setComment("aa")});
        list.add(new Object[]{new GroupData().setName("jj").setLogo("jj").setComment("jj")}); */

     // using generated file group.csv , reading from file by using Buffered Reader

        BufferedReader reader = new BufferedReader(new FileReader( new File("src/test/resources/groups.csv")));

        String line = reader.readLine();

        while (line != null)
        {
            String[] split = line.split(","); // having values separated with ","
            if (split.length != 3)  // checking, if on row are just 3 values. If the condition does not hold, make a break
                break;
            // add to list Object (type GroupData). First value with index=[0], second = [1], third = [2]
            list.add(new Object[]{new GroupData().setName(split[0]).setLogo(split[1]).setComment(split[2])});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @Test(dataProvider ="validGroups")
    public void groupCreationTestWithDataProvider(GroupData group) throws InterruptedException {
        app.getGroupHelper().goToGroupsPage();

        List<GroupData>groupsListBefore = app.getGroupHelper().getGroupsList();

        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupPage();

        List<GroupData>groupsListAfter = app.getGroupHelper().getGroupsList();

        Assert.assertEquals(groupsListAfter.size(), groupsListBefore.size()+1);
    }

}
