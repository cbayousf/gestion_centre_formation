package services;
import model.Enseignant;
import dao.EnseignantDAO;
import java.util.List;

public class EnseignantService{
    private EnseignantDAO enseignantDAO;

    public EnseignantService() {
        enseignantDAO = new EnseignantDAO();
    }

    public void ajouterEnseignant(Enseignant e){

        List <Enseignant> enseignants = enseignantDAO.getAllEnseignants();
        for(Enseignant ens : enseignants){
            if(ens.getEmail().equalsIgnoreCase(e.getEmail()))
            {
                System.out.println("⚠️ Email déjà utilisé.");
            }
        }
        else{
            enseignantDAO.ajouterEnseignant(e);
            System.out.println("✅ Enseignant ajouté avec succès !");
        }
    }
    public void modifierEnseignant(Enseignant e){
        if (e != null && e.getIdEnseignant() > 0) {
            enseignantDAO.modifierEnseignant(e);
            System.out.println("✅ Enseignant modifié avec succès !");
        } else{
            System.out.println("❌ Enseignant invalide pour modification.");
        }
    }

    public void supprimerEnseignant(int id){
        if (id > 0){
            enseignantDAO.supprimerEnseignant(id);
            System.out.println("✅ Enseignant supprimé avec succès !");
        } else{
            System.out.println("❌ Enseignant invalide pour modification.");
        }
    }
    public Enseignant chercherEnseignant(int id){
        if (id > 0){
            return enseignantDAO.rechercherEnseignant(id);
        } else{
            System.out.println("❌ ID d'enseignant invalide pour recherche.");
            return null;
        }
    }
    public List<Enseignant> listerEnseignant(){
        return enseignantDAO.getAllEnseignants();
    }
}