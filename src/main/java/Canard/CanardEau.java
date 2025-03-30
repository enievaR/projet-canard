package Canard;

public class CanardEau extends Canard {
    
        public CanardEau(String nom) {
            super(nom, 100, 20, TypeCanard.EAU);
        }

        @Override
        public void activerCapaciteSpeciale() {
            System.out.println(getNom() + " utilise sa capacité spéciale : " + getNom() + " se soigne de 20 PV !");
            int pv = getPV() + 20;
            if (pv > 100) {
                pv = 100;
            }
            setPV(pv);
        }
} 



