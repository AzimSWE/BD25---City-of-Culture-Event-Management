package com.mycompany.bd25;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActivityUI extends JPanel {

    private final DefaultListModel<String> listModel = new DefaultListModel<>();
    private final JList<String> activityList = new JList<>(listModel);

    public ActivityUI() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Title
        add(createTitleLabel("Available Activities:"), BorderLayout.NORTH);

        // List with scroll
        activityList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(activityList), BorderLayout.CENTER);

        // Buttons
        add(createButtonPanel(), BorderLayout.SOUTH);

        // Load from database
        displayDatabaseActivities();
    }

    private JLabel createTitleLabel(String text) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(label.getFont().deriveFont(Font.BOLD, 14f));
        return label;
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        Dimension btnSize = new Dimension(150, 30);

        JButton addBtn = new JButton("Add Activity");
        addBtn.setPreferredSize(btnSize);
        addBtn.addActionListener(this::addActivity);

        JButton removeBtn = new JButton("Remove Activity");
        removeBtn.setPreferredSize(btnSize);
        removeBtn.addActionListener(this::removeActivity);

        panel.add(addBtn);
        panel.add(removeBtn);
        return panel;
    }

    private void displayDatabaseActivities() {
        listModel.clear();

        List<String> activities = fetchActivitiesFromDatabase();
        for (String activity : activities) {
            listModel.addElement(activity);
        }

        if (activities.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "No activities found in the database.",
                    "Information",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private List<String> fetchActivitiesFromDatabase() {
        List<String> activities = new ArrayList<>();
        String query = "SELECT * FROM `bd25events2.0`"; // Adjust table/column names if needed

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                activities.add(rs.getString("id"));
                activities.add(rs.getString("name"));
                activities.add(rs.getString("date"));
                activities.add(rs.getString("pricings"));
                activities.add(rs.getString("website link"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Failed to load activities from database.\n" + e.getMessage(),
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE);
        }

        return activities;
    }

    private void addActivity(ActionEvent e) {
        String input = JOptionPane.showInputDialog(
                this,
                "Enter activity details separated by commas:\n"
                + "Format: name,date,organiser,location,target audience,pricings,description,website link,image link",
                "Add Activity",
                JOptionPane.PLAIN_MESSAGE
        );

        if (input != null && !input.trim().isEmpty()) {
            String[] values = input.split(",", -1); // Include trailing empty strings

            if (values.length != 9) {
                JOptionPane.showMessageDialog(this,
                        "Invalid input. Please enter 9 comma-separated values.",
                        "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Trim each value to remove extra whitespace
            for (int i = 0; i < values.length; i++) {
                values[i] = values[i].trim();
            }

            try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO `bd25events2.0` "
                    + "(`name`, `date`, `organiser`, `location`, `target audience`, `pricings`, `description`, `website link`, `image link`) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)")) {

                for (int i = 0; i < values.length; i++) {
                    stmt.setString(i + 1, values[i]);
                }

                stmt.executeUpdate();

                // Refresh the list from DB
                displayDatabaseActivities();;

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this,
                        "Failed to add activity.\nError: " + ex.getMessage(),
                        "Database Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace(); // Log the full error for debugging
            }
        }
    }

    private void removeActivity(ActionEvent e) {
        int index = activityList.getSelectedIndex();
        if (index != -1) {
            String selectedActivity = listModel.get(index);

            try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement("DELETE FROM `bd25events2.0` WHERE id = ?")) {

                stmt.setString(1, selectedActivity);
                int rowsDeleted = stmt.executeUpdate();

                if (rowsDeleted > 0) {
                    displayDatabaseActivities(); // Refresh from DB
                    JOptionPane.showMessageDialog(this, "Removed: " + selectedActivity,
                            "Activity Removed", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Could not find activity in database.",
                            "Not Found", JOptionPane.WARNING_MESSAGE);
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Failed to remove activity.\n" + ex.getMessage(),
                        "Database Error", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(this, "Select an activity to remove first.",
                    "No Selection", JOptionPane.WARNING_MESSAGE);
        }
    }

    public DefaultListModel<String> getActivityListModel() {
        return listModel;
    }
}
