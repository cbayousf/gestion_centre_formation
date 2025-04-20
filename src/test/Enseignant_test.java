package test;

import java.util.List;
import java.util.Scanner;

import dao.EnseignantDAO;
import model.Enseignant;

public class Enseignant_test {
    public static void main(String[] args) {
        EnseignantDAO dao = new EnseignantDAO();
        Scanner scanner = new Scanner(System.in);
        int choix = 1;

        while (choix != 0) {
            System.out.println("\n===== GESTION DES ENSEIGNANTS =====");
            System.out.println("1. Ajouter un enseignant");
            System.out.println("2. Modifier un enseignant");
            System.out.println("3. Supprimer un enseignant");
            System.out.println("4. Chercher un enseignant");
            System.out.println("5. Lister tous les enseignants");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    System.out.println("\n--- AJOUT D'ENSEIGNANT ---");
                    System.out.print("Nom : ");
                    String nom = scanner.nextLine();
                    System.out.print("Prénom : ");
                    String prenom = scanner.nextLine();
                    System.out.print("Email : ");
                    String email = scanner.nextLine();
                    System.out.print("Spécialité : ");
                    String specialite = scanner.nextLine();
                    Enseignant e = new Enseignant(0, nom, prenom, email, specialite);
                    dao.ajouterEnseignant(e);
                    System.out.println("✅ Enseignant ajouté !");
                    break;
                
                case 2:
                    System.out.print("\nID de l'enseignant à modifier : ");
                    int idm = scanner.nextInt();
                    scanner.nextLine();
                    Enseignant em = dao.rechercherEnseignant(idm);
                    if (em != null) {
                        System.out.print("Nouveau Nom [" + em.getNom() + "] : ");
                        em.setNom(scanner.nextLine());
                        System.out.print("Nouveau Prénom [" + em.getPrenom() + "] : ");
                        em.setPrenom(scanner.nextLine());
                        System.out.print("Nouvel Email [" + em.getEmail() + "] : ");
                        em.setEmail(scanner.nextLine());
                        System.out.print("Nouvelle Spécialité [" + em.getSpecialite() + "] : ");
                        em.setSpecialite(scanner.nextLine());

                        dao.modifierEnseignant(em);
                        System.out.println("✅ Enseignant modifié !");
                    } else {
                        System.out.println("⚠️ Enseignant introuvable !");
                    }
                    break;
                case 3:
                    System.out.print("\nID de l'enseignant à supprimer : ");
                    int ids = scanner.nextInt();
                    scanner.nextLine();
                    dao.supprimerEnseignant(ids);
                    System.out.println("🗑️ Enseignant supprimé !");
                    break;
                case 4:
                    System.out.print("\nID de l'enseignant à chercher : ");
                    int idc = scanner.nextInt();
                    scanner.nextLine();
                    Enseignant ec = dao.rechercherEnseignant(idc);
                    if (ec != null) {
                        System.out.println("\n📌 Enseignant trouvé :");
                        System.out.println(ec.afficher());
                    } else {
                        System.out.println("⚠️ Enseignant introuvable !");
                    }
                    break;
                case 5:
                    System.out.println("\n📚 Liste des enseignants :");
                    List<Enseignant> enseignants = dao.getAllEnseignants();
                    if (enseignants.isEmpty()) {
                        System.out.println("Aucun enseignant trouvé.");
                    } else {
                        for (Enseignant enseignant : enseignants) {
                            System.out.println(enseignant.afficher());
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
