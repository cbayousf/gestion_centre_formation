package services;

import dao.CoursDAO;
import dao.AffectationDAO;
import model.Cours;
import model.Affectation;
import java.util.List;

public class CoursService {
    private CoursDAO coursDAO;
    private AffectationDAO affectationDAO;

    public CoursService(){
        coursDAO = new CoursDAO();
        affectationDAO = new AffectationDAO();
    }

    public boolean ajouterCours(Cours cours){
        List<Affectation> affectations = affectationDAO.getAllAffectations();
        boolean enseignantAffecte = false;
        for(Affectation affect : affectations){


        }
        coursDAO.ajouterCours(cours);
        return true;
    }
    public boolean modifierCours(Cours cours) {
        return coursDAO.modifierCours(cours);
    }
    public Cours chercherCours(int id){
        return coursDAO.rechercherCours(id);
    }
    public boolean supprimerCours(int id){
        return coursDAO.supprimerCours(id);
    }
    public List<Cours> listerCours(){
        return coursDAO.getAllCours();
    }
}
