package Canard;

public class CanardFeu extends Canard {
    public CanardFeu(String nom) {
        super(nom, 100, 20, TypeCanard.FEU);
    }
    
    @Override
    public void activerCapaciteSpeciale() {
        System.out.println("Je suis un canard de type Feu et j'active ma capacité spéciale !");
    }
}
