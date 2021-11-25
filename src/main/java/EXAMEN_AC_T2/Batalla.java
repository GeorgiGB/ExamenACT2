package EXAMEN_AC_T2;

import java.util.ArrayList;

public class Batalla {
    private String nom;
    private String data;

    //Constructor
    public Batalla(String nom, String data) {
        this.nom = nom;
        this.data = data;
    }

    //getter y setters


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Batalla:" +
                "Nombre ='" + nom + '\'' +
                ", Data='" + data + '\'';
    }
}
