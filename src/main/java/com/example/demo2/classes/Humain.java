package com.example.demo2.classes;

public abstract class Humain {
    private String nom;
    private int pv;
    private String grade;
    private int nbSoldat;
    private int index;

    public Humain(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getNbSoldat() {
        return nbSoldat;
    }

    public void setNbSoldat(int nbSoldat) {
        this.nbSoldat = nbSoldat;
    }
}
