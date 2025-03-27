package com.project;

import java.util.Scanner;


public final class App {
    private App() {
    }

    /**
     * First menu of the games
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 3) {
            System.out.println("Bienvenue dans Canard Fighter Simulator !");
            System.out.println("1. Créer un canard");
            System.out.println("2. Lancer une bataille");
            System.out.println("3. Quitter");
            System.out.print("Veuillez choisir une option : ");

            try {
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                System.out.println("Option 1 sélectionnée : Créer un canard.");
                // Ajouter la logique pour créer un canard ici
                break;
                case 2:
                System.out.println("Option 2 sélectionnée : Lancer une bataille.");
                // Ajouter la logique pour lancer une bataille ici
                break;
                case 3:
                System.out.println("Au revoir !");
                break;
                default:
                System.out.println("Option invalide. Veuillez réessayer.");
            }
            } catch (NumberFormatException e) {
            System.out.println("Entrée invalide. Veuillez entrer un nombre.");
            }
        }

        scanner.close();
    }
}
