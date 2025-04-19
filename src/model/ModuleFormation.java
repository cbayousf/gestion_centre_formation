package model;

public class ModuleFormation {
    private int idModule;
    private String nomModule;
    private String description;
    private int duree;

    public ModuleFormation() {}
    public ModuleFormation(int idModule, String nomModule, String description, int duree)
    {
        this.idModule = idModule;
        this.nomModule = nomModule;
        this.description = description;
        this.duree = duree;
    }

    public int getIdModule() {return idModule;}
    public String getNomModule() {return nomModule;}
    public String getDescription() {return description;}
    public int getDuree() {return duree;}

    public void setIdModule(int idModule) {this.idModule = idModule;}
    public void setNomModule(String nomModule) {this.nomModule = nomModule;}
    public void setDescription(String description) {this.description = description;}
    public void setDuree(int duree) {this.duree = duree;}
    
    public void afficher() {
        System.out.println("Module{" +
                "idModule=" + idModule +
                ", nomModule='" + nomModule + '\'' +
                ", description='" + description + '\'' +
                ", duree=" + duree + " heures" +
                '}');
    }
}