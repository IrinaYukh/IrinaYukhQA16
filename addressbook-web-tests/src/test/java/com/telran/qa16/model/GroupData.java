package com.telran.qa16.model;

public class GroupData
{
    private  String name;
    private  String logo;
    private  String comment;


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


    public String getName() {
        return name;
    }

    public String getLogo() {
        return logo;
    }

    public String getComment() {
        return comment;
    }
}
