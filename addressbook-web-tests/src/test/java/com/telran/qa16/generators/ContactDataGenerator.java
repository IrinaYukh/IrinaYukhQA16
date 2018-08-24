package com.telran.qa16.generators;

import com.telran.qa16.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator
{
    public static void main (String [] args) throws IOException {
        int count = Integer.parseInt(args[0]);
        File file = new File (args[1]);

        List<ContactData> contacts = GenerateContacts (count);
        save(contacts,file);
    }

    private static void save(List<ContactData> contacts, File file) throws IOException
    {
        Writer writer = new FileWriter(file);

        for(ContactData contact: contacts)
        {
            writer.write(String.format("%s, %s, %s\n ", contact.getFirstname(), contact.getLastname(), contact.getAddress()));
        }
        writer.close();
    }

    private static List<ContactData> GenerateContacts(int count)
    {
        List<ContactData> contacts = new ArrayList<>();

        for(int i = 1; i<=count; i++)
        {
            contacts.add(new ContactData().setFirstname(String.format("First name %s", i))
                    .setLastname(String.format("Last name %s", i)).setAddress(String.format("Address %s", i)));
        }
        return contacts;
    }
}
