package php;

import dao.CoursDAO;
import model.Cours;

import java.util.List;

public class GetCoursByModuleApp {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("-1;Erreur;ID non fourni;0");
            return;
        }

        int idModule;
        try {
            idModule = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("-1;Erreur;ID invalide;0");
            return;
        }

        CoursDAO dao = new CoursDAO();
        List<Cours> coursList = dao.getAllCoursParModule(idModule);

        if (coursList == null || coursList.isEmpty()) {
            System.out.println("-1;Aucun cours;Non trouvé;0");
            return;
        }

        for (Cours c : coursList) {
            System.out.println(c.getIdCours() + ";" +
                               c.getNomCours() + ";" +
                               c.getDateCours().toString() + ";" +
                               c.getIdModule());
        }
    }
}