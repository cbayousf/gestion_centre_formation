package php;

import dao.ModuleDAO;
import model.ModuleFormation;

import java.util.List;

public class ListModulesApp {
    public static void main(String[] args) {
        ModuleDAO dao = new ModuleDAO();
        List<ModuleFormation> modules = dao.listerTous();

        if (modules == null || modules.isEmpty()) {
            System.err.println("❌ Aucun module trouvé.");
            return;
        }

        for (ModuleFormation m : modules) {
            System.out.println(m.getIdModule() + ";" +
                               m.getNomModule() + ";" +
                               m.getDescription() + ";" +
                               m.getDuree());
        }
    }
}