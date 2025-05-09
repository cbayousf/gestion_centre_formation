package php;

import dao.EtudiantDAO;
import model.Etudiant;

import java.util.List;

public class ListEtudiantApp {

    public static void main(String[] args) {
        EtudiantDAO dao = new EtudiantDAO();
        List<Etudiant> etudiants = dao.listerTous();

        if (etudiants == null || etudiants.isEmpty()) {
            System.err.println("❌ Aucun etudiants trouvé.");
            return;
        }

        for (Etudiant m : etudiants) {
            System.out.println(m.getID_Etudiant() + ";" +
                               m.getNom() + ";" +
                               m.getPrenom() + ";" +
                               m.getEmail() + ";" +
                               m.getTelephone());
        }
    }
}