package services;

import dao.CertificatDAO;
import model.Certificat;

import java.util.List;

public class CertificatService {
    private CertificatDAO certificatDAO;

    public CertificatService() {
        this.certificatDAO = new CertificatDAO();
    }

    public void genererCertificat(Certificat c) {
        if (c != null && c.getIdEtudiant() > 0 && c.getIdModule() > 0) {
            certificatDAO.genererCertificat(c);
            System.out.println("✅ Certificat généré avec succès !");
        } else {
            System.out.println("❌ Données du certificat invalides !");
        }
    }

    public List<Certificat> listerParEtudiant(int idEtudiant) {
        if (idEtudiant > 0)
            return certificatDAO.listerParEtudiant(idEtudiant);
        else {
            System.out.println("❌ ID étudiant invalide !");
            return null;
        }
    }

    public List<Certificat> listerParModule(int idModule) {
        if (idModule > 0)
            return certificatDAO.listerParModule(idModule);
        else {
            System.out.println("❌ ID module invalide !");
            return null;
        }
    }
}
