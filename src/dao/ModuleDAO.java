package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import conn.ConnexionDB;
import model.Module;

public class ModuleDAO {

    public void ajouterModule(Module m) {
        String sql = "INSERT INTO Module(Nom_Module, Description, Durée) VALUES (?, ?, ?)";
        try (Connection conn = ConnexionDB.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, m.getNomModule());
            stmt.setString(2, m.getDescription());
            stmt.setInt(3, m.getDuree());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erreur lors de l’ajout d’un module");
            ex.printStackTrace();
        }
    }

    public void modifierModule(Module m) {
        String sql = "UPDATE Module SET Nom_Module=?, Description=?, Durée=? WHERE ID_Module=?";
        try (Connection conn = ConnexionDB.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, m.getNomModule());
            stmt.setString(2, m.getDescription());
            stmt.setInt(3, m.getDuree());
            stmt.setInt(4, m.getIdModule());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erreur lors de la modification d’un module");
            ex.printStackTrace();
        }
    }

    public void supprimerModule(int id) {
        String sql = "DELETE FROM Module WHERE ID_Module=?";
        try (Connection conn = ConnexionDB.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erreur lors de la suppression d’un module");
            ex.printStackTrace();
        }
    }

    public Module chercherModule(int id) {
        String sql = "SELECT * FROM Module WHERE ID_Module=?";
        try (Connection conn = ConnexionDB.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Module(
                    rs.getInt("ID_Module"),
                    rs.getString("Nom_Module"),
                    rs.getString("Description"),
                    rs.getInt("Durée")
                );
            }
        } catch (SQLException ex) {
            System.err.println("Erreur lors de la recherche d’un module");
            ex.printStackTrace();
        }
        return null;
    }

    public List<Module> listerTous() {
        List<Module> list = new ArrayList<>();
        String sql = "SELECT * FROM Module";
        try (Connection conn = ConnexionDB.getConnection(); 
             Statement stmt = conn.createStatement(); 
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Module m = new Module(
                    rs.getInt("ID_Module"),
                    rs.getString("Nom_Module"),
                    rs.getString("Description"),
                    rs.getInt("Durée")
                );
                list.add(m);
            }
        } catch (SQLException ex) {
            System.err.println("Erreur lors de l'affichage des modules");
            ex.printStackTrace();
        }
        return list;
    }
}