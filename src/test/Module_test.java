package test;

import java.util.List;
import java.util.Scanner;

import dao.ModuleDAO;
import model.ModuleFormation;

public class Module_test {
    public static void main(String[] args) {
        ModuleDAO dao = new ModuleDAO();
        Scanner scanner = new Scanner(System.in);
        int choix = 1;
        while (choix != 0) {
            System.out.println("\n===== GESTION DES MODULES =====");
            System.out.println("1. Ajouter un module");
            System.out.println("2. Modifier un module");
            System.out.println("3. Supprimer un module");
            System.out.println("4. Chercher un module");
            System.out.println("5. Lister tous les modules");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine();
            switch (choix) {
                case 1:
                    System.out.println("\n--- AJOUT DE MODULE ---");
                    System.out.print("Nom du module : ");
                    String nomModule = scanner.nextLine();
                    System.out.print("Description : ");
                    String description = scanner.nextLine();
                    System.out.print("Durée (en heures) : ");
                    int duree = scanner.nextInt();
                    scanner.nextLine();
                    ModuleFormation m = new ModuleFormation(0, nomModule, description, duree);
                    dao.ajouterModule(m);
                    System.out.println("Module ajouté !");
                    break;
                case 2:
                    System.out.print("\nID du module à modifier : ");
                    int idm = scanner.nextInt();
                    scanner.nextLine();
                    ModuleFormation moduleToModify = dao.chercherModule(idm);
                    if (moduleToModify != null) {
                        System.out.print("Nouveau nom du module [ " + moduleToModify.getNomModule() + " ]: ");
                        moduleToModify.setNomModule(scanner.nextLine());
                        System.out.print("Nouvelle description [ " + moduleToModify.getDescription() + " ]: ");
                        moduleToModify.setDescription(scanner.nextLine());
                        System.out.print("Nouvelle durée (en heures) [ " + moduleToModify.getDuree() + " ]: ");
                        moduleToModify.setDuree(scanner.nextInt());
                        scanner.nextLine();

                        dao.modifierModule(moduleToModify);
                        System.out.println("Module modifié !");
                    } else {
                        System.out.println("Module introuvable !");
                    }
                    break;
                case 3:
                    System.out.print("\nID du module à supprimer : ");
                    int ids = scanner.nextInt();
                    scanner.nextLine();
                    dao.supprimerModule(ids);
                    System.err.println("Module supprimé !");
                    break;
                case 4:
                    System.out.print("\nID du module à chercher : ");
                    int idc = scanner.nextInt();
                    ModuleFormation moduleToFind = dao.chercherModule(idc);
                    if (moduleToFind != null) {
                        System.out.println("\n Module trouvé :");
                        moduleToFind.afficher();
                    } else {
                        System.out.println("Module introuvable !");
                    }
                    break;
                case 5:
                    System.out.println("\nListe des modules :");
                    List<ModuleFormation> modules = dao.listerTous();
                    for (ModuleFormation module : modules) {
                        module.afficher();
                    }
                    break;
                case 0:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide !");
                    break;
            }
        }
        scanner.close();
    }
}