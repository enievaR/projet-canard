package com.project;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

import Canard.Canard;
import Canard.CanardEau;
import Canard.CanardFeu;
import Canard.CanardGlace;
import Canard.CanardVent;
import combat.Combat;


/*
 * * Main class of the application.
 * * This class contains the main method and the menu of the application.
 * * It allows the user to create ducks, launch battles and display the created ducks.
 * * It also contains the methods to read and write the save file.
 * * The save file is a JSON file that contains the list of ducks created by the user.
 * 
 * * @author Mordohai Florian & Younes Karmouch
 * * @version 1.0
 */
public final class App {
    private static final String FILE_PATH = "canards.json"; // Path to the JSON file
    private static List<Canard> canards = ReadSave(); // List of ducks

    private App() {
    }

    /*
     * Method to read the save file and load the ducks
     */
    private static List<Canard> ReadSave() {
    Gson gson = new Gson();
    List<Canard> loadedCanards = new ArrayList<>();

    try {
        File file = new File(FILE_PATH);
        if (!file.exists() || file.length() == 0) {
            return loadedCanards; // Create empty list if file doesn't exist or is empty (Don't create a new file beause it is already created (normally))
        }



        try (FileReader reader = new FileReader(file)) {
            Type listType = new TypeToken<List<String>>() {}.getType();
            List<String> coincoins = gson.fromJson(reader, listType); // Read the file and convert it to a list of strings

            for (String data : coincoins) { //split the string to get the name and type of the duck
                String[] parts = data.split(";");
                String nom = parts[0];
                String type = parts[1];

                //create the duck according to his type
                switch (type) {
                    case "EAU":
                        loadedCanards.add(new CanardEau(nom));
                        break;
                    case "FEU":
                        loadedCanards.add(new CanardFeu(nom));
                        break;
                    case "GLACE":
                        loadedCanards.add(new CanardGlace(nom));
                        break;
                    case "VENT":
                        loadedCanards.add(new CanardVent(nom));
                        break;
                    default:
                        System.out.println("Type inconnu : " + type);
                }
            }
        }
    } catch (IOException e) {
        System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
    }

    return loadedCanards;
}

    /*
     * Method to write the ducks in the save file
     */
    private static void WriteSave(List<Canard> canards) {
        Gson gson = new Gson();

        try (FileWriter writer = new FileWriter(FILE_PATH)) { // Create a FileWriter to write to the file
            List<String> canardsSimplifies = new ArrayList<>();
            for (Canard canard : canards) { // Create a list of strings with the name and type of the duck
                // format : "name;type"
                canardsSimplifies.add(canard.getNom() + ";" + canard.getType()); //
            }
            gson.toJson(canardsSimplifies, writer);
            System.out.println("Les canards ont été sauvegardés !");
        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture dans le fichier : " + e.getMessage());
        }
    }

    public static void CreateCanard(int type, String nom) {
        switch (type) {
            case 1:
                CanardEau canardEau = new CanardEau(nom);
                System.out.println("Canard Eau créé : \n");
                System.out.println(canardEau.toString()+"\n");
                canards.add(canardEau);
                WriteSave(canards);
                break;
            case 2:
                CanardFeu canardFeu = new CanardFeu(nom);
                System.out.println("Canard Feu créé : \n");
                System.out.println(canardFeu.toString()+"\n");
                canards.add(canardFeu);
                WriteSave(canards);
                break;
            case 3:
                CanardGlace canardGlace = new CanardGlace(nom);
                System.out.println("Canard Glace créé : \n");
                System.out.println(canardGlace.toString()+"\n");
                canards.add(canardGlace);
                WriteSave(canards);
                break;
            case 4:
                CanardVent canardVent = new CanardVent(nom);
                System.out.println("Canard Vent créé : \n");
                System.out.println(canardVent.toString()+"\n");
                canards.add(canardVent);
                WriteSave(canards);
                break;
            default:
                System.out.println("Type de canard inconnu. Canard Eau créé par défaut.");
                CanardEau defaultCanard = new CanardEau(nom);
                System.out.println("Canard Eau créé : \n");
                System.out.println(defaultCanard.toString()+"\n");
                canards.add(defaultCanard);
                WriteSave(canards);
                break;
        }
    }

    public static void Printcanards() {
        if (canards.isEmpty()) {
            System.out.println("Aucun canard créé.");
            return;
        }
        for (int i = 0; i < canards.size(); i++) {
            System.out.println(i+"- "+canards.get(i)+"\n");
        }
    }

    /**
     * First menu of the games
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        // main loop of the menu
        while (choice != 4) {
            System.out.println("Bienvenue dans Canard Fighter Simulator !");
            System.out.println("1. Créer un canard");
            System.out.println("2. Lancer une bataille");
            System.out.println("3. Afficher les canards créés");
            System.out.println("4. Quitter");
            System.out.print("Veuillez choisir une option : ");

            try {
                choice = Integer.parseInt(scanner.nextLine());

                // select the choice of the user
                switch (choice) {
                    case 1:
                        System.out.print("Entrez le nom du canard : ");
                        String nom = scanner.nextLine();
                        System.out.print("Entrez le type de canard (1: EAU, 2: FEU, 3: GLACE, 4: VENT) : ");
                        int typeCanard = scanner.nextInt();
                        CreateCanard(typeCanard, nom); // Create the duck with the given name and type
                        break;
                    case 2:
                        if(canards.size() < 2) {
                            System.out.println("Il faut au moins 2 canards pour lancer une bataille !");
                        } else {
                            System.out.println("Choisissez le premier canard : ");
                            Printcanards();
                            int canard1Index = scanner.nextInt();
                            System.out.println("Choisissez le deuxième canard : ");
                            Printcanards();
                            int canard2Index = scanner.nextInt();
                            if (canard1Index < 0 || canard1Index >= canards.size() || canard2Index < 0 || canard2Index >= canards.size()) {
                                System.out.println("Canard invalide. Veuillez réessayer.");
                            } else {
                                Combat combat = new Combat(canards.get(canard1Index), canards.get(canard2Index)); // Create a new combat with the selected ducks
                                combat.start(); // Start the combat
                            }

                            
                        }

                        break;
                    case 3:
                        System.out.println("Canards créés : \n");
                        Printcanards(); // Display the list of ducks created
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
