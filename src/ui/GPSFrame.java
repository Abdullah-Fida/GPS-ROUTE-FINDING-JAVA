package ui;

import models.Location;
import service.GPSservice;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GPSFrame extends JFrame {

    private GPSservice gps;

    private JComboBox<String> startCityBox;
    private JComboBox<String> destinationCityBox;

    private JButton findRouteButton;

    private JTextArea resultArea;

    private Map<String, Location> cityMap;

    public GPSFrame() {

        initializeBackend();

        initializeUI();

        setVisible(true);
    }

    private void initializeBackend() {

        gps = new GPSservice();

        cityMap = new HashMap<>();

        // Cities
        Location lahore = new Location(1, "Lahore");
        Location multan = new Location(2, "Multan");
        Location islamabad = new Location(3, "Islamabad");
        Location karachi = new Location(4, "Karachi");

        // Add locations
        gps.addLocation(lahore);
        gps.addLocation(multan);
        gps.addLocation(islamabad);
        gps.addLocation(karachi);

        // Add roads
        gps.addRoad(lahore, multan, 350);
        gps.addRoad(lahore, islamabad, 280);
        gps.addRoad(multan, karachi, 900);
        gps.addRoad(islamabad, karachi, 1200);

        // Store in HashMap
        cityMap.put("Lahore", lahore);
        cityMap.put("Multan", multan);
        cityMap.put("Islamabad", islamabad);
        cityMap.put("Karachi", karachi);
    }

    private void initializeUI() {

        setTitle("GPS Navigation System");

        setSize(600, 450);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        // ==========================
        // TOP PANEL
        // ==========================

        JPanel topPanel = new JPanel();

        topPanel.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel startLabel =
                new JLabel("Select Start City:");

        JLabel destinationLabel =
                new JLabel("Select Destination City:");

        startCityBox =
                new JComboBox<>(cityMap.keySet().toArray(new String[0]));

        destinationCityBox =
                new JComboBox<>(cityMap.keySet().toArray(new String[0]));

        findRouteButton =
                new JButton("Find Shortest Route");

        topPanel.add(startLabel);
        topPanel.add(startCityBox);

        topPanel.add(destinationLabel);
        topPanel.add(destinationCityBox);

        topPanel.add(new JLabel());
        topPanel.add(findRouteButton);

        // ==========================
        // RESULT AREA
        // ==========================

        resultArea = new JTextArea();

        resultArea.setEditable(false);

        resultArea.setFont(
                new Font("Arial",
                        Font.PLAIN,
                        16));

        JScrollPane scrollPane =
                new JScrollPane(resultArea);

        // ==========================
        // ADD COMPONENTS
        // ==========================

        add(topPanel, BorderLayout.NORTH);

        add(scrollPane, BorderLayout.CENTER);

        // ==========================
        // BUTTON EVENT
        // ==========================

        findRouteButton.addActionListener(e -> {

            String startName =
                    (String) startCityBox.getSelectedItem();

            String endName =
                    (String) destinationCityBox.getSelectedItem();

            Location start =
                    cityMap.get(startName);

            Location end =
                    cityMap.get(endName);

            List<Location> route =
                    gps.findRoute(start, end);

            if (route.isEmpty()) {

                resultArea.setText(
                        "No Route Found!");
                return;
            }

            StringBuilder output =
                    new StringBuilder();

            output.append("===== SHORTEST ROUTE =====\n\n");

            for (int i = 0; i < route.size(); i++) {

                output.append(
                        route.get(i).getLocationName());

                if (i < route.size() - 1) {

                    output.append(" -> ");
                }
            }

            output.append("\n\n");

            output.append("Total Distance: ");

            output.append(
                    gps.getDistance(end));

            output.append(" km");

            resultArea.setText(
                    output.toString());
        });
    }
}