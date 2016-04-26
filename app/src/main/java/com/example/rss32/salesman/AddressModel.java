package com.example.rss32.salesman;

/**
 * Created by rss32 on 19/4/16.
 */
public class AddressModel {
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    String address;
    double latitude;
    double longitude;
}
