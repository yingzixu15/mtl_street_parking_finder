package com.example.mtl_parking_finder.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Sign {
    @Id
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

    public Double getLongitude() {
        return longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public String getNom_arrond() {
        return nom_arrond;
    }

    public String getDescription_rpa() {
        return description_rpa;
    }

    public Integer getStart_month() {
        return start_month;
    }

    public Integer getStart_date() {
        return start_date;
    }

    public Integer getEnd_month() {
        return end_month;
    }

    public Integer getEnd_date() {
        return end_date;
    }
}
