package services;

import dao.AffectationDAO;
import dao.EnseignantDAO;
import dao.ModuleDAO;
import model.Affectation;
import model.EnseignantDAO;
import model.ModuleDAO;

import java.util.List;

public class AffectationService { 
    private AffectationDAO affectationDAO;
    private EnseignantDAO enseignantDAO;
    private ModuleDAO moduleDAO;


    public AffectationService(){
        this.affectationDAO = new AffectationDAO();
        this.enseignantDAO = new EnseignantDAO();
        this.moduleDAO = new ModuleDAO();


    }
    public void ajouterAffectation(Affectation affectation){
        if(affectation != null && affectation.getIdEnseignant() > 0 && affectation.getIdModule() > 0){
            Enseignant enseignant = rechercherEnseignant(affectation.getIdEnseignant());
            Module module =  chercherModule(affectation.getIdModule());
            if(enseignant != null & module != null)
            {
                affectationDAO.ajouterAffectation(affectation);
                System.out.println("✅ Affectation réussie !");
            }
            else{
                System.out.println("❌ Enseignant ou module introuvable.");
            }
        }
        else{
            System.out.println("❌ Données d'affectation invalides.");
        }
    }
    public void modifierAffectation(Affectation affectation){
        if(affectation != null && affectation.getIdE() > 0){
             affectationDAO.modifierAffectation(affectation);
        }
        else{
             System.out.println("❌ Affectation invalide pour modification.");
        }
    }
    public Affectation rechercherAffectation(int idE){
        if(idE > 0){
            return affectationDAO.rechercherAffectation(idE);
        } else{
            System.out.println("❌ ID d'affectation invalide pour recherche.");
            return null;
        }
    }
    public void supprimerAffectation(int idE){
        if(idE > 0){
             affectationDAO.supprimerAffectation(idE);
        }
        else{
            System.out.println("❌ ID d'affectation invalide pour suppression.");

        }
    }
    public List<Affectation> ListerAffectationsParEnseignant(int idEnseignant) {
        return affectationDAO.getAllAffectations().stream()
                .filter(a -> a.getIdEnseignant() == idEnseignant)
                .collect(Collectors.toList()); 

    public List<Affectation> ListerAffectationsParModule(int idModule) {
        return affectationDAO.getAllAffectations().stream()
                .filter(a -> a.getIdModule() == idModule) 
                .collect(Collectors.toList());
    }
}