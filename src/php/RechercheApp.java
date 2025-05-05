package php;

import java.sql.*;

public class RechercheApp {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Erreur : paramètre manquant.");
            return;
        }

        String terme = args[0];

        try {
            // Charger le driver MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connexion à la base
            String url = "jdbc:mysql://localhost:3306/centre_formation";
            String user = "root";
            String password = "";

            Connection conn = DriverManager.getConnection(url, user, password);

            // Requête de recherche
            String query = "SELECT * FROM ModuleFormation WHERE Nom_Module LIKE ? OR Description LIKE ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, "%" + terme + "%");
            ps.setString(2, "%" + terme + "%");

            ResultSet rs = ps.executeQuery();

            // Affichage des résultats (format simple pour PHP)
            while (rs.next()) {
                System.out.println(rs.getString("Nom_Module") + " | " + rs.getString("Description") + " | " + rs.getInt("Duree") + "h");
            }

            conn.close();
        } catch (Exception e) {
            System.err.println("Erreur : " + e.getMessage());
        }
    }
}