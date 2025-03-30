package Canard;

/*
 * Class representing a water duck.
 * This duck has a special ability to heal itself for 20 HP.
 */
public class CanardEau extends Canard {
    
        /*
         * Constructor for the CanardEau class.
         * @param nom The name of the duck.
         */

        public CanardEau(String nom) {
            super(nom, 100, 20, TypeCanard.EAU);
        }

        /*
         * Method to activate the special ability of the duck.
         * This ability heals the duck for 20 HP.
         */
        @Override
        public void activerCapaciteSpeciale() {
            System.out.println(getNom() + " utilise sa capacité spéciale : " + getNom() + " se soigne de 20 PV !");
            int pv = getPV() + 20;
            if (pv > 100) {
                pv = 100;
            }
            setPV(pv);
        }

        /*
         * Method to activate the special ability of the duck against another duck.
         * This ability has no effect on the other duck.
         * @param canard The duck to which the ability is applied.
         */
        @Override
        public void activerCapaciteSpeciale(Canard canard){
            System.out.println(getNom() + "N'a pas de  deuxième capcité spéciale !");
        }
} 



