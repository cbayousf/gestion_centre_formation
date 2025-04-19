package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionDB {
    public static Connection getConnection() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/centre_formation?useSSL=false&characterEncoding=utf8mb4",
        "root", ""
);
            System.out.println("✅ Connexion réussie à la base de données !");
            return conn;
        } catch (ClassNotFoundException e) {
            System.out.println("❌ Driver JDBC non trouvé !");
            e.printStackTrace();//on affiche les détails
        } catch (SQLException e) {
            System.out.println("❌ Erreur de connexion !");
            e.printStackTrace();
        }
        return null;
    }
}
