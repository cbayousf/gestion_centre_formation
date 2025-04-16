package conn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionDB {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Charger le driver
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/centre_formation", // URL
                "root",       // utilisateur MySQL
                ""            // mot de passe (vide si tu n’as rien mis)
            );
            System.out.println("✅ Connexion réussie à la base de données !");
            return conn;
        } catch (ClassNotFoundException e) {
            System.out.println("❌ Driver JDBC non trouvé !");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("❌ Erreur de connexion !");
            e.printStackTrace();
        }
        return null;
    }
}
