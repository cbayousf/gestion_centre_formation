package php;

import dao.CoursDAO;
import model.Cours;

import java.util.List;

public class GetCoursByModuleApp {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Usage: java php.GetCoursByModuleApp <id_module>");
            return;
        }

        int idModule;
        try {
            idModule = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("❌ ID Module invalide.");
            return;
        }

        CoursDAO dao = new CoursDAO();
        List<Cours> coursList = dao.getAllCoursParModule(idModule);

        if (coursList == null || coursList.isEmpty()) {
            System.err.println("❌ Aucun cours trouvé pour ce module.");
            return;
        }

        for (Cours c : coursList) {
            System.out.println(c.getIdCours() + ";" +
                               c.getNomCours() + ";" +
                               c.getDateCours().toString() );
        }
    }
}