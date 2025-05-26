package dao;

import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import conn.ConnexionDB;
import model.Cours;

public class CoursDAO {

    public void ajouterCours(Cours cours)
    {
        String query = "INSERT INTO Cours (Nom_Cours, Date_Cours, ID_Module) VALUES (?, ?, ?)";
        try (Connection conn = ConnexionDB.getConnection();
             PreparedStatement pst = conn.prepareStatement(query)) {
    
            pst.setString(1, cours.getNomCours());
            pst.setDate(2, java.sql.Date.valueOf(cours.getDateCours()));
            pst.setInt(3, cours.getIdModule());
    
            pst.executeUpdate();
    
        } catch (SQLException e) {
            System.err.println("Erreur lors de l ajout d un cours");
            e.printStackTrace();
        }
    }
    
    public void modifierCours(Cours cours) {
        String query = "UPDATE Cours SET Nom_Cours = ?, Date_Cours = ?, ID_Module = ? WHERE ID_Cours = ?";
    
        try (Connection conn = ConnexionDB.getConnection();
             PreparedStatement pst = conn.prepareStatement(query)) {

            pst.setString(1, cours.getNomCours());
            pst.setDate(2, java.sql.Date.valueOf(cours.getDateCours()));
            pst.setInt(3, cours.getIdModule());
            pst.setInt(4, cours.getIdCours());
            
            pst.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur lors de la modification d un cours");
            e.printStackTrace();
        }
    }    
    public void supprimerCours(int idCours)
    {
        String query = "DELETE FROM Cours WHERE ID_Cours  = ?";
        try(Connection conn = ConnexionDB.getConnection();
            PreparedStatement pst = conn.prepareStatement(query)){

                pst.setInt(1, idCours);
                pst.executeUpdate();
            } catch (SQLException e){
                System.err.println("Erreur lors de la suppression d un cours");
                e.printStackTrace();
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
            System.err.println("Erreur lors de la recherche d un cours");
            e.printStackTrace();
        }
        return cours;
    }
    
   public List<Cours> getAllCoursParModule(int ID_Module) {
    String query = "SELECT * FROM Cours WHERE ID_Module = ?";
    List<Cours> lesCours = new ArrayList<>();

    try (Connection conn = ConnexionDB.getConnection();
         PreparedStatement pst = conn.prepareStatement(query)) {

        pst.setInt(1, ID_Module);             // ✅ Avant l'exécution
        ResultSet rs = pst.executeQuery();    // ✅ Puis on exécute

        while (rs.next()) {
            Cours cours = new Cours();
            cours.setIdCours(rs.getInt("ID_Cours"));
            cours.setNomCours(rs.getString("Nom_Cours"));
            cours.setDateCours(rs.getDate("Date_Cours").toLocalDate());
            cours.setIdModule(rs.getInt("ID_Module"));

            lesCours.add(cours);
        }

    } catch (SQLException e) {
        System.err.println("Erreur lors de l'affichage des cours par module");
        e.printStackTrace();
    }
    return lesCours;
}

}
