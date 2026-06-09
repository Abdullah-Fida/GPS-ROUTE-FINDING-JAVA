import models.Location;
import service.GPSservice;
import utils.MapPrinter;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        GPSservice gps = new GPSservice();

        Location lahore =
                new Location(1,"Lahore");

        Location multan =
                new Location(2,"Multan");

        Location islamabad =
                new Location(3,"Islamabad");

        Location karachi =
                new Location(4,"Karachi");

        gps.addLocation(lahore);
        gps.addLocation(multan);
        gps.addLocation(islamabad);
        gps.addLocation(karachi);

        gps.addRoad(lahore,multan,350);
        gps.addRoad(lahore,islamabad,280);
        gps.addRoad(islamabad,karachi,1200);
        gps.addRoad(multan,karachi,900);

        MapPrinter.printGraph(
                gps.getGraph());

        List<Location> route =
                gps.findRoute(
                        lahore,
                        karachi);

        MapPrinter.printRoute(
                route,
                gps.getDistance(
                        karachi));
    }
}