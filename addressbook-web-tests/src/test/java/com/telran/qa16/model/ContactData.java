package com.telran.qa16.model;

public class ContactData
{
    private String firstname;
    private String lastname;
    private String address;
    private String email;
    private String phone;

    public ContactData setFirstname(String firstname)
    {
        this.firstname = firstname;
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
}
