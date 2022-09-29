package com.example.mtl_parking_finder.model;

import javax.persistence.*;

@Entity
public class Sign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double longitude;
    private Double latitude;

    private String nomArrond;
    private String description;
    private Integer startMonth;
    private Integer startDate;
    private Integer endMonth;
    private Integer endDate;

    public Sign() {
    }

    public Sign(Long id, Double longitude, Double latitude, String nomArrond, String description, Integer startMonth, Integer startDate, Integer endMonth, Integer endDate) {
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
        this.nomArrond = nomArrond;
        this.description = description;
        this.startMonth = startMonth;
        this.startDate = startDate;
        this.endMonth = endMonth;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getNomArrond() {
        return nomArrond;
    }

    public void setNomArrond(String nom_arrond) {
        this.nomArrond = nom_arrond;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description_rpa) {
        this.description = description_rpa;
    }

    public Integer getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(Integer start_month) {
        this.startMonth = start_month;
    }

    public Integer getStartDate() {
        return startDate;
    }

    public void setStartDate(Integer start_date) {
        this.startDate = start_date;
    }

    public Integer getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(Integer end_month) {
        this.endMonth = end_month;
    }

    public Integer getEndDate() {
        return endDate;
    }

    public void setEndDate(Integer end_date) {
        this.endDate = end_date;
    }

    @Override
    public String toString() {
        return "Sign{" +
                "id=" + id +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", nom_arrond='" + nomArrond + '\'' +
                ", description_rpa='" + description + '\'' +
                ", start_month=" + startMonth +
                ", start_date=" + startDate +
                ", end_month=" + endMonth +
                ", end_date=" + endDate +
                '}';
    }
}
