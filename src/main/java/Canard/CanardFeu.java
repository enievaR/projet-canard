package Canard;

import combat.Statut;

/*
 * The class representing a fire duck.
 * This duck has a special ability to burn another duck.
 * 
 */
public class CanardFeu extends Canard {

    /*
     * Constructor for the CanardFeu class.
     * @param nom The name of the duck.
     */
    public CanardFeu(String nom) {
        super(nom, 80, 40, TypeCanard.FEU);
    }

    
    @Override
    public void activerCapaciteSpeciale() {
        System.out.println(getNom() + "n'a pas de deuxième capacité spéciale !");
    }

    /*
     * Method to activate the special ability of the duck.
     * This ability burns another duck if it is not already affected by a status.
     * @param canard The duck to which the ability is applied.
     */
    @Override
    public void activerCapaciteSpeciale(Canard canard) {
        System.out.println(getNom() + " utilise sa capacité spéciale : Tempête de feu !");
        if (canard.getStatut() == null) {
            canard.setStatut(Statut.BRULURE);
            System.out.println(canard.getNom() + " est brûlé !");
        } else {
            System.out.println(canard.getNom() + " est déjà affecté par un statut !");
        }
    }
}
