package test;

import java.util.List;
import java.util.Scanner;

import dao.AffectationDAO;
import model.Affectation;

public class Affectation_test {
    public static void main(String[] args) {
        AffectationDAO dao = new AffectationDAO();
        Scanner scanner = new Scanner(System.in);
        int choix = 1;

        while (choix != 0) {
            System.out.println("\n===== GESTION DES AFFECTATIONS =====");
            System.out.println("1. Ajouter une affectation");
            System.out.println("2. Modifier une affectation");
            System.out.println("3. Supprimer une affectation");
            System.out.println("4. Chercher une affectation");
            System.out.println("5. Lister toutes les affectations");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    System.out.println("\n--- AJOUT D'UNE AFFECTATION ---");
                    System.out.print("ID Enseignant : ");
                    int idEns = scanner.nextInt();
                    System.out.print("ID Module : ");
                    int idMod = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Date d'affectation (YYYY-MM-DD) : ");
                    String dateAffect = scanner.nextLine();

                    Affectation a = new Affectation(0, idEns, idMod, dateAffect);
                    boolean added = dao.ajouterAffectation(a);
                    System.out.println(added ? "✅ Affectation ajoutée !" : "❌ Erreur lors de l'ajout.");
                    break;

                case 2:
                    System.out.print("\nID de l'affectation à modifier : ");
                    int idm = scanner.nextInt();
                    scanner.nextLine();
                    Affectation am = dao.rechercherAffectation(idm);
                    if (am != null) {
                        System.out.print("Nouvel ID Enseignant [" + am.getIdEnseignant() + "] : ");
                        am.setIdEnseignant(scanner.nextInt());
                        System.out.print("Nouvel ID Module [" + am.getIdModule() + "] : ");
                        am.setIdModule(scanner.nextInt());
                        scanner.nextLine();
                        System.out.print("Nouvelle date d'affectation [" + am.getDateAffect() + "] : ");
                        am.setDateAffect(scanner.nextLine());

                        boolean updated = dao.modifierAffectation(am);
                        System.out.println(updated ? "✅ Affectation modifiée !" : "❌ Erreur lors de la modification.");
                    } else {
                        System.out.println("⚠️ Affectation introuvable !");
                    }
                    break;

                case 3:
                    System.out.print("\nID de l'affectation à supprimer : ");
                    int ids = scanner.nextInt();
                    scanner.nextLine();
                    boolean deleted = dao.supprimerAffectation(ids);
                    System.out.println(deleted ? "🗑️ Affectation supprimée !" : "⚠️ Erreur lors de la suppression.");
                    break;

                case 4:
                    System.out.print("\nID de l'affectation à chercher : ");
                    int idc = scanner.nextInt();
                    scanner.nextLine();
                    Affectation ac = dao.rechercherAffectation(idc);
                    if (ac != null) {
                        System.out.println("\n📌 Affectation trouvée :");
                        System.out.println(ac.afficher());
                    } else {
                        System.out.println("⚠️ Affectation introuvable !");
                    }
                    break;

                case 5:
                    System.out.println("\n📚 Liste des affectations :");
                    List<Affectation> affectations = dao.getAllAffectation();
                    if (affectations.isEmpty()) {
                        System.out.println("Aucune affectation trouvée.");
                    } else {
                        for (Affectation aff : affectations) {
                            System.out.println(aff.afficher());
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
