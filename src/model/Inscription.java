package model;

import java.time.LocalDate;

public class Inscription {
    private int     ID_Inscription;
	private String  Statut;
	private int		ID_Etudiant;
	private int		ID_Module;
	private LocalDate	Date_Inscription;

	public	Inscription(){}
	public	Inscription(int	ID_Inscription,String	Statut, int ID_Etudiant, int ID_Module, LocalDate Date_Inscription)
	{
		this.ID_Inscription = ID_Inscription;
		this.Statut = Statut;
		this.ID_Etudiant = ID_Etudiant;
		this.ID_Module = ID_Module;
		this.Date_Inscription = Date_Inscription;
	}
	public	Inscription(String	Statut, int ID_Etudiant, int ID_Module, LocalDate Date_Inscription)
	{
		this.Statut = Statut;
		this.ID_Etudiant = ID_Etudiant;
		this.ID_Module = ID_Module;
		this.Date_Inscription = Date_Inscription;
	}
	public int getID_Inscription(){ return ID_Inscription; }
	public String getStatut(){ return Statut; }
	public int getID_Etudiant(){ return ID_Etudiant; }
	public int getID_Module(){ return 	ID_Module; }
	public LocalDate getDate_Inscription(){ return Date_Inscription; }

	public void setID_Inscription(int ID_Inscription){ this.ID_Inscription = ID_Inscription; }
	public void setStatut(String Statut){ this.Statut = Statut; }
	public void setID_Etudiant(int ID_Etudiant){ this.ID_Etudiant = ID_Etudiant; }
	public void setID_Module(int ID_Module){ this.ID_Module = ID_Module; }
	public void setDate_Inscription(LocalDate Date_Inscription){ this.Date_Inscription = Date_Inscription; }

	public String Afficher(){
        return("Inscription{" +
                "ID_Inscription=" + ID_Inscription + 
                ", Statut='" + Statut + '\'' + 
                ", ID_Etudiant='" + ID_Etudiant + '\'' + 
                ", ID_Module='" + ID_Module + '\'' + 
                ", Date_Inscription='" + Date_Inscription + '\'' +
                '}');
    }
}
