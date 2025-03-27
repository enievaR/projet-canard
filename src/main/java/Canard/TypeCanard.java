package Canard;

public enum TypeCanard {
    EAU,
    FEU,
    GLACE,
    VENT;

    public double getMultiplicateur(TypeCanard cible) {
        if (this == EAU && cible == FEU) {
            return 2.0;
        } else if (this == FEU && cible == GLACE) {
            return 2.0;
        } else if (this == GLACE && cible == VENT) {
            return 2.0;
        } else if (this == VENT && cible == EAU) {
            return 2.0;
        } else if (this == cible) {
            return 1.0;
        } else {
            return 0.5;
        }
    }
}