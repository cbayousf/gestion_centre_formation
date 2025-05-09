package php;

import dao.EnseignantDAO;
import model.Enseignant;

import java.util.List;

public class ListProfApp {
    public static void main(String[] args) {
        EnseignantDAO dao = new EnseignantDAO();
        List<Enseignant> enseignant = dao.getAllEnseignants();

        if (enseignant == null || enseignant.isEmpty()) {
            System.err.println("❌ Aucun enseignant trouvé.");
            return;
        }

        for (Enseignant m : enseignant) {
            System.out.println(m.getIdEnseignant() + ";" +
                               m.getNom() + ";" +
                               m.getPrenom() + ";" +
                               m.getEmail() + ";" +
                               m.getSpecialite());
        }
    }
}