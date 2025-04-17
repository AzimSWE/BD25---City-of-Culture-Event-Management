package com.mycompany.bd25;

import javax.swing.*;
import java.awt.*;

public class ClientApp extends JFrame {

    private final JPanel contentPane = new JPanel(new BorderLayout());

    // Panels for each section
    private final ClientActivityUI clientactivityUI = new ClientActivityUI();

    public ClientApp() {
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
        addSidebarButton(sidebar, "Activities", () -> switchView(clientactivityUI));
        addSidebarButton(sidebar, "Exit", this::exitApplication);

        // Add spacing after buttons
        sidebar.add(Box.createVerticalGlue());

        // Add logo at the bottom
        try {
            ImageIcon logoIcon = new ImageIcon("src/main/resources/bd25logo2.jpg");
            Image scaledLogo = logoIcon.getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH);
            JLabel logoLabel = new JLabel(new ImageIcon(scaledLogo));
            logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            sidebar.add(logoLabel);
            sidebar.add(Box.createRigidArea(new Dimension(0, 20)));
        } catch (Exception e) {
            System.err.println("Failed to load logo: " + e.getMessage());
        }

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
        SwingUtilities.invokeLater(() -> new ClientApp().setVisible(true));
    }
}
