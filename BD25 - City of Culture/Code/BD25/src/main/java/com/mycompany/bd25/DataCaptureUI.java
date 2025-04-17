package com.mycompany.bd25;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.*;
import java.util.List;

public class DataCaptureUI extends JPanel {

    private JButton browseButton;
    private JButton searchButton;
    private JTextField filePathField;
    private JTextField eventSearchField;
    private JTextArea logTextArea;
    private JTextArea resultTextArea;
    private List<Event> events;

    public DataCaptureUI() {
        setLayout(new BorderLayout(10, 10));
        setBackground(new Color(240, 240, 240));

        // Create input panel
        JPanel inputPanel = createInputPanel();

        // Create result display area
        JPanel resultPanel = createResultPanel();

        // Add components to main panel
        add(inputPanel, BorderLayout.NORTH);
        add(resultPanel, BorderLayout.CENTER);
    }

    private JPanel createInputPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Event Search Settings"));
        panel.setBackground(new Color(240, 240, 240));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // File path
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(createStyledLabel("CSV File Path:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        filePathField = createStyledTextField(new JTextField());
        panel.add(filePathField, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 0;
        browseButton = createStyledButton("Browse");
        browseButton.setPreferredSize(new Dimension(100, 26));
        browseButton.addActionListener(e -> browseForFile());
        panel.add(browseButton, gbc);

        // Event search
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(createStyledLabel("Search Event:"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        eventSearchField = createStyledTextField(new JTextField());
        panel.add(eventSearchField, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        searchButton = createStyledButton("Search");
        searchButton.setPreferredSize(new Dimension(100, 26));
        searchButton.addActionListener(e -> searchEvent());
        panel.add(searchButton, gbc);

        return panel;
    }

    private JPanel createResultPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        // Result display area
        resultTextArea = new JTextArea(10, 50);
        resultTextArea.setEditable(false);
        resultTextArea.setFont(new Font("Consolas", Font.PLAIN, 12));
        resultTextArea.setBackground(new Color(250, 250, 250));
        JScrollPane resultScroll = new JScrollPane(resultTextArea);
        resultScroll.setBorder(BorderFactory.createTitledBorder("Event Details"));

        // Log area
        logTextArea = new JTextArea(5, 50);
        logTextArea.setEditable(false);
        logTextArea.setFont(new Font("Consolas", Font.PLAIN, 12));
        logTextArea.setBackground(new Color(250, 250, 250));
        JScrollPane logScroll = new JScrollPane(logTextArea);
        logScroll.setBorder(BorderFactory.createTitledBorder("Log"));

        panel.add(resultScroll, BorderLayout.CENTER);
        panel.add(logScroll, BorderLayout.SOUTH);
        return panel;
    }

    private void browseForFile() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            filePathField.setText(fileChooser.getSelectedFile().getAbsolutePath());
            loadEvents();
        }
    }

    private void loadEvents() {
        String filePath = filePathField.getText();
        if (filePath.isEmpty()) {
            return;
        }

        try {
            events = new ArrayList<>();
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            // Skip header
            br.readLine();

            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 7) {
                    Event event = new Event(
                            values[0].trim(),
                            Integer.parseInt(values[1].trim()),
                            Integer.parseInt(values[2].trim()),
                            Double.parseDouble(values[3].trim()),
                            Integer.parseInt(values[4].trim()),
                            Integer.parseInt(values[5].trim()),
                            Double.parseDouble(values[6].trim())
                    );
                    events.add(event);
                }
            }
            br.close();
            appendToLog("Loaded " + events.size() + " events from file");
        } catch (Exception e) {
            appendToLog("Error loading file: " + e.getMessage());
        }
    }

    private void searchEvent() {
        if (events == null || events.isEmpty()) {
            appendToLog("Please load event data first");
            return;
        }

        String searchTerm = eventSearchField.getText().trim();
        if (searchTerm.isEmpty()) {
            appendToLog("Please enter an event name to search");
            return;
        }

        boolean found = false;
        for (Event event : events) {
            if (event.name.equalsIgnoreCase(searchTerm)) {
                displayEventDetails(event);
                found = true;
                break;
            }
        }

        if (!found) {
            resultTextArea.setText("");
            appendToLog("Event not found: " + searchTerm);
        }
    }

    private void displayEventDetails(Event event) {
        String details = String.format(
                "Event Name: %s\n"
                + "Tickets Sold: %d\n"
                + "Tickets Used: %d\n"
                + "Positive Feedback: %.1f%%\n"
                + "Social Media Mentions: %d\n"
                + "Volunteers Involved: %d\n"
                + "Average Attendee Age: %.1f",
                event.name, event.ticketsSold, event.ticketsUsed,
                event.positiveFeedback, event.socialMediaMentions,
                event.volunteers, event.avgAttendeeAge);

        resultTextArea.setText(details);
        appendToLog("Displaying details for: " + event.name);
    }

    private void appendToLog(String message) {
        SwingUtilities.invokeLater(() -> {
            logTextArea.append(message + "\n");
            logTextArea.setCaretPosition(logTextArea.getDocument().getLength());
        });
    }

    // Style helpers (from original UI)
    private JLabel createStyledLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", Font.BOLD, 14));
        return label;
    }

    private JTextField createStyledTextField(JTextField field) {
        field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        field.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));
        return field;
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setBackground(new Color(70, 130, 180));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        return button;
    }

    private static class Event {

        String name;
        int ticketsSold;
        int ticketsUsed;
        double positiveFeedback;
        int socialMediaMentions;
        int volunteers;
        double avgAttendeeAge;

        public Event(String name, int ticketsSold, int ticketsUsed,
                double positiveFeedback, int socialMediaMentions,
                int volunteers, double avgAttendeeAge) {
            this.name = name;
            this.ticketsSold = ticketsSold;
            this.ticketsUsed = ticketsUsed;
            this.positiveFeedback = positiveFeedback;
            this.socialMediaMentions = socialMediaMentions;
            this.volunteers = volunteers;
            this.avgAttendeeAge = avgAttendeeAge;
        }
    }
}
