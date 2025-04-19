package dao;

import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;


import conn.ConnexionDB;
import model.Cours;

public class CoursDAO {

    public boolean ajouterCours(Cours cours)
    {
        String query = "INSERT INTO Cours (Nom_Cours, Date_Cours, ID_Module) VALUES (?, ?, ?)";
        try (Connection conn = ConnexionDB.getConnection();
             PreparedStatement pst = conn.prepareStatement(query)) {
    
            pst.setString(1, cours.getNomCours());
            pst.setDate(2, java.sql.Date.valueOf(cours.getDateCours()));
            pst.setInt(3, cours.getIdModule());
    
            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;
    
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean modifierCours(Cours cours) {
        String query = "UPDATE Cours SET Nom_Cours = ?, Date_Cours = ?, ID_Module = ? WHERE ID_Cours = ?";
    
        try (Connection conn = ConnexionDB.getConnection();
             PreparedStatement pst = conn.prepareStatement(query)) {

                pst.setString(1, cours.getNomCours());
                pst.setDate(2, java.sql.Date.valueOf(cours.getDateCours()));
                pst.setInt(3, cours.getIdModule());
                pst.setInt(4, cours.getIdCours());
            
    
            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;
    
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }    
    public boolean supprimerCours(int idCours)
    {
        String query = "DELETE FROM Cours WHERE ID_Cours  = ?";
        try(Connection conn = ConnexionDB.getConnection();
            PreparedStatement pst = conn.prepareStatement(query)){

                pst.setInt(1, idCours);

                int rowsAffected = pst.executeUpdate();
                return rowsAffected > 0;
            } catch (SQLException e){
                e.printStackTrace();
                return false;
            }
    }
    public Cours rechercherCours(int idCours) {
        String query = "SELECT * FROM Cours WHERE ID_Cours  = ?";
        Cours cours = null;
    
        try (Connection conn = ConnexionDB.getConnection();
             PreparedStatement pst = conn.prepareStatement(query)) {
            
            pst.setInt(1, idCours);
            ResultSet rs = pst.executeQuery();
    
            if (rs.next()) {
                cours = new Cours();
                cours.setIdCours(rs.getInt("ID_Cours"));
                cours.setNomCours(rs.getString("Nom_Cours"));
                cours.setDateCours(rs.getDate("Date_Cours").toLocalDate());
                cours.setIdModule(rs.getInt("ID_Module"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cours;
    }
    
    public List<Cours> getAllCours() {
        String query = "SELECT * FROM Cours";
        List<Cours> lesCours = new ArrayList<>();
    
        try (Connection conn = ConnexionDB.getConnection();
             PreparedStatement pst = conn.prepareStatement(query)) {
    
            ResultSet rs = pst.executeQuery();
    
            while (rs.next()) {
                Cours cours = new Cours();
                cours.setIdCours(rs.getInt("ID_Cours"));
                cours.setNomCours(rs.getString("Nom_Cours"));
                cours.setDateCours(rs.getDate("Date_Cours").toLocalDate());
                cours.setIdModule(rs.getInt("ID_Module"));
    
                lesCours.add(cours);
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lesCours;
    }
    
    public void afficherCours(){
        List<Cours> lesCours = getAllCours();

        for (Cours cours : lesCours){
            System.out.println(cours.afficher());
        }
    }

}
