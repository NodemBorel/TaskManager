package com.taskmanager;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        int choix;
        do {
            System.out.println("==================== Menu ====================");
            System.out.println("1. Creer une tache");
            System.out.println("2. Modifier une tache");
            System.out.println("3. Supprimer une tache");
            System.out.println("4. Lister les taches");
            System.out.println("5. Quitter");

            System.out.print("Choisissez une option: ");
            choix = scanner.nextInt();
            scanner.nextLine(); // Consomme la nouvelle ligne restante

            switch (choix) {
                case 1:
                    System.out.println("========== Creation de tache ==========");
                    System.out.print("Titre: ");
                    String titre = scanner.nextLine();
                    System.out.print("Description: ");
                    String description = scanner.nextLine();
                    System.out.print("Date d'échéance (annee-mois-jour): ");
                    String date_echeance = scanner.nextLine();
                    System.out.print("Priorite: ");
                    int priorite = scanner.nextInt();
                    scanner.nextLine(); // Consomme la nouvelle ligne

                    Tache tache = new Tache(titre, description, date_echeance, priorite, 1,1,1);
                    taskManager.createTache(tache);
                    break;
                case 2:
                    System.out.println("yfr");
                    break;
                case 3:
                    System.out.println("yfr");
                    break;
                case 4:
                    System.out.println("yfr");
                    break;
                case 5:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Option invalide");
            }
        } while (choix != 5);

        scanner.close();
    }
}