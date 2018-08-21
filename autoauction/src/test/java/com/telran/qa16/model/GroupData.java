package com.telran.qa16.model;

import java.util.Objects;

public class GroupData
{
    private  String name;
    private  String logo;
    private  String comment;
    private int id;


    public GroupData setName(String name)
    {
        this.name = name;
        return this;
    }

    public GroupData setLogo(String logo)
    {
        this.logo = logo;
        return this;
    }

    public GroupData setComment(String comment)
    {
        this.comment = comment;
        return this;
    }

    public GroupData setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getLogo() {
        return logo;
    }

    public String getComment() {
        return comment;
    }

    public int getId() {
        return id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupData groupData = (GroupData) o;
        return id == groupData.id &&
                Objects.equals(name, groupData.name);
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
