package com.mycompany.bd25;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.mycompany.bd25.Activity;
import java.util.ArrayList;
import java.util.List;

public class ActivityManager {

    private List<Activity> activities;

    public ActivityManager() {
        this.activities = new ArrayList<>();
    }

    // Create an activity
    public void createActivity(Activity activity) {
        if (isValidActivity(activity)) {
            activities.add(activity);
            System.out.println("Activity added: " + activity);
        } else {
            System.out.println("Invalid activity data.");
        }
    }

    // Get activities
    public List<Activity> getAllActivities() {
        return new ArrayList<>(activities);
    }

    public Activity getActivityById(int activityId) {
        for (Activity activity : activities) {
            if (activity.getActivityId() == activityId) {
                return activity;
            }
        }
        return null;
    }

    // UPDATE (partial fields)
    public boolean updateActivity(int activityId, String name, String description, String startDate,
            String endDate, String curator, List<String> locations, String audience, String price) {
        Activity activity = getActivityById(activityId);
        if (activity == null) {
            System.out.println("Activity not found.");
            return false;
        }

        if (name != null) {
            activity.setName(name);
        }
        if (description != null) {
            activity.setDescription(description);
        }
        if (startDate != null) {
            activity.setStartDate(startDate);
        }
        if (endDate != null) {
            activity.setEndDate(endDate);
        }
        if (curator != null) {
            activity.setCurator(curator);
        }
        if (locations != null) {
            activity.setLocations(locations);
        }
        if (audience != null) {
            activity.setAudience(audience);
        }
        if (price != null) {
            activity.setPrice(price);
        }

        System.out.println("Activity updated: " + activity);
        return true;
    }

    // DELETE
    public void deleteActivity(int activityId) {
        boolean removed = activities.removeIf(activity -> activity.getActivityId() == activityId);
        if (removed) {
            System.out.println("Activity with ID " + activityId + " has been deleted.");
        } else {
            System.out.println("Activity with ID " + activityId + " not found.");
        }
    }

    private boolean isValidActivity(Activity activity) {
        return activity != null
                && activity.getName() != null && !activity.getName().isEmpty()
                && activity.getStartDate() != null && activity.getEndDate() != null;
    }
}
