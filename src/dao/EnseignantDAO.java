package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conn.ConnexionDB;
import model.Enseignant;

public class EnseignantDAO {

    public boolean  ajouterEnseignant(Enseignant enseignant)
    {
        String query = "INSERT INTO Enseignant (nom, prenom, email, specialite) VALUES (?, ?, ?, ?)";
        try(Connection conn = ConnexionDB.getConnection();
            PreparedStatement pst = conn.prepareStatement(query)){

                pst.setString(1, enseignant.getNom());
                pst.setString(2, enseignant.getPrenom());
                pst.setString(3, enseignant.getEmail());
                pst.setString(4, enseignant.getSpecialite());

                int rowsAffected = pst.executeUpdate();
                return rowsAffected > 0;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean modifierEnseignant(Enseignant enseignant) {
        String query = "UPDATE Enseignant SET nom = ?, prenom = ?, email = ?, specialite = ? WHERE idEnseignant = ?";
    
        try (Connection conn = ConnexionDB.getConnexion();
             PreparedStatement pst = conn.prepareStatement(query)) {
    
            pst.setString(1, enseignant.getNom());
            pst.setString(2, enseignant.getPrenom());
            pst.setString(3, enseignant.getEmail());
            pst.setString(4, enseignant.getSpecialite());
            pst.setInt(5, enseignant.getIdEnseignant());
    
            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;
    
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }    
    public boolean spprimerEnseignant(int idEnseignant)
    {
        String query = "DELETE FROM Enseignant WHERE idEnseignant = ?";
        try(Connection conn = ConnexionDB.getConnection();
            PreparedStatement pst = conn.prepareStatement(query)){

                pst.setInt(1, idEnseignant);

                int rowsAffected = pst.executeUpdate();
                return rowsAffected > 0;
            } catch (SQLException e){
                e.printStackTrace();
                return false;
            }
    }
    public Enseignant rechercherEnseignant(int idEnseignant){
        String query = "SELECT * FROM Enseignant WHERE idEnseignant = ?";
        Enseignant enseignant = null;

        try (Connection conn = ConnexionDB.getConnection();
             PreparedStatement pst = conn.prepareStatement(query)) {
                
                pst.setInt(1, idEnseignant);
                ResultSet rs = pst.executeQuery();

                if(rs.next()){
                    enseignant = new Enseignant();
                    enseignant.setIdEnseignant(rs.getInt("idEnseignant"));
                    enseignant.setNom(rs.getString("nom"));
                    enseignant.setPrenom(rs.getString("prenom"));
                    package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conn.ConnexionDB;
import model.Enseignant;

public class EnseignantDAO {

    public boolean  ajouterEnseignant(Enseignant enseignant)
    {
        String query = "INSERT INTO Enseignant (nom, prenom, email, specialite) VALUES (?, ?, ?, ?)";
        try(Connection conn = ConnexionDB.getConnection();
            PreparedStatement pst = conn.prepareStatement(query)){

                pst.setString(1, enseignant.getNom());
                pst.setString(2, enseignant.getPrenom());
                pst.setString(3, enseignant.getEmail());
                pst.setString(4, enseignant.getSpecialite());

                int rowsAffected = pst.executeUpdate();
                return rowsAffected > 0;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean modifierEnseignant(Enseignant enseignant) {
        String query = "UPDATE Enseignant SET nom = ?, prenom = ?, email = ?, specialite = ? WHERE idEnseignant = ?";
    
        try (Connection conn = ConnexionDB.getConnexion();
             PreparedStatement pst = conn.prepareStatement(query)) {
    
            pst.setString(1, enseignant.getNom());
            pst.setString(2, enseignant.getPrenom());
            pst.setString(3, enseignant.getEmail());
            pst.setString(4, enseignant.getSpecialite());
            pst.setInt(5, enseignant.getIdEnseignant());
    
            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;
    
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }    
    public boolean spprimerEnseignant(int idEnseignant)
    {
        String query = "DELETE FROM Enseignant WHERE idEnseignant = ?";
        try(Connection conn = ConnexionDB.getConnection();
            PreparedStatement pst = conn.prepareStatement(query)){

                pst.setInt(1, idEnseignant);

                int rowsAffected = pst.executeUpdate();
                return rowsAffected > 0;
            } catch (SQLException e){
                e.printStackTrace();
                return false;
            }
    }
    public Enseignant rechercherEnseignant(int idEnseignant){
        String query = "SELECT * FROM Enseignant WHERE idEnseignant = ?";
        Enseignant enseignant = null;

        try (Connection conn = ConnexionDB.getConnection();
             PreparedStatement pst = conn.prepareStatement(query)) {
                
                pst.setInt(1, idEnseignant);
                ResultSet rs = pst.executeQuery();

                if(rs.next){
                    enseignant = new Enseignant();
                    enseignant.setIdEnseignant(rs.getInt("idEnseignant"));
                    enseignant.setNom(rs.getString("nom"));
                    enseignant.setPrenom(rs.getString("prenom"));
                    enseignant.setEmail(rs.getString("Email"));
                    enseignant.setSpecialite(rs.getString("specialite"));
                }
            }catch (SQLException e){
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
                enseignant.setIdEnseignant(rs.getInt("idEnseignant"));
                enseignant.setNom(rs.getString("nom"));
                enseignant.setPrenom(rs.getString("prenom"));
                enseignant.setEmail(rs.getString("email"));
                enseignant.setSpecialite(rs.getString("specialite"));
    
                enseignants.add(enseignant);
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enseignants;
    }
    public void afficherEnseignant(){
        List<Enseignant> enseignants = getAllEnseignants();

        for (Enseignant enseignant : enseignants){
            System.out.println(enseignant.afficher);
        }
    }

}
);
                    enseignant.setSpecialite(rs.getString("specialite"));
                }
            }catch (SQLException e){
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
                enseignant.setIdEnseignant(rs.getInt("idEnseignant"));
                enseignant.setNom(rs.getString("nom"));
                enseignant.setPrenom(rs.getString("prenom"));
                enseignant.setEmail(rs.getString("email"));
                enseignant.setSpecialite(rs.getString("specialite"));
    
                enseignants.add(enseignant);
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enseignants;
    }
    public void afficherEnseignant(){
        List<Enseignant> enseignants = getAllEnseignants();

        for (Enseignant enseignant : enseignants){
            System.out.println(enseignant);
        }
    }

}
