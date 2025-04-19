package test;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import dao.CertificatDAO;
import model.Certificat;

public class Certificat_test {
    public static void main(String[] args) {
        CertificatDAO dao = new CertificatDAO();
        Scanner scanner = new Scanner(System.in);
        int choix = 1;

        while (choix != 0) {
            System.out.println("\n===== GESTION DES CERTIFICATS =====");
            System.out.println("1. Générer un certificat");
            System.out.println("2. Lister les certificats par étudiant");
            System.out.println("3. Lister les certificats par module");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    System.out.println("\n--- GÉNÉRATION D'UN CERTIFICAT ---");
                    System.out.print("Date de génération (YYYY-MM-DD) : ");
                    String dateInput = scanner.nextLine();
                    LocalDate dateGeneration = LocalDate.parse(dateInput);

                    System.out.print("ID de l'étudiant : ");
                    int idEtudiant = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("ID du module : ");
                    int idModule = scanner.nextInt();
                    scanner.nextLine();

                    Certificat certificat = new Certificat(0, dateGeneration, idEtudiant, idModule); // Assuming ID is auto-generated
                    dao.genererCertificat(certificat);
                    System.out.println("Certificat généré !");
                    break;

                case 2:
                    System.out.print("\nID de l'étudiant pour lister les certificats : ");
                    int idEtu = scanner.nextInt();
                    scanner.nextLine();

                    List<Certificat> certificatsParEtudiant = dao.listerParEtudiant(idEtu);
                    if (certificatsParEtudiant.isEmpty()) {
                        System.out.println("Aucun certificat trouvé pour cet étudiant.");
                    } else {
                        System.out.println("\nCertificats pour l'étudiant ID " + idEtu + " :");
                        for (Certificat cert : certificatsParEtudiant) {
                            cert.afficher();
                        }
                    }
                    break;

                case 3:
                    System.out.print("\nID du module pour lister les certificats : ");
                    int idMod = scanner.nextInt();
                    scanner.nextLine();

                    List<Certificat> certificatsParModule = dao.listerParModule(idMod);
                    if (certificatsParModule.isEmpty()) {
                        System.out.println("⚠️ Aucun certificat trouvé pour ce module.");
                    } else {
                        System.out.println("\nCertificats pour le module ID " + idMod + " :");
                        for (Certificat cert : certificatsParModule) {
                            cert.afficher();
                        }
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