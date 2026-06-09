package service;


import algorithm.Dijkstra;
import models.*;

import java.util.List;

public class GPSservice {

    private Graph graph;
    private Dijkstra dijkstra;

    public GPSservice() {
        graph = new Graph();
        dijkstra = new Dijkstra();
    }

    public void addLocation(Location location) {
        graph.addLocation(location);
    }

    public void addRoad(
            Location source,
            Location destination,
            double distance) {

        graph.addRoad(
                source,
                destination,
                distance);
    }

    public List<Location> findRoute(
            Location start,
            Location end) {

        return dijkstra.findShortestPath(
                graph,
                start,
                end);
    }

    public double getDistance(Location end) {

        return dijkstra.getDistance(end);
    }

    public Graph getGraph() {
        return graph;
    }
}
