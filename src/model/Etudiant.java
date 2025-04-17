package model;

public class Etudiant {
	private int     ID_Etudiant;
	private String  Nom;
	private String  Prenom;
	private String  Email;
	private String  Telephone;

	public	Etudiant(){}
	public	Etudiant(int ID_Etudiant, String	Nom, String Prenom, String Email, String Telephone)
	{
		this.ID_Etudiant = ID_Etudiant;
		this.Nom = Nom;
		this.Prenom = Prenom;
		this.Email = Email;
		this.Telephone = Telephone;
	}
	public	Etudiant(String	Nom, String Prenom, String Email, String Telephone)
	{
		this.Nom = Nom;
		this.Prenom = Prenom;
		this.Email = Email;
		this.Telephone = Telephone;
	}
	public int getID_Etudiant(){ return ID_Etudiant; }
	public String getNom(){ return Nom; }
	public String getPrenom(){ return Prenom; }
	public String getEmail(){ return 	Email; }
	public String getTelephone(){ return Telephone; }

	public void setID_Etudiant(int ID_Etudiant){ this.ID_Etudiant = ID_Etudiant; }
	public void setNom(String Nom){ this.Nom = Nom; }
	public void setPrenom(String Prenom){ this.Prenom = Prenom; }
	public void setEmail(String Email){ this.Email = Email; }
	public void setTelephone(String Telephone){ this.Telephone = Telephone; }

	public String Afficher(){
        return("Etudiant{" +
                "ID_Etudiant=" + ID_Etudiant + 
                ", Nom='" + Nom + '\'' + 
                ", Prenom='" + Prenom + '\'' + 
                ", Email='" + Email + '\'' + 
                ", Telephone='" + Telephone + '\'' +
                '}');
    }
}
