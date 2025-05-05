package php;

import dao.CoursDAO;
import model.Cours;

public class GetCoursApp {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Usage: java php.GetCoursApp <id_cours>");
            return;
        }

        int idCours;
        try {
            idCours = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("Erreur : ID invalide.");
            return;
        }

        CoursDAO dao = new CoursDAO();
        Cours cours = dao.rechercherCours(idCours);

        if (cours != null) {
            System.out.println(cours.getIdCours());
            System.out.println(cours.getNomCours());
            System.out.println(cours.getDateCours());
            System.out.println(cours.getIdModule());
        } else {
            System.err.println("❌ Aucun cours trouvé avec cet ID.");
        }
    }
}