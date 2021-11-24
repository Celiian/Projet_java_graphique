package com.example.demo2;

public class Livre {

    private String Titre;
    private String Auteur;
    private String Resume;
    private int Colonne;
    private int range;
    private int parution;
    private int index;
    private String url;

    public Livre(String titre, String auteur, String resume, int colonne, int range, int parution, int index, String url) {
        this.Titre = titre;
        this.Auteur = auteur;
        this.Resume = resume;
        this.Colonne = colonne;
        this.range = range;
        this.parution = parution;
        this.index = index;
        this.url = url;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String titre) {
        Titre = titre;
    }

    public String getAuteur() {
        return Auteur;
    }

    public void setAuteur(String auteur) {
        Auteur = auteur;
    }

    public String getResume() {
        return Resume;
    }

    public void setResume(String resume) {
        Resume = resume;
    }

    public int getColonne() {
        return Colonne;
    }

    public void setColonne(int colonne) {
        Colonne = colonne;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getParution() {
        return parution;
    }

    public void setParution(int parution) {
        this.parution = parution;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "Livre{" +
                "Titre='" + Titre + '\'' +
                ", Auteur='" + Auteur + '\'' +
                ", Resume='" + Resume + '\'' +
                ", Colonne=" + Colonne +
                ", range=" + range +
                ", parution=" + parution +
                '}';
    }
}
