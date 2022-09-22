package com.example.mtl_parking_finder.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Coordinate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
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
        Double r = 6371.0;
        Double degLat = degToRad(coordinate.latitude - this.latitude);
        Double degLon = degToRad(coordinate.longitude - this.longitude);
        Double angle = Math.pow(Math.sin(degLat/2), 2)
                + Math.cos(degToRad(this.latitude)) * Math.cos(degToRad(this.longitude))
                * Math.pow(Math.sin(degLon), 2);
        return r * 2 * Math.atan2(Math.sqrt(angle), Math.sqrt(1 - angle));
    }

    public Double longitudeSizeByKm(Double latitude, Double km) {
        Double denominator = 111.320 * Math.cos(degToRad(latitude));
        return km / denominator;
    }

    public Double latitudeSizeByKm(Double km) {
        return km / 110.574;
    }

    private Double degToRad(Double degree) {
        return degree * (Math.PI / 180);
    }
}
