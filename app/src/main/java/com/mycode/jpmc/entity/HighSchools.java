package com.mycode.jpmc.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HighSchools {

    @SerializedName("school_name")
    private String name = "";

    @SerializedName("dbn")
    private String dbn = "";

    public HighSchools(String name, String dbn) {
        this.name = name;
        this.dbn = dbn;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setDbn(String dbn){
        this.dbn = dbn;
    }

    public String getDbn(){
        return dbn;
    }
}
