package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import conn.ConnexionDB;
import model.Etudiant;

public class EtudiantDAO {
    
    public void ajouterEtudiant(Etudiant e) {
        String sql = "INSERT INTO etudiant(Nom, Prenom, Email, Telephone) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnexionDB.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, e.getNom());
            stmt.setString(2, e.getPrenom());
            stmt.setString(3, e.getEmail());
            stmt.setString(4, e.getTelephone());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erreur lors de l’ajout d’un étudiant");
            ex.printStackTrace();
        }
    }

    public void modifierEtudiant(Etudiant e) {
        String sql = "UPDATE etudiant SET Nom=?, Prenom=?, Email=?, Telephone=? WHERE ID_Etudiant=?";
        try (Connection conn = ConnexionDB.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, e.getNom());
            stmt.setString(2, e.getPrenom());
            stmt.setString(3, e.getEmail());
            stmt.setString(4, e.getTelephone());
            stmt.setInt(5, e.getID_Etudiant());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erreur lors de la modification d’un étudiant");
            ex.printStackTrace();
        }
    }
    public Etudiant getEtudiantById(int id) {
    String sql = "SELECT * FROM etudiant WHERE ID_Etudiant=?";
    try (Connection conn = ConnexionDB.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return new Etudiant(
                rs.getInt("ID_Etudiant"),
                rs.getString("Nom"),
                rs.getString("Prenom"),
                rs.getString("Email"),
                rs.getString("Telephone")
            );
        }
    } catch (SQLException ex) {
        System.err.println("Erreur SQL : " + ex.getMessage());
    }
    return null;
}
    public void supprimerEtudiant(int id) {
        String sql = "DELETE FROM etudiant WHERE ID_Etudiant=?";
        try (Connection conn = ConnexionDB.getConnection(); 
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erreur lors de la suppression d’un étudiant");
            ex.printStackTrace();
        }
    }

    public Etudiant chercherEtudiant(int id) {
        String sql = "SELECT * FROM etudiant WHERE ID_Etudiant=?";
        try (Connection conn = ConnexionDB.getConnection(); 
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Etudiant(
                    rs.getInt("ID_Etudiant"),
                    rs.getString("Nom"),
                    rs.getString("Prenom"),
                    rs.getString("Email"),
                    rs.getString("Telephone")
                );
            }
        } catch (SQLException ex) {
            System.err.println("Erreur lors de la recherche d’un étudiant");
            ex.printStackTrace();
        }
        return null;
    }

    public List<Etudiant> listerTous() {
        List<Etudiant> list = new ArrayList<>();
        String sql = "SELECT * FROM etudiant";
        try (Connection conn = ConnexionDB.getConnection(); 
            Statement stmt = conn.createStatement(); 
            ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Etudiant e = new Etudiant(
                    rs.getInt("ID_Etudiant"),
                    rs.getString("Nom"),
                    rs.getString("Prenom"),
                    rs.getString("Email"),
                    rs.getString("Telephone")
                );
                list.add(e);
            }
        } catch (SQLException ex) {
            System.err.println("Erreur lors de l'affichage des étudiants");
            ex.printStackTrace();
        }
        return list;
    }  
}
