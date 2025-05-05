package php;

import dao.CoursDAO;
import model.Cours;

import java.time.LocalDate;

public class UpdateCoursApp {
    public static void main(String[] args) {
        if (args.length < 4) {
            System.err.println("Usage: java php.UpdateCoursApp <id_cours> <nom_cours> <date_cours> <id_module>");
            return;
        }

        int idCours;
        int idModule;

        try {
            idCours = Integer.parseInt(args[0]);
            idModule = Integer.parseInt(args[3]);
        } catch (NumberFormatException e) {
            System.err.println("Erreur : ID doit être un entier.");
            return;
        }

        String nomCours = args[1];
        LocalDate dateCours;

        try {
            dateCours = LocalDate.parse(args[2]); // Format attendu YYYY-MM-DD
        } catch (Exception e) {
            System.err.println("Erreur : La date doit être au format YYYY-MM-DD");
            return;
        }

        Cours cours = new Cours(idCours, nomCours, dateCours, idModule);
        CoursDAO dao = new CoursDAO();
        dao.modifierCours(cours);

        System.out.println("✅ Cours mis à jour avec succès !");
    }
}