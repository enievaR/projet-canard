package Canard;

/**
 * Enum of the types of ducks.
 * Each type has a specific interaction with other types.
 * 
 */

// Enum representing the types of ducks
public enum TypeCanard {
    EAU,
    FEU,
    GLACE,
    VENT;

    /*
     * Method to get the multiplier for a given type of duck against another type.
     * @param bully The type of duck that is attacking.
     * @param bullied The type of duck that is being attacked.
     * @return The multiplier for the attack.
     *         2.0 if the attack is super effective,
     *        1.0 if the attack is normally effective,
     *       0.5 if the attack is not very effective.
     */
    public static double getMultiplicateur(TypeCanard bully, TypeCanard bullied) {
        if (bully == EAU && bullied == FEU) {
            return 1.5;
        } else if (bully == FEU &&  bullied == GLACE) {
            return 1.5;
        } else if (bully == GLACE && bullied == VENT) {
            return 1.5;
        } else if (bully == VENT && bullied == EAU) {
            return 1.5;
        } else if (bully ==  bullied) {
            return 1.0;
        } else {
            return 0.5;
        }

        //TODO : Add more types and their interactions
    }
}