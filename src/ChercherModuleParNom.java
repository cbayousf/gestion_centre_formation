import dao.ModuleDAO;
import model.ModuleFormation;

public class ChercherModuleParNom {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Veuillez fournir un nom de module.");
            return;
        }

        String nomModule = args[0];
        ModuleDAO dao = new ModuleDAO();
        ModuleFormation module = dao.chercherModuleParNom(nomModule);

        if (module != null) {
            System.out.println("ID : " + module.getIdModule());
            System.out.println("Nom : " + module.getNomModule());
            System.out.println("Description : " + module.getDescription());
            System.out.println("Durée : " + module.getDuree() + " heures");
        } else {
            System.out.println("Aucun module trouvé avec le nom : " + nomModule);
        }
    }
}
