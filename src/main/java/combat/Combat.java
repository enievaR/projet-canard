package combat;

import java.util.Scanner;

import Canard.Canard;

public class Combat {

    private Canard canard1,canard2;
    private int tour = 1;
    private boolean tourCanard1 = true; // true si c'est le tour de canard1, false sinon

    public Combat(Canard canard1, Canard canard2) {
        this.canard1 = canard1;
        this.canard2 = canard2;
    }

    public void FightMenu(Canard bully, Canard bullied) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(bully.getNom() + " choisit une action :");
        System.out.println("1. Attaquer " + bullied.getNom());
        System.out.println("2. Activer capacité spéciale de " + bully.getNom());
        System.out.println("3. Passer son tour");
        System.out.print("Choix : ");
        int choix = scanner.nextInt();
        switch (choix) {
            case 1:
                bully.attaquer(bullied);
                System.out.println(bully.getNom() + " attaque " + bullied.getNom() + " !");
                break;
            case 2:
                bully.activerCapaciteSpeciale();
                break;
            case 3:
                System.out.println(bully.getNom() + " passe son tour.");
                break;
            default:
                System.out.println("Choix invalide. Veuillez réessayer.");
        }
    }

    public void start() {
        System.out.println("Début du combat entre " + canard1.getNom() + " et " + canard2.getNom() + " !\n");
    
        while (!canard1.estKO() && !canard2.estKO()) {
            System.out.println("Tour " + tour + " :");
            System.out.println("État de " + canard1.getNom() + " : " + canard1.getPV() + " PV restants.");
            System.out.println("État de " + canard2.getNom() + " : " + canard2.getPV() + " PV restants.\n");
    
            Statut.appliquerEffet(canard1.getStatut(), canard1);
            if (!canard1.estKO()) {
                FightMenu(canard1, canard2);
            }
    
            if (!canard2.estKO()) {
                Statut.appliquerEffet(canard2.getStatut(), canard2);
                if (!canard2.estKO()) {
                    FightMenu(canard2, canard1);
                }
            }
    
            if (canard1.estKO()) {
                System.out.println(canard1.getNom() + " est KO ! " + canard2.getNom() + " a gagné le combat !");
            } else if (canard2.estKO()) {
                System.out.println(canard2.getNom() + " est KO ! " + canard1.getNom() + " a gagné le combat !");
            }

            if(canard1.getStatut() != null) {
                canard1.setCountTimeStatut(canard1.getCountTimeStatut() +1);
            }
            if(canard2.getStatut() != null) {
                canard2.setCountTimeStatut(canard2.getCountTimeStatut() +1);
            }
            tour++;
        }
    }
    
}
