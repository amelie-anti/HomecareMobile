package com.example.homecaremobile;

import java.util.Date;

public class Bien {
    
    public String adresse;
    public String ville;
    public String codePostal;
    public String dateConstruction;
    public int surface;

    public Bien(String adresse, String ville, String codePostal, String dateConstruction, int surface) {
        this.adresse = adresse;
        this.ville = ville;
        this.codePostal = codePostal;
        this.dateConstruction = dateConstruction;
        this.surface = surface;
    }

    //Les setters
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public void setVille(String ville) {
        this.ville = ville;
    }
    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }
    public void setDateConstruction(String dateConstruction) {
        this.dateConstruction = dateConstruction;
    }
    public void setSurface(int surface) {
        this.surface = surface;
    }

    //Les getters
    public String getAdresse() {
        return adresse;
    }
    public String getVille() {
        return ville;
    }
    public String getCodePostal() {
        return codePostal;
    }
    public String getDateConstruction() {
        return dateConstruction;
    }
    public int getSurface() {
        return surface;
    }


    @Override
    public String toString()  {
        return this.codePostal +" (Ville: "+ this.ville +")";
    }
}
