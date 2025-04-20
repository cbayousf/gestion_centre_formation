package dao;

import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import java.sql.Date;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conn.ConnexionDB;
import model.Affectation;

public class AffectationDAO {

    public void ajouterAffectation(Affectation affectation) {
        String query = "INSERT INTO Affectation (ID_Enseignant, ID_Module, Date_Affectation) VALUES (?, ?, ?)";
        try (Connection conn = ConnexionDB.getConnection();
             PreparedStatement pst = conn.prepareStatement(query)) {
    
            pst.setInt(1, affectation.getIdEnseignant());
            pst.setInt(2, affectation.getIdModule());
            pst.setDate(3, Date.valueOf(affectation.getDateAffect()));
    
            pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de l ajout d une affectation");
            e.printStackTrace();
        }
    }    
    public void modifierAffectation(Affectation affectation) {
        String query = "UPDATE Affectation SET ID_Enseignant = ?, ID_Module = ?, Date_Affectation = ? WHERE ID_E = ?";
    
        try (Connection conn = ConnexionDB.getConnection();
             PreparedStatement pst = conn.prepareStatement(query)) {
    
            pst.setInt(1, affectation.getIdEnseignant());
            pst.setInt(2, affectation.getIdModule());
            pst.setDate(3, Date.valueOf(affectation.getDateAffect()));
            pst.setInt(4, affectation.getIdE());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la modification d une affectation");
            e.printStackTrace();
        }
    }      
    public void supprimerAffectation(int idE)
    {
        String query = "DELETE FROM Affectation WHERE id_E = ?";
        try(Connection conn = ConnexionDB.getConnection();
            PreparedStatement pst = conn.prepareStatement(query)){

                pst.setInt(1, idE);
                pst.executeUpdate();
            } catch (SQLException e){
                System.err.println("Erreur lors de la suppression d une affectation");
                e.printStackTrace();
            }
    }
    public Affectation rechercherAffectation(int idE) {
        String query = "SELECT * FROM Affectation WHERE ID_E = ?";
        Affectation affectation = null;
    
        try (Connection conn = ConnexionDB.getConnection();
             PreparedStatement pst = conn.prepareStatement(query)) {
    
            pst.setInt(1, idE);
            ResultSet rs = pst.executeQuery();
    
            if (rs.next()) {
                affectation = new Affectation();
                affectation.setIdE(rs.getInt("ID_E"));
                affectation.setIdEnseignant(rs.getInt("ID_Enseignant"));
                affectation.setIdModule(rs.getInt("ID_Module"));
                affectation.setDateAffect(rs.getDate("Date_Affectation").toLocalDate());
            }
        } catch (SQLException e) {
            System.err.println("Erreur lors de la recherche d une affectation");
            e.printStackTrace();
        }
        return affectation;
    }    
    public List<Affectation> getAllAffectationsParModule(int ID_Module) {
        String query = "SELECT * FROM Affectation where ID_Module = ?";
        List<Affectation> affectations = new ArrayList<>();
    
        try (Connection conn = ConnexionDB.getConnection();
             PreparedStatement pst = conn.prepareStatement(query)) {

            pst.setInt(1, ID_Module);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Affectation affectation = new Affectation();
                affectation.setIdE(rs.getInt("ID_E"));
                affectation.setIdEnseignant(rs.getInt("ID_Enseignant"));
                affectation.setIdModule(rs.getInt("ID_Module"));
                affectation.setDateAffect(rs.getDate("Date_Affectation").toLocalDate());
    
                affectations.add(affectation);
            }
    
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'affichage des Affectations par Module");
            e.printStackTrace();
        }
        return affectations;
    }

        public List<Affectation> getAllAffectationsParEnseignant(int ID_Enseignant) {
        String query = "SELECT * FROM Affectation where ID_Enseignant = ?";
        List<Affectation> affectations = new ArrayList<>();
    
        try (Connection conn = ConnexionDB.getConnection();
             PreparedStatement pst = conn.prepareStatement(query)) {

            pst.setInt(1, ID_Etudiant);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Affectation affectation = new Affectation();
                affectation.setIdE(rs.getInt("ID_E"));
                affectation.setIdEnseignant(rs.getInt("ID_Enseignant"));
                affectation.setIdModule(rs.getInt("ID_Module"));
                affectation.setDateAffect(rs.getDate("Date_Affectation").toLocalDate());
    
                affectations.add(affectation);
            }
    
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'affichage des Affectations par Enseignant");
            e.printStackTrace();
        }
        return affectations;
    }
}
