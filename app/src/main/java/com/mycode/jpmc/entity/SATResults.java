package com.mycode.jpmc.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SATResults {

    @SerializedName("school_name")
    private String name = "";

    @SerializedName("dbn")
    private String dbn = "";

    @SerializedName("num_of_sat_test_takers")
    private String testTakers = "";

    @SerializedName("sat_critical_reading_avg_score")
    private String avgReading = "";

    @SerializedName("sat_math_avg_score")
    private String avgMath = "";


    @SerializedName("sat_writing_avg_score")
    private String avgWriting = "";


    public String getTestTakers() {
        return testTakers;
    }

    public void setTestTakers(String testTakers) {
        this.testTakers = testTakers;
    }

    public String getAvgReading() {
        return avgReading;
    }

    public void setAvgReading(String avgReading) {
        this.avgReading = avgReading;
    }

    public String getAvgMath() {
        return avgMath;
    }

    public void setAvgMath(String avgMath) {
        this.avgMath = avgMath;
    }

    public String getAvgWriting() {
        return avgWriting;
    }

    public void setAvgWriting(String avgWriting) {
        this.avgWriting = avgWriting;
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
