package com.mycompany.bd25;

import java.util.List;

// This is the main program that runs everything.
// It adds a new activity and then shows all current activities.
public class BD2025 {

    public static void main(String[] args) {
        ActivityDAO activityDAO;
        activityDAO = new ActivityDAO();

        // Create a new activity with some details.
        ActivityD newActivity = new ActivityD();
        newActivity.setActivityName("Bradford 2025 - City of Culture Festival");
        newActivity.setDescription("A festival celebrating local culture and community in Bradford.");
        newActivity.setLocation("Bradford, West Yorkshire");
        newActivity.setStartDate("2025-06-15");
        newActivity.setEndDate("2025-06-17");
        newActivity.setStatus("Scheduled");

        // Save the new activity into the database.
        activityDAO.insertActivity(newActivity);
        System.out.println("Activity for Bradford inserted successfully!");

        // Get and show all activities from the database.
        List<ActivityD> activities = activityDAO.fetchAllActivities();
        for (ActivityD activity : activities) {
            System.out.println("Activity Name: " + activity.getActivityName());
            System.out.println("Description: " + activity.getDescription());
            System.out.println("Location: " + activity.getLocation());
            System.out.println("Start Date: " + activity.getStartDate());
            System.out.println("End Date: " + activity.getEndDate());
            System.out.println("Status: " + activity.getStatus());
            System.out.println("-----------------------------");
        }
    }
}
