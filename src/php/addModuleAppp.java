package php;

import dao.ModuleDAO;
import model.ModuleFormation;

public class addModuleAppp {

    public static void main(String[] args) {
        if (args.length < 3) {
            System.err.println("Erreur : paramètres manquants.");
            System.err.println("Usage: java php.addModuleApp <nom_module> <description> <duree_en_heures>");
            return;
        }

        String nomModule = args[0];
        String description = args[1];

        int duree;
        try {
            duree = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            System.err.println("Erreur : La durée doit être un entier (en heures).");
            return;
        }

        // Création du module
        ModuleFormation module = new ModuleFormation();
        module.setNomModule(nomModule);
        module.setDescription(description);
        module.setDuree(duree);

        // Appel du DAO pour ajouter dans la base
        ModuleDAO dao = new ModuleDAO();
        dao.ajouterModule(module);

        System.out.println("✅ Module ajouté avec succès !");
    }
}