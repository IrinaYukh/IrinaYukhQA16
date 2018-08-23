package com.telran.qa16.generators;

import com.telran.qa16.model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import java.util.ArrayList;
import java.util.List;

public class GroupDataGenerator
{
    public static void main( String[] args ) throws IOException {
        int count = Integer.parseInt(args[0]);
        File file = new File(args[1]);

        List<GroupData>groups = generateGroups(count);
        save(groups,file);
    }

    private static void save(List<GroupData> groups, File file) throws IOException
    {
        Writer writer = new FileWriter(file);

        for(GroupData group: groups)
        {
            writer.write(String.format("%s, %s, %s\n ", group.getName(), group.getLogo(), group.getComment()));
        }
        writer.close();
    }

    private static List<GroupData> generateGroups(int count)
    {
        List<GroupData>groups = new ArrayList<>();

        for (int i=1; i<=count; i++)
        {
            groups.add(new GroupData().setName(String.format("test %s", i))
                    .setLogo(String.format("header %s", i)).setComment(String.format("footer %s", i)));
        }
        return groups;
    }
}
