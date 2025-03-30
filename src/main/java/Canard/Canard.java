package Canard;

import combat.Statut;
import combat.CapaciteSpeciale;

public abstract class Canard implements CapaciteSpeciale {

    private String nom;
    private int pv;
    private int atk;
    private TypeCanard type;
    private Statut statut;
    private int PE;
    private int AS;
    private int countTimeStatut = 0;

    public Canard(String nom, int pv, int atk, TypeCanard type) {
        this.nom = nom;
        this.pv = pv;
        this.atk = atk;
        this.type = type;
        this.statut = null;
        this.PE = 15;
    }

    public String getNom() {
        return nom;
    }

    public TypeCanard getType() {
        return type;
    }

    public int getPV() {
        return pv;
    }

    public int getATK() {
        return atk;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    public int getPE() {
        return PE;
    }

    public void setPV(int pv) {
        this.pv = pv;
    }

    public void setPE(int PE) {
        this.PE = PE;
    }

    public int getAS() {
        return AS;
    }

    public void setAS(int AS) {
        this.AS = AS;
    }

    public int getCountTimeStatut() {
        return countTimeStatut;
    }

    public void setCountTimeStatut(int countTimeStatut) {
        this.countTimeStatut = countTimeStatut;
    }


    public void attaquer(Canard autreCanard) {
        if (this.PE < 5) {
            System.out.println(this.nom + " n'a pas assez de PE pour attaquer !");
            return;
        }
        for (int i = 0; i < this.AS; i++) {
            double multiplicateur = TypeCanard.getMultiplicateur(this.type, autreCanard.type);
            int degats = (int) (this.atk * multiplicateur);
            if (Math.random() < 0.1) {
                degats *= 2; // Critique
                System.out.println(this.nom + " a infligé un coup critique !");
            }
            autreCanard.pv -= degats;
        }

        this.PE -= 5;
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
