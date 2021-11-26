package com.example.demo2.classes;

public class Soldat extends Humain {

    public Soldat(String nom, int pv, String grade) {
        super(nom);
        setPv(pv);
        setGrade(grade);
    }

    @Override
    public String toString() {
        return "Soldat : " + getNom() + " -  pv : " + getPv();
    }
}
