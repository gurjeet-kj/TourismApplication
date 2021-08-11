package com.gurjeet.tourismapplication;

public class Country {
    private String country;
    private String countryCapital;
    private int countryFlag;


    public Country(String country, String countryCapital, int countryFlag) {
        this.country = country;
        this.countryCapital = countryCapital;
        this.countryFlag = countryFlag;

    }

    public String getCountry() {
        return country;
    }

    public String getCountryCapital() {
        return countryCapital;
    }

    public int getCountryFlag() {
        return countryFlag;
    }

}
