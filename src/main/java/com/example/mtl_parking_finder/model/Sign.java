package com.example.mtl_parking_finder.model;

import javax.persistence.*;

@Entity
public class Sign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double longitude;
    private Double latitude;

    private String nom_arrond;
    private String description_rpa;
    private Integer start_month;
    private Integer start_date;
    private Integer end_month;
    private Integer end_date;

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

    public String getNom_arrond() {
        return nom_arrond;
    }

    public void setNom_arrond(String nom_arrond) {
        this.nom_arrond = nom_arrond;
    }

    public String getDescription_rpa() {
        return description_rpa;
    }

    public void setDescription_rpa(String description_rpa) {
        this.description_rpa = description_rpa;
    }

    public Integer getStart_month() {
        return start_month;
    }

    public void setStart_month(Integer start_month) {
        this.start_month = start_month;
    }

    public Integer getStart_date() {
        return start_date;
    }

    public void setStart_date(Integer start_date) {
        this.start_date = start_date;
    }

    public Integer getEnd_month() {
        return end_month;
    }

    public void setEnd_month(Integer end_month) {
        this.end_month = end_month;
    }

    public Integer getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Integer end_date) {
        this.end_date = end_date;
    }

    @Override
    public String toString() {
        return "Sign{" +
                "id=" + id +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", nom_arrond='" + nom_arrond + '\'' +
                ", description_rpa='" + description_rpa + '\'' +
                ", start_month=" + start_month +
                ", start_date=" + start_date +
                ", end_month=" + end_month +
                ", end_date=" + end_date +
                '}';
    }
}
