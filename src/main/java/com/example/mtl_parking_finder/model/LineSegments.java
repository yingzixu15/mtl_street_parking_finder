package com.example.mtl_parking_finder.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class LineSegments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private StringType stringType;

    @OneToMany
    private List<Coordinate> coordinates;

    @ManyToOne
    private Voie voie;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StringType getStringType() {
        return stringType;
    }

    public void setStringType(StringType stringType) {
        this.stringType = stringType;
    }


    public Voie getVoie() {
        return voie;
    }

    public void setVoie(Voie voie) {
        this.voie = voie;
    }

    @Override
    public String toString() {
        return "LineSegments{" +
                "id=" + id +
                ", stringType=" + stringType +
                ", coordinates=" + coordinates +
                ", voie=" + voie +
                '}';
    }
}
