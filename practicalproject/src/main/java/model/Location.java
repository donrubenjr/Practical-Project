package model;

import java.io.Serializable;

public class Location implements Serializable {
    private static int count = 0;

    private int locationId;
    private String countryName;
    private String regionName;
    private String cityName;
    private double latitude;
    private double longitude;

    public Location(){
    }

    public Location(String countryName, String regionName, String cityName, double latitude, double longitude) {
        this.countryName = countryName;
        this.regionName = regionName;
        this.cityName = cityName;
        this.latitude = latitude;
        this.longitude = longitude;

        count++;
        this.locationId = count;
    }

    public Location(int locationId, String countryName, String regionName, String cityName, double latitude,
                    double longitude) {
        this(countryName, regionName, cityName, latitude, longitude);
        this.locationId = locationId;
    }

    //getters and setters
    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
