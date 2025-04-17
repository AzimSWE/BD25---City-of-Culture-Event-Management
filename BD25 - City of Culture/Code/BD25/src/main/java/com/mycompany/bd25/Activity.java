package com.mycompany.bd25;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author zinat
 */
import java.util.List;
// Responsible for holding all the metdata for the activities
public class Activity {

    private int activityId;
    private String name;
    private String description;
    private String startDate;
    private String endDate;
    private String curator;
    private List<String> locations;
    private String audience;
    private String price;

    public void setActivityID(int name) {
        this.activityId = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setCurator(String curator) {
        this.curator = curator;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public int getActivityId() {
        return activityId;
    }

}
