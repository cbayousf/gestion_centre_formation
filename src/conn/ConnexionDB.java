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
<<<<<<< HEAD
            // System.out.println("✅ Connexion reussie a la base de donnees !");
=======
            //System.out.println("✅ Connexion réussie à la base de données !");
>>>>>>> c4800ad03ca42e1cbe64647096a3ca9ddce3ea28
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
