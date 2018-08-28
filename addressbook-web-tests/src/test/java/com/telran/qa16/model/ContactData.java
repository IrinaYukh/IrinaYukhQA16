package com.telran.qa16.model;

import java.io.File;
import java.util.Objects;

public class ContactData
{
    private String firstname;
    private String lastname;
    private String address;
    private String email;
    private String phone;
    private int id;
    private File photo;
    private String group;

    public ContactData setFirstname(String firstname)
    {
        this.firstname = firstname;
        return this;
    }

    public ContactData setPhoto(File photo) {
        this.photo = photo;
        return this;
    }

    public ContactData setGroup(String group) {
        this.group = group;
        return this;
    }

    public ContactData setId(int id) {

        this.id = id;
        return this;
    }

    public ContactData setLastname(String lastname)

    {
        this.lastname = lastname;
        return this;
    }

    public ContactData setAddress (String address)
    {
        this.address = address;
        return this;
    }

    public ContactData setEmail(String email)
    {
        this.email = email;
        return this;
    }

    public ContactData setPhone(String phone)
    {
        this.phone = phone;
        return this;
    }


    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getId() {
        return id;
    }

    public File getPhoto() {
        return photo;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id &&
                Objects.equals(firstname, that.firstname) &&
                Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(firstname, lastname, id);
    }

    @Override
    public String toString() {
        return "[First name: " + firstname + ", Last name: " + lastname + ", id: " + id + " ]";
    }
}
