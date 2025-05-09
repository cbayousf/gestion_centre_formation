package php;

import dao.EtudiantDAO;

public class DeleteStudentApp {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("❌ Aucun ID fourni !");
            return;
        }

        try {
            int id = Integer.parseInt(args[0]);
            new EtudiantDAO().supprimerEtudiant(id);
            System.out.println("✅ Étudiant supprimé avec succès.");
        } catch (Exception ex) {
            System.err.println("❌ Erreur lors de la suppression : " + ex.getMessage());
        }
    }
}