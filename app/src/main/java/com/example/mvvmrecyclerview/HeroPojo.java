package com.example.mvvmrecyclerview;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HeroPojo {

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("realname")
    @Expose
    public String realname;

    @SerializedName("team")
    @Expose
    public String team;

    @SerializedName("firstappearance")
    @Expose
    public String firstappearance;

    @SerializedName("createdby")
    @Expose
    public String createdby;

    @SerializedName("publisher")
    @Expose
    public String publisher;

    @SerializedName("imageurl")
    @Expose
    public String imageurl;

    public HeroPojo(String name, String realname, String team, String firstappearance, String createdby, String publisher, String imageurl) {
        this.name = name;
        this.realname = realname;
        this.team = team;
        this.firstappearance = firstappearance;
        this.createdby = createdby;
        this.publisher = publisher;
        this.imageurl = imageurl;
    }


}


