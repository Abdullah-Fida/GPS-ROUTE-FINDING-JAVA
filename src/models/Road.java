package models;

import javax.print.attribute.standard.Destination;

public class Road {
    Location socurceCity;
    Location destinationCity;
    double distance;

    Road(Location destinationCity , double distance , Location socurceCity){
        this.destinationCity = destinationCity;
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }

    public Location getDestinationCity() {
        return destinationCity;
    }

    public Location getSocurceCity() {
        return socurceCity;
    }

    @Override
    public String  toString(){
        return"Soucrce City : " + socurceCity+  " " +"Distance KM : " + distance +" "+ "DestinationCity : " + destinationCity  ;
    }
}
