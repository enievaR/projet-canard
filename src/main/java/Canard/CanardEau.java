package Canard;

public class CanardEau extends Canard {
    
        public CanardEau(String nom) {
            super(nom, 100, 20, TypeCanard.EAU);
        }

        @Override
        public void activerCapaciteSpeciale() {
            System.out.println("Je suis un canard de type eau et j'active ma capacité spéciale !");
        }
} 



