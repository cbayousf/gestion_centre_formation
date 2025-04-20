package services;

import dao.CoursDAO;
import dao.ModuleDAO;
import model.Cours;
import model.ModuleFormation;
import java.util.List;
import java.util.stream.Collectors;

public class CoursService {
    private CoursDAO coursDAO;
    private ModuleDAO moduleDAO;

    public CoursService(){
        coursDAO = new CoursDAO();
        moduleDAO = new ModuleDAO();
    }
    public void ajouterCours(Cours cours){
        if (cours != null && cours.getIdModule() > 0) {
            ModuleFormation module = moduleDAO.chercherModule(cours.getIdModule());
            if(module != null){
                coursDAO.ajouterCours(cours);
                System.out.println("✅ Cours ajouté avec succès !");
            }
            else{
                System.out.println("❌ Module introuvable.");
            }
        }
        else{
            System.out.println("❌ Données du cours invalides.");
        }
    }
    public void modifierCours(Cours cours) {
        if(cours != null && cours.getIdCours() > 0){
            coursDAO.modifierCours(cours);
            System.out.println("✅ Cours modifié avec succès !");
        }else{
            System.out.println("❌ Cours invalide pour modification.");
        }
    }
    public Cours chercherCours(int id){
        if (id > 0){
            return coursDAO.rechercherCours(id);
        }else{
            System.out.println("❌ ID de cours invalide pour recherche.");
            return null;
        }
    }
    public void supprimerCours(int id){
        if (id > 0){
            coursDAO.supprimerCours(id);
            System.out.println("✅ Cours supprimé avec succès !");
        }else{
            System.out.println("❌ ID de cours invalide pour suppression.");
        }
    }
    public List<Cours> listerCoursParModule(int idModule){
        return coursDAO.getAllCours();
    }
}
