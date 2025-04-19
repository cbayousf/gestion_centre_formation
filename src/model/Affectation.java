package model;
import java.time.LocalDate;

public class Affectation
{
    private int idE;
    private int idEnseignant;
    private int idModule;
    private LocalDate dateAffect;

    public Affectation(){
        this.idE = 0;
        this.idEnseignant = 0;
        this.idModule = 0;
        this.dateAffect = null; 
    }
    public Affectation(int idE, int idEnseignant, int idModule, LocalDate dateAffect){
        this.idE = idE;
        this.idEnseignant = idEnseignant;
        this.idModule = idModule;
        this.dateAffect = dateAffect;
    }

    public int getIdE() {
        return idE;
    }

    public int getIdEnseignant() {
        return idEnseignant;
    }

    public int getIdModule() {
        return idModule;
    }

    public LocalDate getDateAffect() {
        return dateAffect;
    }

    public void setIdE(int idE){
        this.idE = idE;
    }

    public void setIdEnseignant(int idEnseignant) {
        this.idEnseignant = idEnseignant;
    }

    public void setIdModule(int idModule) {
        this.idModule = idModule;
    }
    public void setDateAffect(LocalDate dateAffect){
        this.dateAffect = dateAffect;
    }

    public String afficher(){
        return "Affectation{" +
                "idE = " + idE +
                ", idEnseignant=" + idEnseignant +
                ", idModule=" + idModule +
                ", dateAffect=" + dateAffect +
                '}';
    }
}