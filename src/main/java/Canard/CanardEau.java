package Canard;

public class CanardEau extends Canard {
    
        public CanardEau(String nom, int pv, int atk) {
            super(nom, pv, atk, TypeCanard.EAU);
        }

        @Override
        public void activerCapaciteSpeciale() {
            System.out.println("Je suis un canard de type eau et j'active ma capacité spéciale !");
        }
} 



