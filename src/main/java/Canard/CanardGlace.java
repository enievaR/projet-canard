package Canard;

public class CanardGlace extends Canard {
    public CanardGlace(String nom) {
        super(nom, 100, 20, TypeCanard.GLACE);
    }

    @Override
    public void activerCapaciteSpeciale() {
        System.out.println("Je suis un canard de type Glace et j'active ma capacité spéciale !");
    }

}
