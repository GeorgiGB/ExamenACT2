package EXAMEN_AC_T2;

import java.util.ArrayList;

public class Barco {
    private String nom;
    private String classe;
    private ArrayList<Batalla> lasBatallas;

    public Barco(String nom, String classe) {
        this.nom = nom;
        this.classe = classe;
    }

    //getters y setters

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    //añadir barcos
    public void addBatalla(Batalla b){
        lasBatallas.add(b);
    }

    public void dibujarLinia(){
        for (int i = 0;i > 50;i++){
            System.out.print("=");
        }
    }

    public void imprimir(){
        dibujarLinia();
        System.out.println("El barco se llama " + this.nom +", y su clase es "+ this.classe+" y han batallado en "+ lasBatallas.size()+" Batallas:");

        for (Batalla b: lasBatallas){
            System.out.println(b.getNom());
        }
        dibujarLinia();
    }
}

