package services;

import dao.ModuleDAO;
import model.ModuleFormation;

import java.util.List;

public class ModuleFormationService {
    private ModuleDAO moduleDAO;

    public ModuleFormationService() {
        this.moduleDAO = new ModuleDAO();
    }

    public void ajouterModule(ModuleFormation m) {
        if (m != null)
            moduleDAO.ajouterModule(m);
        else
            System.out.println("❌ Module invalide !");
    }

    public void modifierModule(ModuleFormation m) {
        if (m != null && m.getIdModule() > 0)
            moduleDAO.modifierModule(m);
        else
            System.out.println("❌ Module non valide pour modification.");
    }

    public void supprimerModule(int id) {
        if (id > 0)
            moduleDAO.supprimerModule(id);
        else
            System.out.println("❌ ID de module invalide pour suppression.");
    }

    public ModuleFormation chercherModule(int id) {
        if (id > 0)
            return moduleDAO.chercherModule(id);
        else {
            System.out.println("❌ ID de module invalide pour recherche.");
            return null;
        }
    }

    public List<ModuleFormation> listerModules() {
        return moduleDAO.listerTous();
    }
}
