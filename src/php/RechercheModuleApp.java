package php;

import model.ModuleFormation;
import dao.ModuleDAO;

public class RechercheModuleApp {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Erreur : aucun terme de recherche fourni.");
            System.exit(1);
        }

        String nomModule = args[0];
        ModuleDAO moduleDAO = new ModuleDAO();
        ModuleFormation module = moduleDAO.chercherModuleParNom(nomModule);

        if (module != null) {
            System.out.println("Module trouvé :");
            System.out.println("ID :" + module.getIdModule());
            System.out.println("Nom :" + module.getNomModule());
            System.out.println("Description :" + module.getDescription());
            System.out.println("Durée :" + module.getDuree() + " heures");

            // ✅ Sortie avec succès
            System.exit(0);
        } else {
            System.err.println("Aucun module trouvé pour « " + nomModule + " ».");
            // ❌ Sortie erreur
            System.exit(1);
        }
    }
}