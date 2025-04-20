package dao;

import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conn.ConnexionDB;
import model.Enseignant;

public class EnseignantDAO {

    public void  ajouterEnseignant(Enseignant enseignant)
    {
        String query = "INSERT INTO Enseignant (nom, prenom, email, specialite) VALUES (?, ?, ?, ?)";
        try(Connection conn = ConnexionDB.getConnection();
            PreparedStatement pst = conn.prepareStatement(query)){

                pst.setString(1, enseignant.getNom());
                pst.setString(2, enseignant.getPrenom());
                pst.setString(3, enseignant.getEmail());
                pst.setString(4, enseignant.getSpecialite());

                pst.executeUpdate();
        }catch(SQLException e){
            System.err.println("Erreur lors de l ajout d un enseignant");
            e.printStackTrace();
        }
    }
    public void modifierEnseignant(Enseignant enseignant) {
        String query = "UPDATE Enseignant SET nom = ?, prenom = ?, email = ?, specialite = ? WHERE ID_Enseignant = ?";
    
        try (Connection conn = ConnexionDB.getConnection();
             PreparedStatement pst = conn.prepareStatement(query)) {
    
            pst.setString(1, enseignant.getNom());
            pst.setString(2, enseignant.getPrenom());
            pst.setString(3, enseignant.getEmail());
            pst.setString(4, enseignant.getSpecialite());
            pst.setInt(5, enseignant.getIdEnseignant());
    
            pst.executeUpdate();
    
        } catch (SQLException e) {
            System.err.println("Erreur lors de la modification d un enseignant");
            e.printStackTrace();
        }
    }    
    public void supprimerEnseignant(int idEnseignant)
    {
        String query = "DELETE FROM Enseignant WHERE ID_Enseignant = ?";
        try(Connection conn = ConnexionDB.getConnection();
            PreparedStatement pst = conn.prepareStatement(query)){

                pst.setInt(1, idEnseignant);

                 pst.executeUpdate();
            } catch (SQLException e){
                System.err.println("Erreur lors de la suppression d un enseignant");
                e.printStackTrace();
            }
    }
    public Enseignant rechercherEnseignant(int idEnseignant){
        String query = "SELECT * FROM Enseignant WHERE ID_Enseignant = ?";
        Enseignant enseignant = null;

        try (Connection conn = ConnexionDB.getConnection();
             PreparedStatement pst = conn.prepareStatement(query)) {
                
                pst.setInt(1, idEnseignant);
                ResultSet rs = pst.executeQuery();

                if(rs.next()){
                    enseignant = new Enseignant();
                    enseignant.setIdEnseignant(rs.getInt("ID_Enseignant"));
                    enseignant.setNom(rs.getString("nom"));
                    enseignant.setPrenom(rs.getString("prenom"));
                    enseignant.setEmail(rs.getString("Email"));
                    enseignant.setSpecialite(rs.getString("specialite"));
                }
            }catch (SQLException e){
                System.err.println("Erreur lors de la recherche d un enseignant");
                e.printStackTrace();
            }
            return enseignant;
    }
    public List<Enseignant> getAllEnseignants(){
        String query = "SELECT * FROM Enseignant";
        List<Enseignant> enseignants = new ArrayList<>();
        
        try (Connection conn = ConnexionDB.getConnection();
             PreparedStatement pst = conn.prepareStatement(query)) {
    
            ResultSet rs = pst.executeQuery();
    
            while (rs.next()) {
                Enseignant enseignant = new Enseignant();
                enseignant.setIdEnseignant(rs.getInt("ID_Enseignant"));
                enseignant.setNom(rs.getString("nom"));
                enseignant.setPrenom(rs.getString("prenom"));
                enseignant.setEmail(rs.getString("email"));
                enseignant.setSpecialite(rs.getString("specialite"));
    
                enseignants.add(enseignant);
            }
    
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'affichage des enseignants");
            e.printStackTrace();
        }
        return enseignants;
    }
}
