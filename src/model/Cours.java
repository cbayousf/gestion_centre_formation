package model;
import java.time.LocalDate;

public class Cours{
    private int idCours;
    private String nomCours;
    private LocalDate dateCours;
    private int idModule;

    public Cours(){
        this.idCours = 0;
        this.nomCours = "";
        this.dateCours = null;
        this.idModule = 0;
    }
    public Cours(int idCours, String nomCours, LocalDate dateCours, int idModule){
        this.idCours = idCours;
        this.nomCours = nomCours;
        this.dateCours = dateCours;
        this.idModule = idModule;
    }

    public int getIdCours(){
        return idCours;
    }
    public LocalDate getDateCours(){
        return dateCours;
    }
    public int getIdModule() {
        return idModule;
    }
    
    public String getNomCours() {
        return nomCours;
    }

    public void setIdCours(int idCours) {
        this.idCours = idCours;
    }
    public void setDateCours(LocalDate  dateCours){
        this.dateCours = dateCours;
    }
    public void setIdModule(int idModule) {
        this.idModule = idModule;
    }
    
    public void setNomCours(String nomCours) {
        this.nomCours = nomCours;
    }

    public String afficher(){
        return "Cours{" +
                "idCours=" + idCours +
                ", nomCours='" + nomCours + '\'' +
                ", dateCours=" + dateCours +
                ", idModule=" + idModule +
                '}';
    }
    
}