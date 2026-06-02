package models;

public class Location {
    private String locationName;
    private int id;

    Location(int id , String locationName  ){
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


