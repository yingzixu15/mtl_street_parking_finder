package com.example.mtl_parking_finder.model;

public class Coordinate {
    private Double longitude;
    private Double latitude;

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinate that = (Coordinate) o;

        if (!longitude.equals(that.longitude)) return false;
        return latitude.equals(that.latitude);
    }


    @Override
    public String toString() {
        return "Coordinate{" +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }

    public Double distanceTo(Coordinate coordinate) {
        return null;
    }

    public Double distanceTo(Double longitude, Double latitude) {
        return null;
    }
}
