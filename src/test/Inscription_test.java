package test;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import dao.InscriptionDAO;
import model.Inscription;

public class Inscription_test {
    public static void main(String[] args)
    {
        InscriptionDAO dao = new InscriptionDAO();
        Scanner scanner = new Scanner(System.in);
        int choix = 1;
        while (choix != 0) {
            System.out.println("\n===== GESTION DES Inscription =====");
            System.out.println("1 . Inscrire un Etudiant");
            System.out.println("2 . Modifier une Inscription");
            System.out.println("3 . Annuler une Inscription");
            System.out.println("4 . Lister les Inscriptions Par Etudiant");
            System.out.println("5 . Modifier une Inscription");
            System.out.println("0 . Modifier une Inscription");
            System.out.print("votre choix : ");
            choix = scanner.nextInt();
            switch (choix) {
                case 1:
                    System.out.println("\n---Inscrire un Etudiant ---");
                    System.out.print("statut :");
                    String statut = scanner.nextLine();
                    System.out.print("ID_Etudiant : ");
                    int id_e = scanner.nextInt();
                    System.out.print("ID_Module : ");
                    int id_m = scanner.nextInt();
                    System.out.print("Date_Inscription (format AAAA-MM-JJ) : ");
                    String datestr = scanner.nextLine();
                    LocalDate date = LocalDate.parse(datestr);
                    Inscription i = new  Inscription(statut,id_e,id_m,date);
                    dao.inscrireEtudiant(i);
                    System.out.println("✅ Étudiant inscrit !");
                    break;
                case 2:
                    System.out.println("\nID de l'inscription à modifier :");
                    int id_i = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Nouveau statut :");
                    String nstatut = scanner.nextLine();
                    System.out.print("ID Étudiant : ");
                    int newIdEtudiant = scanner.nextInt();
                    System.out.print("ID Module : ");
                    int newIdModule = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nouvelle date (yyyy-mm-dd) : ");
                    String newDateStr = scanner.nextLine();
                    LocalDate newDate = LocalDate.parse(newDateStr);

                    Inscription im = new Inscription(nstatut, newIdEtudiant, newIdModule, newDate);
                    dao.modifierInscription(im);
                    System.out.println("✅ Inscription modifiée !");
                    break;
                case 3:
                    System.out.print("ID Inscription à annuler : ");
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
                case 5 :
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
