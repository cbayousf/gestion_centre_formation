
package model;

import java.time.LocalDate;

public class Certificat {
    private int idCertificat;
    private LocalDate dateGeneration;
    private int idEtudiant;
    private int idModule;

    public Certificat() {}
    public Certificat(int idCertificat, LocalDate dateGeneration, int idEtudiant, int idModule)
    {
        this.idCertificat = idCertificat;
        this.dateGeneration = dateGeneration;
        this.idEtudiant = idEtudiant;
        this.idModule = idModule;
    }

    public int getIdCertificat() {return idCertificat;}
    public LocalDate getDateGeneration() {return dateGeneration;}
    public int getIdEtudiant() {return idEtudiant;}
    public int getIdModule() {return idModule;}

    public void setIdCertificat(int idCertificat) {this.idCertificat = idCertificat;}
    public void setDateGeneration(LocalDate dateGeneration) {this.dateGeneration = dateGeneration;}
    public void setIdEtudiant(int idEtudiant) {this.idEtudiant = idEtudiant;}
    public void setIdModule(int idModule) {this.idModule = idModule;}

    public void afficher() {
        System.out.println("Certificat{" +
                "idCertificat=" + idCertificat +
                ", dateGeneration=" + dateGeneration +
                ", idEtudiant=" + idEtudiant +
                ", idModule=" + idModule +
                '}');
    }
}
