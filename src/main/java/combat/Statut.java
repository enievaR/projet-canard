package combat;

import Canard.Canard;


/*
 * Enum representing the status effects that can be applied to a duck.
 * Each status effect has a specific behavior when applied to a duck.
 * 
 */
public enum Statut {
    /*
     * 
     */
    BRULURE,
    GEL,
    PARALYSIE,
    VOLE;

    /*
     * * Method to apply the effect of a status to a duck.
     * * @param effet The status effect to apply.
     * * @param canard The duck to which the effect is applied.
     */
    public static void appliquerEffet(Statut effet, Canard canard) {
        switch (effet) {
            case BRULURE:
                System.out.println(canard.getNom() + " est brûlé !");
                canard.subirDegats(10);
                if(Math.random() < 0.4){
                    canard.setStatut(null);
                    canard.setCountTimeStatut(0);
                    System.out.println(canard.getNom() + " a guéri de sa brûlure !");
                }
                break;
            case GEL:
                System.out.println(canard.getNom() + " est gelé !");
                if (canard.getCountTimeStatut() <2) {
                    System.out.println(canard.getNom() + " est gelé et ne peut pas attaquer !");
                } else {
                    System.out.println(canard.getNom() + " ,'est plus gelé et peut attaquer !");
                    canard.setStatut(null);
                    canard.setCountTimeStatut(0);
                }
                if(Math.random() < 0.4){
                    canard.setStatut(null);
                    canard.setCountTimeStatut(0);
                    System.out.println(canard.getNom() + " a guéri de son gel !");
                }
                break;
            case PARALYSIE:
                System.out.println(canard.getNom() + " est paralysé !");
                if (Math.random() < 0.5) {
                    System.out.println(canard.getNom() + " est paralysé et ne peut pas attaquer !");
                } else {
                    System.out.println(canard.getNom() + " attaque normalement !");
                }
                if(Math.random() < 0.4){
                    canard.setStatut(null);
                    canard.setCountTimeStatut(0);
                    System.out.println(canard.getNom() + " a guéri de sa paralysie !");
                }
                break;
            case VOLE:
                
            
            default:
                break;
        }
    }
}
