package com.example.mvvmrecyclerview;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HeroPojo {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("realname")
    @Expose
    private String realname;

    @SerializedName("team")
    @Expose
    private String team;

    @SerializedName("firstappearance")
    @Expose
    private String firstappearance;

    @SerializedName("createdby")
    @Expose
    private String createdby;

    @SerializedName("publisher")
    @Expose
    private String publisher;

    @SerializedName("imageurl")
    @Expose
    private String imageurl;

    public HeroPojo(String name, String realname, String team, String firstappearance, String createdby, String publisher, String imageurl) {
        this.name = name;
        this.realname = realname;
        this.team = team;
        this.firstappearance = firstappearance;
        this.createdby = createdby;
        this.publisher = publisher;
        this.imageurl = imageurl;
    }

    public String getName() {
        return name;
    }

    public String getRealname() {
        return realname;
    }

    public String getTeam() {
        return team;
    }

    public String getFirstappearance() {
        return firstappearance;
    }

    public String getCreatedby() {
        return createdby;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getImageurl() {
        return imageurl;
    }
}


