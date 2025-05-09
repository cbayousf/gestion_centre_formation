package php;

import model.Etudiant;
import dao.EtudiantDAO;

public class GetStudentByIdApp {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("❌ ID non fourni.");
            return;
        }

        try {
            int id = Integer.parseInt(args[0]);
            Etudiant e = new EtudiantDAO().getEtudiantById(id);

            if (e == null) {
                System.err.println("❌ Aucun étudiant trouvé avec cet ID.");
                return;
            }

            System.out.println(e.getID_Etudiant() + ";" +
                               e.getNom() + ";" +
                               e.getPrenom() + ";" +
                               e.getEmail() + ";" +
                               e.getTelephone());
        } catch (Exception ex) {
            System.err.println("❌ Erreur : " + ex.getMessage());
        }
    }
}