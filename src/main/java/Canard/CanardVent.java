package Canard;

/*
 * this class represents a duck of type wind
 * this duck can increase its attack speed
 */
public class CanardVent extends Canard {
    /*
     * this constructor creates a duck of type wind
     * @param nom the name of the duck
     * 
     */
    public CanardVent(String nom) {
        super(nom, 70, 30, TypeCanard.VENT);
    }

    /*
     * this method is used to increase the attack speed of the duck
     */
    @Override
    public void activerCapaciteSpeciale() {
        System.out.println(getNom() + " utilise sa capacité spéciale : Vent de Tempête !");
        System.out.println("l'attaque speed de " + getNom() + " augmente de 1 !");
        setAS(getAS() + 1);
        System.out.println("L'attaque speed de " + getNom() + " est maintenant de " + getAS() + ".");
    }

    @Override
    public void activerCapaciteSpeciale(Canard canard) {
        System.out.println(getNom() + " n'a pas de deuxième capacité spéciale !");
    }

}
