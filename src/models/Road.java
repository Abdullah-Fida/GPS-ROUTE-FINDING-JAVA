package models;

import javax.print.attribute.standard.Destination;

public class Road {

    Location destinationCity;
    double distance;

    Road(Location destinationCity , double distance ){
        this.destinationCity = destinationCity;
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }

    public Location getDestinationCity() {
        return destinationCity;
    }


    @Override
    public String  toString(){
        return "Distance KM : " + distance +" "+ "DestinationCity : " + destinationCity  ;
    }
}
