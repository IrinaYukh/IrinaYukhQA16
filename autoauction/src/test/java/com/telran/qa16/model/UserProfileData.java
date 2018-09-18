package com.telran.qa16.model;

import java.io.File;
import java.util.Objects;

public class UserProfileData
{
    private String firstname;
    private String lastname;
    private String address;
    private String email;
    private String phone;
    private int id;
    private File photo;
    private String gender;
    private String dayBirthday;
    private String monthBirthday;
    private String yearBirthday;
    private String birthday;


    public UserProfileData setDayBirthday(String dayBirthday) {
        this.dayBirthday = dayBirthday;
        return this;
    }

    public UserProfileData setMonthBirthday(String monthBirthday) {
        this.monthBirthday = monthBirthday;
        return this;
    }

    public UserProfileData setYearBirthday(String yearBirthday) {
        this.yearBirthday = yearBirthday;
        return this;
    }

    public UserProfileData setFirstname(String firstname)
    {
        this.firstname = firstname;
        return this;

    }

    public UserProfileData setPhoto(File photo) {
        this.photo = photo;
        return this;
    }

    public UserProfileData setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public UserProfileData setId(int id) {

        this.id = id;
        return this;
    }

    public UserProfileData setLastname(String lastname)

    {
        this.lastname = lastname;
        return this;
    }

    public UserProfileData setAddress (String address)
    {
        this.address = address;
        return this;
    }

    public UserProfileData setEmail(String email)
    {
        this.email = email;
        return this;
    }

    public UserProfileData setPhone(String phone)
    {
        this.phone = phone;
        return this;
    }

    public UserProfileData setBirthday(String birthday) {
        this.birthday = birthday;
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

    public String getGender() {
        return gender;
    }

    public String getDayBirthday()
    {
        return dayBirthday;
    }

    public String getMonthBirthday()
    {
        return monthBirthday;
    }

    public String getYearBirthday()
    {
        return yearBirthday;
    }

    public String getBirthday() {
        return birthday;
    }




    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProfileData that = (UserProfileData) o;
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
