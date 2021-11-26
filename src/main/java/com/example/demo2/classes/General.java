package com.example.demo2.classes;

public class General extends Humain{


    public General(String nom) {
        super(nom);
    }


    @Override
    public String toString() {
        if(getNom().equals("msg-root")){
            return "Cliquez ici pour ajouter un Général";
        }
        else {
            return "General : " + getNom();
        }
    }
}
