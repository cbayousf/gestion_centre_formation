package model;

public class Enseignant {
    private int idEnseignant;
    private String nom;
    private String prenom;
    private String email;
    private String specialite;

    public Enseignant() {
        this.idEnseignant = 0;
        this.nom = "";
        this.prenom = "";
        this.email = "";
        this.specialite = "";
    }
    public Enseignant(int idEnseignant, String nom, String prenom, String email, String specialite) {
        this.idEnseignant = idEnseignant;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.specialite = specialite;
    }
    public int getIdEnseignant() {
        return idEnseignant;
    }
    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public String getEmail() {
        return email;
    }
    public String getSpecialite() {
        return specialite;
    }
    public void setIdEnseignant(int idEnseignant) {
        this.idEnseignant = idEnseignant;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public void setEmail(String email) {
            this.email = email;
    }
    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String afficher(){
        return("Enseignat{" +
                "idEnseignant=" + idEnseignant + 
                ", nom='" + nom + '\'' + 
                ", prenom='" + prenom + '\'' + 
                ", email='" + email + '\'' + 
                ", specialite='" + specialite + '\'' +
                '}');
    }
}
