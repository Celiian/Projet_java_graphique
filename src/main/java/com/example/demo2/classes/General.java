package com.example.demo2.classes;

public class General extends Humain{
    private int nombreSoldat;

    public General(String nom) {
        super(nom);
    }

    public int getNombreSoldat() {
        return nombreSoldat;
    }

    public void setNombreSoldat(int nombreSoldat) {
        this.nombreSoldat = nombreSoldat;
    }

    @Override
    public String toString() {
        return "General{" +
                "nom=" + getNom() +
                '}';
    }
}
