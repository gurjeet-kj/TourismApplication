package com.gurjeet.tourismapplication;

public class CountryLocation {
    private String countryName;

    private String locationName;
    private int locationImage;
    private double locationPrice;

    public CountryLocation(String countryName,String locationName, int locationImage, double locationPrice) {
        this.countryName = countryName;

        this.locationName = locationName;
        this.locationImage = locationImage;
        this.locationPrice = locationPrice;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getLocationName() {
        return locationName;
    }

    public int getLocationImage() {
        return locationImage;
    }

    public double getLocationPrice() {
        return locationPrice;
    }
}
