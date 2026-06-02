package models;

public class Location {
    private String locationName;
    private int id;

    Location(String locationName , int id){
        this.locationName = locationName;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getLocationName() {
        return locationName;
    }

    @Override
    public String toString(){
        return "LocationName : " + locationName + " ID :" + id;
    }
}
