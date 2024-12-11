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
                    System.out.print("Date d'echeance (annee-mois-jour): ");
                    String date_echeance = scanner.nextLine();
                    System.out.print("Priorite: ");
                    int priorite = scanner.nextInt();
                    scanner.nextLine();

                    Tache tache = new Tache(titre, description, date_echeance, priorite, 1,1,1);
                    taskManager.createTache(tache);
                    break;
                case 2:
                    System.out.println("========== Modification de tache ==========");
                    System.out.print("ID de la tâche a modifier : ");
                    int idTacheM = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Entrez les nouveaux détails de la tâche :");
                    System.out.print("Titre : ");
                    titre = scanner.nextLine();
                    System.out.print("Description : ");
                    description = scanner.nextLine();
                    System.out.print("Date d'echeance (annee-mois-jour) : ");
                    date_echeance = scanner.nextLine();
                    System.out.print("Priorite: ");
                    priorite = scanner.nextInt();
                    scanner.nextLine();

                    tache = new Tache(titre, description, date_echeance, priorite, 1, 1, 1);
                    taskManager.updateTache(idTacheM, tache);
                    break;
                case 3:
                    System.out.println("========== Supression de tache ==========");
                    System.out.print("ID de la tache a supprimer : ");
                    int idTache = scanner.nextInt();
                    scanner.nextLine(); 
                    taskManager.deleteTache(idTache);
                    break;
                case 4:
                    System.out.println("========== Affichage de tache ==========");
                    System.out.print("Numéro de page : ");
                    int page = scanner.nextInt();
                    scanner.nextLine(); 
                    List<Tache> tasks = taskManager.afficheTache(page, 10);
                    tasks.forEach(t -> System.out.println("ID: " + t.getId() + ", Titre: " + t.getTitre()));
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
