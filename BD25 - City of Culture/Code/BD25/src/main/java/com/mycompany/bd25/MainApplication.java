package com.mycompany.bd25;

import javax.swing.*;
import java.awt.*;

public class MainApplication extends JFrame {

    private final JPanel contentPane = new JPanel(new BorderLayout());

    // Panels for each section
    private final ActivityUI activityUI = new ActivityUI();
    private final DIGUI digUI = new DIGUI();
    private final DataCaptureUI dataCaptureUI = new DataCaptureUI();

    public MainApplication() {
        setTitle("BD25 Management System");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Initial welcome screen
        contentPane.add(new JLabel("Welcome! Select an option from the sidebar.", SwingConstants.CENTER), BorderLayout.CENTER);

        // Layout setup
        add(createSidebar(), BorderLayout.WEST);
        add(contentPane, BorderLayout.CENTER);
    }

    private JPanel createSidebar() {
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBackground(new Color(60, 60, 60));
        sidebar.setPreferredSize(new Dimension(200, 700));

        // Add buttons
        addSidebarButton(sidebar, "Activities", () -> switchView(activityUI));
        addSidebarButton(sidebar, "DIG Members", () -> switchView(digUI));
        addSidebarButton(sidebar, "Data Capture", () -> switchView(dataCaptureUI));
        addSidebarButton(sidebar, "Exit", this::exitApplication);

        return sidebar;
    }

    private void addSidebarButton(JPanel sidebar, String text, Runnable action) {
        JButton button = new JButton(text);
        button.setMaximumSize(new Dimension(180, 40));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setBackground(new Color(80, 80, 80));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.addActionListener(e -> action.run());

        sidebar.add(Box.createRigidArea(new Dimension(0, 15)));
        sidebar.add(button);
    }

    private void switchView(JPanel panel) {
        contentPane.removeAll();
        contentPane.add(panel, BorderLayout.CENTER);
        contentPane.revalidate();
        contentPane.repaint();
    }

    private void exitApplication() {
        System.exit(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainApplication().setVisible(true));
    }
}
