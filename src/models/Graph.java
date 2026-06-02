package models;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class Graph {

    private Map<Location, List<Road>> adjacencyList;

    // Constructor
    public Graph() {
        adjacencyList = new HashMap<>();
    }

    // Add a location (city)
    public void addLocation(Location location) {
        adjacencyList.put(location, new ArrayList<>());
    }

    // Add a road from source to destination
    public void addRoad(Location source, Location destination, double distance) {

        Road road = new Road(destination, distance);

        adjacencyList.get(source).add(road);
    }

    // Get all roads connected to a location
    public List<Road> getNeighbors(Location location) {
        return adjacencyList.get(location);
    }

    // Get all locations in the graph
    public List<Location> getLocations() {
        return new ArrayList<>(adjacencyList.keySet());
    }

    // Print graph for testing
    public void printGraph() {

        for (Location location : adjacencyList.keySet()) {

            System.out.println(location + " -> ");

            List<Road> roads = adjacencyList.get(location);

            for (Road road : roads) {
                System.out.println("    " + road);
            }
        }
    }
}
 class Main {

    public static void main(String[] args) {

        Graph graph = new Graph();

        Location lahore = new Location(1, "Lahore");
        Location islamabad = new Location(2, "Islamabad");
        Location multan = new Location(3, "Multan");
        Location karachi = new Location(4, "Karachi");

        graph.addLocation(lahore);
        graph.addLocation(islamabad);
        graph.addLocation(multan);
        graph.addLocation(karachi);

        graph.addRoad(lahore, islamabad, 380);
        graph.addRoad(lahore, multan, 340);
        graph.addRoad(multan, karachi, 900);

        graph.printGraph();
    }
}