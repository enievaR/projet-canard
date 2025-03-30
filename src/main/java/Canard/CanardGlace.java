package canard;

import combat.Statut;

/*
 * this class represents a duck of type ice
 * this duck can freeze the opponent
 */
public class CanardGlace extends Canard {

    /*
     * this constructor creates a duck of type ice
     * @param nom the name of the duck
     */
    public CanardGlace(String nom) {
        super(nom, 120, 30, TypeCanard.GLACE);
    }

    
    @Override
    public void activerCapaciteSpeciale() {
        System.out.println(getNom() + " N'a pas de deuxième capacité spéciale !");
    }

    /*
     * this method is used to attack the opponent
     * @param canard the opponent duck
     */
    @Override
    public void activerCapaciteSpeciale(Canard canard) {
        System.out.println(getNom() + " utilise sa capacité spéciale : Tempête de Glace !");
        if (canard.getStatut() == null) {
            canard.setStatut(Statut.GEL);
            System.out.println(canard.getNom() + " est gelé !");
        } else {
            System.out.println(canard.getNom() + " est déjà affecté par un statut !");
        }
    }

}
