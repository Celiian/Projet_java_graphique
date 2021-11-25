package com.example.demo2.classes;

public class General extends Humain{


    public General(String nom) {
        super(nom);
    }


    @Override
    public String toString() {
        return "General{" +
                "nom=" + getNom() +
                '}';
    }
}
