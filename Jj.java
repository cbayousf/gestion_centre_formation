import conn.ConnexionDB;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class Jj {
    public static void main(String[] args) {
        // Tester la connexion à la base de données
        Connection connection = ConnexionDB.getConnection();
        
        if (connection != null) {
            try {
                // Créer un objet Statement pour exécuter une requête SQL
                Statement statement = connection.createStatement();
                String query = "SELECT * FROM etudiants"; // Remplace par ta table et ta requête
                ResultSet resultSet = statement.executeQuery(query);

                // Parcourir les résultats
                while (resultSet.next()) {
                    int id = resultSet.getInt("id"); // Remplace par ta colonne
                    String nom = resultSet.getString("nom"); // Remplace par ta colonne
                    System.out.println("ID: " + id + ", Nom: " + nom);
                }

            } catch (Exception e) {
                System.out.println("❌ Erreur lors de l'exécution de la requête SQL !");
                e.printStackTrace();
            } finally {
                try {
                    // Toujours fermer la connexion après l'utilisation
                    if (connection != null && !connection.isClosed()) {
                        connection.close();
                        System.out.println("✅ Connexion fermée.");
                    }
                } catch (Exception e) {
                    System.out.println("❌ Erreur lors de la fermeture de la connexion.");
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("❌ Impossible de se connecter à la base de données !");
        }
    }
}
