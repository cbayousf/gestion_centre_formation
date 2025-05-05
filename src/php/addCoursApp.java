package php;

import dao.CoursDAO;
import model.Cours;

import java.time.LocalDate;

public class addCoursApp {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.err.println("Erreur : paramètres manquants.");
            System.err.println("Usage: java php.addCoursApp <nom_cours> <date_cours(YYYY-MM-DD)> <id_module>");
            return;
        }

        String nomCours = args[0];
        int idModule;

        try {
            idModule = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            System.err.println("Erreur : ID_Module doit être un entier.");
            return;
        }

        LocalDate dateCours;
        try {
            dateCours = LocalDate.parse(args[1]); // Format attendu : YYYY-MM-DD
        } catch (Exception e) {
            System.err.println("Erreur : La date doit être au format YYYY-MM-DD");
            return;
        }

        Cours cours = new Cours(nomCours, dateCours, idModule);
        CoursDAO dao = new CoursDAO();
         dao.ajouterCours(cours);

    }
}