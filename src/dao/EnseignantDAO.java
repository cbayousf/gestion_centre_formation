package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conn.ConnexionDB;
import models.Enseignant;

public class EnseignantDAO {

    public boolean ajouterEnseignant(Enseignant enseignant) {
        String query = "INSERT INTO Enseignant (Nom, Prenom, Email, Specialite) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConnexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, enseignant.getNom());
            pstmt.setString(2, enseignant.getPrenom());
            pstmt.setString(3, enseignant.getEmail());
            pstmt.setString(4, enseignant.getSpecialite());

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
