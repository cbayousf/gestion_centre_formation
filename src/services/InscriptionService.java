package services;

import java.util.List;

import dao.EtudiantDAO;
import dao.InscriptionDAO;
import dao.ModuleDAO;
import model.Etudiant;
import model.Inscription;
import model.ModuleFormation;

public class InscriptionService {
    private InscriptionDAO inscriptionDAO;
    private EtudiantDAO etudiantDAO;
    private ModuleDAO moduleDAO;

    public InscriptionService(){
        this.inscriptionDAO = new InscriptionDAO();
        this.etudiantDAO = new EtudiantDAO();
        this.moduleDAO = new ModuleDAO();
    }
    public void inscrireEtudiant(Inscription i){
        if (i != null && i.getID_Etudiant()>0 && i.getID_Module()>0)
        {
            Etudiant e = etudiantDAO.chercherEtudiant(i.getID_Etudiant());
            ModuleFormation m = moduleDAO.chercherModule(i.getID_Module());
            if (e != null && m != null) {
                inscriptionDAO.inscrireEtudiant(i);
                System.out.println("✅ Inscription réussie !");
            } else {
                System.out.println("❌ Étudiant ou module introuvable.");
            }
        } else {
            System.out.println("❌ Données d'inscription invalides.");
        }
    }
    public void modifierInscription(Inscription i)
    {
        if (i != null && i.getID_Inscription() > 0) {
            inscriptionDAO.modifierInscription(i);
        } else {
            System.out.println("❌ Inscription invalide pour modification.");
        }
    }
    public void annulerInscription(int id) {
        if (id > 0) {
            inscriptionDAO.annulerInscription(id);
        } else {
            System.out.println("❌ ID d'inscription invalide pour annulation.");
        }
    }
    public List<Inscription> getInscriptionsParEtudiant(int idEtudiant) {
        return inscriptionDAO.listerInscriptionsParEtudiant(idEtudiant);
    }
    public List<Inscription> getInscriptionsParModule(int idModule) {
        return inscriptionDAO.listerInscriptionsParModule(idModule);
    }
}
