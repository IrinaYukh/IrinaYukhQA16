package com.telran.qa16.model;

import java.util.Objects;

public class CompanyData
{
    private  String name;
    private  String phone;
    private  String positionName;
    private String companyArea;
    private String email;
    private String address;
    private int id;


    public CompanyData setCompanyArea(String companyArea) {
        this.companyArea = companyArea;
        return this;
    }

    public CompanyData setEmail(String email) {
        this.email = email;
        return this;
    }

    public CompanyData setAddress(String address) {
        this.address = address;
        return this;
    }

    public CompanyData setName(String name)
    {
        this.name = name;
        return this;

    }

    public CompanyData setPhone(String phone)
    {
        this.phone = phone;
        return this;
    }

    public CompanyData setPositionName(String positionName)
    {
        this.positionName = positionName;
        return this;
    }

    public CompanyData setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getPositionName() {
        return positionName;
    }

    public int getId() {
        return id;
    }

    public String getCompanyArea() {
        return companyArea;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyData companyData = (CompanyData) o;
        return id == companyData.id &&
                Objects.equals(name, companyData.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, id);
    }


    @Override
    public String toString() {
        return "Name: " + name + ", id: " + id + " ; ";
    }
}
