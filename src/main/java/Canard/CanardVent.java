package Canard;

public class CanardVent extends Canard {
    public CanardVent(String nom) {
        super(nom, 100, 20, TypeCanard.VENT);
    }

    @Override
    public void activerCapaciteSpeciale() {
        System.out.println("Je suis un canard de type Vent et j'active ma capacité spéciale !");
    }

}
