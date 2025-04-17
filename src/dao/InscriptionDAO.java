package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conn.ConnexionDB;
import model.Inscription;

public class InscriptionDAO {
    
    public void inscrireEtudiant(Inscription i) {
        String sql = "INSERT INTO Inscription(Statut, ID_Etudiant, ID_Module, Date_Inscription) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnexionDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, i.getStatut());
            stmt.setInt(2, i.getID_Etudiant());
            stmt.setInt(3, i.getID_Module());
            stmt.setDate(4, Date.valueOf(i.getDate_Inscription()));
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erreur lors de l'inscription d'un étudiant");
            ex.printStackTrace();
        }
    }

    public void modifierInscription(Inscription i) {
        String sql = "UPDATE Inscription SET Statut=?, ID_Etudiant=?, ID_Module=?, Date_Inscription=? WHERE ID_Inscription=?";
        try (Connection conn = ConnexionDB.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, i.getStatut());
            stmt.setInt(2, i.getID_Etudiant());
            stmt.setInt(3, i.getID_Module());
            stmt.setDate(4, Date.valueOf(i.getDate_Inscription()));
            stmt.setInt(5, i.getID_Inscription());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erreur lors de la modification d'une inscription");
            ex.printStackTrace();
        }
    }

    public void annulerInscription(int id) {
        String sql = "DELETE FROM Inscription WHERE ID_Inscription=?";
        try (Connection conn = ConnexionDB.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erreur lors de l'annulation d'une inscription");
            ex.printStackTrace();
        }
    }

    public List<Inscription> listerInscriptionsParEtudiant(int ID_Etudiant) {
        List<Inscription> liste = new ArrayList<>();
        String sql = "SELECT * FROM Inscription WHERE ID_Etudiant=?";
        try (Connection conn = ConnexionDB.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, ID_Etudiant);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Inscription i = new Inscription(
                    rs.getInt("ID_Inscription"),
                    rs.getString("Statut"),
                    rs.getInt("ID_Etudiant"),
                    rs.getInt("ID_Module"),
                    rs.getDate("Date_Inscription").toLocalDate()
                );
                liste.add(i);
            }
        } catch (SQLException ex) {
            System.err.println("Erreur lors de l'affichage des inscriptions par étudiant");
            ex.printStackTrace();
        }
        return liste;
    }

    public List<Inscription> listerInscriptionsParModule(int ID_Module) {
        List<Inscription> liste = new ArrayList<>();
        String sql = "SELECT * FROM Inscription WHERE ID_Module=?";
        try (Connection conn = ConnexionDB.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, ID_Module);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Inscription i = new Inscription(
                    rs.getInt("ID_Inscription"),
                    rs.getString("Statut"),
                    rs.getInt("ID_Etudiant"),
                    rs.getInt("ID_Module"),
                    rs.getDate("Date_Inscription").toLocalDate()
                );
                liste.add(i);
            }
        } catch (SQLException ex) {
            System.err.println("Erreur lors de l'affichage des inscriptions par module");
            ex.printStackTrace();
        }
        return liste;
    }
}
