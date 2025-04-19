package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import conn.ConnexionDB;
import model.Certificat;

public class CertificatDAO {

    public void genererCertificat(Certificat c) {
        String sql = "INSERT INTO Certificat(Date_Génération, ID_Etudiant, ID_Module) VALUES (?, ?, ?)";
        try (Connection conn = ConnexionDB.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, Date.valueOf(c.getDateGeneration()));
            stmt.setInt(2, c.getIdEtudiant());
            stmt.setInt(3, c.getIdModule());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erreur lors de la génération du certificat");
            ex.printStackTrace();
        }
    }

    public List<Certificat> listerParEtudiant(int idEtudiant) {
        List<Certificat> certificats = new ArrayList<>();
        String sql = "SELECT * FROM Certificat WHERE ID_Etudiant=?";
        try (Connection conn = ConnexionDB.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idEtudiant);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Certificat c = new Certificat(
                    rs.getInt("ID_Certificat"),
                    rs.getDate("Date_Génération").toLocalDate(),
                    rs.getInt("ID_Etudiant"),
                    rs.getInt("ID_Module")
                );
                certificats.add(c);
            }
        } catch (SQLException ex) {
            System.err.println("Erreur lors de la récupération des certificats par étudiant");
            ex.printStackTrace();
        }
        return certificats;
    }

    public List<Certificat> listerParModule(int idModule) {
        List<Certificat> certificats = new ArrayList<>();
        String sql = "SELECT * FROM Certificat WHERE ID_Module=?";
        try (Connection conn = ConnexionDB.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idModule);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Certificat c = new Certificat(
                    rs.getInt("ID_Certificat"),
                    rs.getDate("Date_Génération").toLocalDate(),
                    rs.getInt("ID_Etudiant"),
                    rs.getInt("ID_Module")
                );
                certificats.add(c);
            }
        } catch (SQLException ex) {
            System.err.println("Erreur lors de la récupération des certificats par module");
            ex.printStackTrace();
        }
        return certificats;
    }
}