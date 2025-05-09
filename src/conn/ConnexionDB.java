package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionDB {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/centre_formation","root","");
            // System.out.println("✅ Connexion reussie a la base de donnees !");
            return conn;
        } catch (ClassNotFoundException e) {
            System.out.println("❌ Driver JDBC non trouve !");
            e.printStackTrace();//on affiche les détails
        } catch (SQLException e) {
            System.out.println("❌ Erreur de connexion !");
            e.printStackTrace();
        }
        return null;
    }
}
