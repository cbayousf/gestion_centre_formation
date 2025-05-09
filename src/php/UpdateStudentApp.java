package php;

import model.Etudiant;
import dao.EtudiantDAO;

public class UpdateStudentApp {
    public static void main(String[] args) {
        if (args.length < 5) {
            System.err.println("❌ Pas assez d'arguments !");
            return;
        }

        try {
            int id = Integer.parseInt(args[0]);
            String nom = args[1];
            String prenom = args[2];
            String email = args[3];
            String telephone = args[4];

            Etudiant e = new Etudiant(id, nom, prenom, email, telephone);
            new EtudiantDAO().modifierEtudiant(e);

            System.out.println("✅ Étudiant mis à jour avec succès.");
        } catch (Exception ex) {
            System.err.println("❌ Erreur lors de la mise à jour : " + ex.getMessage());
        }
    }
}