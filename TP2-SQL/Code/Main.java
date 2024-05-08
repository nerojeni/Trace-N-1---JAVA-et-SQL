import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {
    public static void main(String[] args) {
        // Connexion : 
        Connection conn = ConnectToDB.getConnexion();

        if (conn != null) {
            try {
                // Création d'une instruction SQL : 
                Statement statement = conn.createStatement();
                String selectionSQL = "SELECT * FROM locations";
                ResultSet resultSet = statement.executeQuery(selectionSQL);



                // Fermeture de la connexion
                conn.close();
                System.out.println("Connexion fermée ... :(");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Erreur lors de la fermeture de la connexion.");
            }
        }
    }
}
