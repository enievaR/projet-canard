package Canard;

import java.lang.reflect.Type;

public abstract class Canard {
    
    private String nom;
    private int pv;
    private int atk;
    private TypeCanard type;

    public Canard(String nom, int pv, int atk, TypeCanard type) {
        this.nom = nom;
        this.pv = pv;
        this.atk = atk;
        this.type = type;
    }

    public String getNom() {
        return nom;
    }

    public TypeCanard getType() {
        return type;
    }

    public void attaquer(Canard autreCanard) {
        autreCanard.pv -= this.atk;
    }

    public void subirDegats(int degats) {
        this.pv -= degats;
    }

    public boolean estKO() {
        return this.pv <= 0;
    }

    public void activerCapaciteSpeciale() {
        System.out.println(nom + " n'a pas de capacité spéciale. Pourtant il est de type " + type + "!");
    }

    @Override
    public String toString() {
        return "Nom : " + nom + "\n  -PV : " + pv + "\n  -ATK : " + atk + "\n  -Type : " + type;
    }

} 
