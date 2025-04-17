package com.mycompany.bd25;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientActivityUI extends JPanel {

    private final DefaultListModel<String> listModel = new DefaultListModel<>();
    private final JList<String> activityList = new JList<>(listModel);

    public ClientActivityUI() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Title
        add(createTitleLabel("Available Activities:"), BorderLayout.NORTH);

        // List with scroll
        activityList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(activityList), BorderLayout.CENTER);

        // Load from database
        displayDatabaseActivities();
    }

    private JLabel createTitleLabel(String text) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(label.getFont().deriveFont(Font.BOLD, 14f));
        return label;
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

    public DefaultListModel<String> getActivityListModel() {
        return listModel;
    }
}
