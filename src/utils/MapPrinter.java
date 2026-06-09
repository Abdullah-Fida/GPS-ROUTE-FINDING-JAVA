package utils;

import models.*;

import java.util.List;

public class MapPrinter {

    public static void printGraph(Graph graph) {

        System.out.println("\n===== MAP =====");

        for (Location location :
                graph.getLocations()) {

            System.out.print(
                    location.getLocationName()
                            + " -> ");

            for (Road road :
                    graph.getNeighbors(location)) {

                System.out.print(
                        road.getDestinationCity()
                                .getLocationName()
                                + "("
                                + road.getDistance()
                                + "km)  ");
            }

            System.out.println();
        }
    }

    public static void printRoute(
            List<Location> route,
            double distance) {

        System.out.println(
                "\n===== SHORTEST ROUTE =====");

        for (Location location : route) {

            System.out.print(
                    location.getLocationName());

            if (!location.equals(
                    route.get(route.size()-1))) {

                System.out.print(
                        " -> ");
            }
        }

        System.out.println(
                "\nTotal Distance: "
                        + distance
                        + " km");
    }
}