package test;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import dao.CoursDAO;
import model.Cours;

public class Cours_test {
    public static void main(String[] args) {
        CoursDAO dao = new CoursDAO();
        Scanner scanner = new Scanner(System.in);
        int choix = 1;

        while (choix != 0) {
            System.out.println("\n===== GESTION DES COURS =====");
            System.out.println("1. Ajouter un cours");
            System.out.println("2. Modifier un cours");
            System.out.println("3. Supprimer un cours");
            System.out.println("4. Chercher un cours");
            System.out.println("5. Lister tous les cours");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    System.out.println("\n--- AJOUT D'UN COURS ---");
                    System.out.print("Nom du cours : ");
                    String nomCours = scanner.nextLine();
                    System.out.print("Date du cours (YYYY-MM-DD) : ");
                    LocalDate dateCours = LocalDate.parse(scanner.nextLine());
                    System.out.print("ID Module : ");
                    int idModule = scanner.nextInt();
                    scanner.nextLine();

                    Cours nouveauCours = new Cours(0, nomCours, dateCours, idModule);
                    dao.ajouterCours(nouveauCours);
                    System.out.println( "✅ Cours ajouté avec succès !");
                    break;

                case 2:
                    System.out.print("\nID du cours à modifier : ");
                    int idModifier = scanner.nextInt();
                    scanner.nextLine();
                    Cours coursExistant = dao.rechercherCours(idModifier);
                    if (coursExistant != null) {
                        System.out.print("Nouveau nom [" + coursExistant.getNomCours() + "] : ");
                        coursExistant.setNomCours(scanner.nextLine());
                        System.out.print("Nouvelle date [" + coursExistant.getDateCours() + "] : ");
                        coursExistant.setDateCours(LocalDate.parse(scanner.nextLine()));
                        System.out.print("Nouveau ID Module [" + coursExistant.getIdModule() + "] : ");
                        coursExistant.setIdModule(scanner.nextInt());
                        scanner.nextLine();

                        dao.modifierCours(coursExistant);
                        System.out.println( "✅ Cours modifié !");
                    } else {
                        System.out.println("⚠️ Cours introuvable !");
                    }
                    break;

                case 3:
                    System.out.print("\nID du cours à supprimer : ");
                    int idSupprimer = scanner.nextInt();
                    scanner.nextLine();
                    dao.supprimerCours(idSupprimer);
                    System.out.println( "🗑️ Cours supprimé !");
                    break;
 
                case 4:
                    System.out.print("\nID du cours à chercher : ");
                    int idChercher = scanner.nextInt();
                    scanner.nextLine();
                    Cours coursTrouve = dao.rechercherCours(idChercher);
                    if (coursTrouve != null) {
                        System.out.println("\n📌 Cours trouvé :");
                        System.out.println(coursTrouve.afficher());
                    } else {
                        System.out.println("⚠️ Cours introuvable !");
                    }
                    break;

                case 5:
                    System.out.println("\n📚 Liste des cours :");
                    System.out.println("\nID du module à afficher : ");
                    int idm = scanner.nextInt();
                    List<Cours> coursList = dao.getAllCoursParModule(idm);
                    if (coursList.isEmpty()) {
                        System.out.println("Aucun cours enregistré.");
                    } else {
                        for (Cours c : coursList) {
                            System.out.println(c.afficher());
                        }
                    }
                    break;

                case 0:
                    System.out.println("👋 Au revoir !");
                    break;

                default:
                    System.out.println("❌ Choix invalide !");
                    break;
            }
        }

        scanner.close();
    }
}
