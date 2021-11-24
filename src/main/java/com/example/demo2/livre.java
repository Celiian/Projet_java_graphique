package com.example.demo2;

public class livre {

    private String Titre;
    private String Auteur;
    private String Resume;
    private int Colonne;
    private int range;
    private int parution;

    public livre(String titre, String auteur, String resume, int colonne, int range, int parution) {
        Titre = titre;
        Auteur = auteur;
        Resume = resume;
        Colonne = colonne;
        this.range = range;
        this.parution = parution;
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
}
