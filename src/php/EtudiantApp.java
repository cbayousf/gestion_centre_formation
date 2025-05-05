package php;
import dao.EtudiantDAO;
import model.Etudiant;
public class EtudiantApp {
    public static void main(String[] args) {
        if (args.length < 4) {
            System.err.println("Erreur : paramètres manquants.");
            return;
        }

        String nom = args[0];
        String prenom = args[1];
        String email = args[2];
        String telephone = args[3];

        Etudiant e = new Etudiant(nom, prenom, email, telephone);
        EtudiantDAO dao = new EtudiantDAO();
        dao.ajouterEtudiant(e);
    }
}
