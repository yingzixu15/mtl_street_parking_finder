package com.example.mtl_parking_finder.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Voie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomVoie;
    private String nomVille;
    private int sensCir;
    private String typeF;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomVoie() {
        return nomVoie;
    }

    public void setNomVoie(String nomVoie) {
        this.nomVoie = nomVoie;
    }

    public String getNomVille() {
        return nomVille;
    }

    public void setNomVille(String nomVille) {
        this.nomVille = nomVille;
    }

    public int getSensCir() {
        return sensCir;
    }

    public void setSensCir(int sensCir) {
        this.sensCir = sensCir;
    }

    public String getTypeF() {
        return typeF;
    }

    public void setTypeF(String typeF) {
        this.typeF = typeF;
    }

    @Override
    public String toString() {
        return "Voie{" +
                "id=" + id +
                ", nomVoie='" + nomVoie + '\'' +
                ", nomVille='" + nomVille + '\'' +
                ", sensCir=" + sensCir +
                ", typeF='" + typeF + '\'' +
                '}';
    }
}
