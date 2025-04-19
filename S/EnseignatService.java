package service;
import model.Enseignant;
import dao.EnseignantDAO;
import java.util.List;

public class EnseignantService{
    private EnseignantDAO enseignantDAO;

    public EnseignantService() {
        enseignantDAO = new EnseignantDAO();
    }

    public boolean ajouterEnseignant(Enseignant e){

        List <Enseignant> enseignants = enseignantDAO.getAllEnseignants();
        for(Enseignant ens : enseignants){
            if(ens.getEmail().equalsIgnoreCase(e.getEmail()))
            {
                System.out.println("⚠️ Email déjà utilisé.");
                return false;
            }
        }
        enseignantDAO.ajouterEnseignant(e);
        return true;
    }
    public void modifierEnseignant(int id){
        enseignantDAO.modifierEnseignant(id);
    }

    public void supprimerEnseignant(int id){
        enseignantDAO.supprimerEnseignant(id);
    }

    public Enseignant chercherEnseignant(int id){
        return enseignantDAO.chercherEnseignant(id);
    }

    public List<Enseignant> listerEnseignant(){
        return enseignantDAO.getAllEnseignants();
    }
}