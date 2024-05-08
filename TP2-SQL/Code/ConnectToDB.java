import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDB {
    // Informations pour se connecter à la base de données
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/TP2_JDBC"; // URL de la base de données
    private static final String USER = "root"; // Nom d'utilisateur
    private static final String PASSWORD = ""; // Mot de passe (laissez-le vide pour MySQL en local)

    public static Connection getConnexion() {
        Connection connection = null;
        try {
            // Chargement du driver JDBC MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Établissement de la connexion à la base de données
            connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
            
            // Si la connexion est réussie :
            System.out.println("Connexion réussie!"); 

            // En cas d'erreur : 
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la connexion à la base de données.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Driver JDBC MySQL introuvable.");
        }
        return connection;
    }
}