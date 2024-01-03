package com.app.tracker.models;

public class Address {

    private Integer streetId;
    private String streetName;
    private Integer zipCode;
    private String country;

    public Address(Integer streetId, String streetName, Integer zipCode, String country) {
        this.streetId = streetId;
        this.streetName = streetName;
        this.zipCode = zipCode;
        this.country = country;
    }

    public Integer getStreetId() {
        return streetId;
    }

    public void setStreetId(Integer streetId) {
        this.streetId = streetId;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
