package services;

import java.util.List;

import dao.EtudiantDAO;
import model.Etudiant;

public class EtudiantService {
    private EtudiantDAO etudiantDAO;

    public EtudiantService(){
        this.etudiantDAO = new EtudiantDAO();
    }
    public void ajouterEtudiant(Etudiant e){
        if (e != null) {
            etudiantDAO.ajouterEtudiant(e);
        } else {
            System.out.println("Étudiant invalide ❌");
        }
    }
    public void modifierEtudiant(Etudiant e){
        if (e != null && e.getID_Etudiant() > 0) {
            etudiantDAO.modifierEtudiant(e);
        } else {
            System.out.println("Étudiant à modifier invalide ❌");
        }
    }
    public void supprimerEtudiant(int id){
        if (id > 0) {
            etudiantDAO.supprimerEtudiant(id);
        } else {
            System.out.println("ID invalide pour suppression ❌");
        }
    }
    public Etudiant chercherEtudiant(int id){
        if (id > 0) {
            return etudiantDAO.chercherEtudiant(id);
        }
        return null;
    }
    public List<Etudiant> listerTous(){
        return etudiantDAO.listerTous();
    }
}
