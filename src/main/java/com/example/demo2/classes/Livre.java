package com.example.demo2.classes;

public class Livre {

    private String titre;
    private String auteur;
    private String resume;
    private int colonne;
    private int range;
    private int parution;
    private int index;
    private String url;

    public Livre(String titre, String auteur, String resume, int colonne, int range, int parution, int index, String url) {
        this.titre = titre;
        this.auteur = auteur;
        this.resume = resume;
        this.colonne = colonne;
        this.range = range;
        this.parution = parution;
        this.index = index;
        this.url = url;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public int getColonne() {
        return colonne;
    }

    public void setColonne(int colonne) {
        this.colonne = colonne;
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

    public String getUrl() { return url; }

    public void setUrl(String url) { this.url = url; }

    @Override
    public String toString() {
        return "Livre{" +
                "Titre='" + titre + '\'' +
                ", Auteur='" + auteur + '\'' +
                ", Resume='" + resume + '\'' +
                ", Colonne=" + colonne +
                ", range=" + range +
                ", parution=" + parution +
                '}';
    }
}
