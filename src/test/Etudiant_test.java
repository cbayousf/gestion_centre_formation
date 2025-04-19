package test;

import java.util.List;
import java.util.Scanner;

import dao.EtudiantDAO;
import model.Etudiant;

public class Etudiant_test {
    public static void main(String[] args){
        EtudiantDAO dao = new EtudiantDAO();
        Scanner scanner = new Scanner(System.in);
        int choix = 1;
        while(choix != 0)
        {
            System.out.println("\n===== GESTION DES ÉTUDIANTS =====");
            System.out.println("1. Ajouter un étudiant");
            System.out.println("2. Modifier un étudiant");
            System.out.println("3. Supprimer un étudiant");
            System.out.println("4. Chercher un étudiant");
            System.out.println("5. Lister tous les étudiants");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine();
            switch (choix) {
                case 1:
                    System.out.println("\n--- AJOUT D'ÉTUDIANT ---");
                    System.out.print("Nom : ");
                    String nom = scanner.nextLine();
                    System.out.print("Prenom : ");
                    String prenom = scanner.nextLine();
                    System.out.print("Email : ");
                    String email = scanner.nextLine();
                    System.out.print("Téléphone : ");
                    String telephone = scanner.nextLine();
                    Etudiant e = new Etudiant(nom,prenom,email,telephone);
                    dao.ajouterEtudiant(e);
                    System.out.println("✅ Étudiant ajouté !");
                    break;
                case 2 :
                    System.out.print("\nID de l'étudiant à modifier : ");
                    int idm = scanner.nextInt();
                    scanner.nextLine();
                    Etudiant em = dao.chercherEtudiant(idm);
                    if (em != null)
                    {
                        System.out.print("Nouveau Nom [ "+em.getNom()+" ]: ");
                        em.setNom(scanner.nextLine());
                        System.out.print("Nouveau Prenom [ "+em.getPrenom()+" ]: ");
                        em.setPrenom(scanner.nextLine());
                        System.out.print("Nouveau Email [ "+em.getEmail()+" ]: ");
                        em.setEmail(scanner.nextLine());
                        System.out.print("Nouveau Nom [ "+em.getTelephone()+" ]: ");
                        em.setTelephone(scanner.nextLine());

                        dao.modifierEtudiant(em);
                        System.out.println("✅ Étudiant ajouté !");
                    }
                    else{
                        System.out.println("⚠️ Étudiant introuvable !");
                    }
                    break;
                case 3 :
                    System.out.print("\nID de l'étudiant à Supprimer : ");
                    int ids = scanner.nextInt();
                    scanner.nextLine();
                    dao.supprimerEtudiant(ids);
                    System.err.println("🗑️ Étudiant supprimé !");
                    break;
                case 4 :
                    System.out.print("\nID de l'étudiant à Chercher : ");
                    int idc = scanner.nextInt();
                    Etudiant ec = dao.chercherEtudiant(idc);
                    if (ec != null)
                    {
                        System.out.println("\n📌 Étudiant trouvé :");
                        ec.Afficher();
                    }
                    else{
                        System.out.println("⚠️ Étudiant introuvable !");
                    }
                    break;
                case 5 :
                    System.out.println("\n📚 Liste des étudiants :");
                    List<Etudiant> list = dao.listerTous();
                    for ( Etudiant el : list){
                        el.Afficher();
                    }
                    break;
                case 0 :
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
