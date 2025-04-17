/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bd25;

/**
 *
 * @author sali276
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DIGUI extends JPanel {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DIGUI().setVisible(true);
            }
        });
    }

    private JButton displayDIGMembersButton;
    private JButton addDIGMemberButton;
    private JButton removeDIGMemberButton;
    private JTextField digMemberNameField;
    private JTextField activityNameField;
    private JTextArea digMembersTextArea;
    private static final String FILE_PATH = "src/main/resources/dig_members.txt";

    public DIGUI() {
        setLayout(new BorderLayout(10, 10));
        setBackground(new Color(240, 240, 240));

        // Create input panel
        JPanel inputPanel = createInputPanel();

        // Create button panel
        JPanel buttonPanel = createButtonPanel();

        // Create output area
        JPanel outputPanel = createOutputPanel();

        // Add components to main panel
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(outputPanel, BorderLayout.SOUTH);
    }

    private JPanel createInputPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));
        panel.setBorder(BorderFactory.createTitledBorder("DIG Member Information"));
        panel.setBackground(new Color(240, 240, 240));

        digMemberNameField = new JTextField();
        activityNameField = new JTextField();

        panel.add(createStyledLabel("DIG Member Name:"));
        panel.add(createStyledTextField(digMemberNameField));
        panel.add(createStyledLabel("Activity Name:"));
        panel.add(createStyledTextField(activityNameField));

        return panel;
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
        panel.setBackground(new Color(240, 240, 240));

        displayDIGMembersButton = createStyledButton("Display DIG Members");
        addDIGMemberButton = createStyledButton("Add DIG Member");
        removeDIGMemberButton = createStyledButton("Remove DIG Member");

        // Add action listeners
        displayDIGMembersButton.addActionListener(e -> displayDIGMembers());
        addDIGMemberButton.addActionListener(e -> {
            String digMemberName = digMemberNameField.getText();
            String activityName = activityNameField.getText();
            addDIGMember(digMemberName, activityName);
        });
        removeDIGMemberButton.addActionListener(e -> {
            String digMemberName = digMemberNameField.getText();
            removeDIGMember(digMemberName);
        });

        panel.add(displayDIGMembersButton);
        panel.add(addDIGMemberButton);
        panel.add(removeDIGMemberButton);

        return panel;
    }

    private JPanel createOutputPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("DIG Members List"));

        digMembersTextArea = new JTextArea();
        digMembersTextArea.setEditable(false);
        digMembersTextArea.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        JScrollPane scrollPane = new JScrollPane(digMembersTextArea);
        scrollPane.setPreferredSize(new Dimension(800, 300));

        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }

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
        button.setBackground(new Color(70, 130, 180)); // Steel blue
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        return button;
    }

    //Lists all DIG memers for a selected activity
    private void displayDIGMembers() {
        List<String> digMembers = readFromFile();
        StringBuilder sb = new StringBuilder();
        for (String member : digMembers) {
            sb.append(member).append("\n");
        }
        JOptionPane.showMessageDialog(this, sb.toString(), "DIG Members", JOptionPane.INFORMATION_MESSAGE);
    }

    //Faciliates adding a new DIG member to an activity
    private void addDIGMember(String digMemberName, String activityName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(digMemberName + "," + activityName + "\n");
            JOptionPane.showMessageDialog(this, "DIG Member added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error adding DIG member: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        refreshGUI();
    }

    //Enables the removal of a DIG member from an activity
    private void removeDIGMember(String digMemberName) {
        List<String> digMembers = readFromFile();
        List<String> updatedMembers = new ArrayList<>();
        for (String member : digMembers) {
            if (!member.startsWith(digMemberName + ",")) {
                updatedMembers.add(member);
            }
        }
        writeToFile(updatedMembers);
        JOptionPane.showMessageDialog(this, "DIG Member removed successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        refreshGUI();
    }

    private List<String> readFromFile() {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return lines;
    }

    private void writeToFile(List<String> lines) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (String line : lines) {
                writer.write(line + "\n");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error writing to file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        refreshGUI();
    }

    private void refreshGUI() {
        // Clear input fields
        digMemberNameField.setText("");
        activityNameField.setText("");

        // Refresh the displayed list of DIG members
        List<String> digMembers = readFromFile();
        StringBuilder sb = new StringBuilder();
        for (String member : digMembers) {
            sb.append(member).append("\n");
        }
        digMembersTextArea.setText(sb.toString());
    }

}
