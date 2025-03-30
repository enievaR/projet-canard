package Canard;

import combat.Statut;
import combat.CapaciteSpeciale;

/*
 * Class representing a duck.
 * Each duck has a name, health points (PV), attack points (ATK), type, status, energy points (PE), and action speed (AS).
 * The duck can attack another duck, take damage, and check if it is knocked out (KO).
 * It can also activate a special ability.
 * 
 */

public abstract class Canard implements CapaciteSpeciale {

    /*
     * The name of the duck.
     * @param nom The name of the duck.
     * @param pv The health points of the duck.
     * @param atk The attack points of the duck.
     * @param type The type of the duck.
     * @param statut The status of the duck.
     * @param PE The energy points of the duck.
     * @param AS The action speed of the duck.
     * @param countTimeStatut The number of turns the duck has been under a status effect.
     * 
     */
    private String nom;
    private int pv;
    private int atk;
    private TypeCanard type;
    private Statut statut;
    private int PE;
    private int AS;
    private int countTimeStatut = 0;

    /*
     * Constructor for the Canard class.
     * @param nom The name of the duck.
     * @param pv The health points of the duck.
     * @param atk The attack points of the duck.
     * @param type The type of the duck.
     */
    public Canard(String nom, int pv, int atk, TypeCanard type) {
        this.nom = nom;
        this.pv = pv;
        this.atk = atk;
        this.type = type;
        this.statut = null;
        this.PE = 20;
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


    /**
     * Method to attack another duck.
     * The attack is based on the attack points of the duck and the type of the duck being attacked.
     * The attack can be a critical hit, which doubles the damage.
     * 
     * @param autreCanard The duck being attacked.
     */
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

    public void activerCapaciteSpeciale(Canard canard) {
        System.out.println(nom + " n'a pas de capacité spéciale. Pourtant il est de type " + type + "!");
    }

    @Override
    public String toString() {
        return "Nom : " + nom + "\n  -PV : " + pv + "\n  -ATK : " + atk + "\n  -Type : " + type;
    }

}
