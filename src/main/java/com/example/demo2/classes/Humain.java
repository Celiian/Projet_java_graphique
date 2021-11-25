package com.example.demo2.classes;

public abstract class Humain {
    private String nom;


    public Humain(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
