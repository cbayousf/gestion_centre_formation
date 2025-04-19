package test;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import dao.InscriptionDAO;
import model.Inscription;

public class Inscription_test {
    public static void main(String[] args) {
        InscriptionDAO dao = new InscriptionDAO();
        Scanner scanner = new Scanner(System.in);
        int choix = 1;

        while (choix != 0) {
            System.out.println("\n===== GESTION DES INSCRIPTIONS =====");
            System.out.println("1. Inscrire un étudiant");
            System.out.println("2. Modifier une inscription");
            System.out.println("3. Annuler une inscription");
            System.out.println("4. Lister les inscriptions par étudiant");
            System.out.println("5. Lister les inscriptions par module");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");

            choix = scanner.nextInt();
            scanner.nextLine(); // ⚠️ Pour vider le tampon après nextInt()

            switch (choix) {
                case 1:
                    System.out.println("\n--- Inscrire un étudiant ---");
                    System.out.print("Statut : ");
                    String statut = scanner.nextLine();

                    System.out.print("ID Étudiant : ");
                    int idEtudiant = scanner.nextInt();

                    System.out.print("ID Module : ");
                    int idModule = scanner.nextInt();
                    scanner.nextLine(); // vider le tampon

                    System.out.print("Date d'inscription (AAAA-MM-JJ) : ");
                    String dateStr = scanner.nextLine();
                    LocalDate date = LocalDate.parse(dateStr);

                    Inscription inscription = new Inscription(statut, idEtudiant, idModule, date);
                    dao.inscrireEtudiant(inscription);
                    System.out.println("✅ Étudiant inscrit !");
                    break;

                case 2:
                    System.out.print("\nID de l'inscription à modifier : ");
                    int idInscription = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Nouveau statut : ");
                    String nouveauStatut = scanner.nextLine();

                    System.out.print("ID Étudiant : ");
                    int newIdEtudiant = scanner.nextInt();

                    System.out.print("ID Module : ");
                    int newIdModule = scanner.nextInt();
                    scanner.nextLine(); // vider le tampon

                    System.out.print("Nouvelle date (AAAA-MM-JJ) : ");
                    String newDateStr = scanner.nextLine();
                    LocalDate newDate = LocalDate.parse(newDateStr);

                    Inscription inscriptionModifiee = new Inscription(idInscription, nouveauStatut, newIdEtudiant, newIdModule, newDate);
                    dao.modifierInscription(inscriptionModifiee);
                    System.out.println("✅ Inscription modifiée !");
                    break;

                case 3:
                    System.out.print("ID de l'inscription à annuler : ");
                    int idSupp = scanner.nextInt();
                    dao.annulerInscription(idSupp);
                    System.out.println("✅ Inscription annulée !");
                    break;

                case 4:
                    System.out.print("ID Étudiant : ");
                    int idE = scanner.nextInt();
                    List<Inscription> listE = dao.listerInscriptionsParEtudiant(idE);
                    for (Inscription iE : listE)
                        iE.Afficher();
                    break;

                case 5:
                    System.out.print("ID Module : ");
                    int idM = scanner.nextInt();
                    List<Inscription> list = dao.listerInscriptionsParModule(idM);
                    for (Inscription iM : list)
                        iM.Afficher();
                    break;

                case 0:
                    System.out.println("👋 Fin du programme.");
                    break;

                default:
                    System.out.println("❌ Choix invalide !");
                    break;
            }
        }

        scanner.close();
    }
}
