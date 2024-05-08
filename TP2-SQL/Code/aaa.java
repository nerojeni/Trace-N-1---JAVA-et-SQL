import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.sql.SQLException;

public class aaa {
    public static void main(String[] args) {
        Connection connection = null;
        CallableStatement callableStatement = null;

        try {
            // Charge le pilote JDBC et établit la connexion
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tp2_jdbc", "root", "");

            // Exercice 5 - Exécution d'une procédure : 

            // Nom de la marque à mettre à jour et nouveau prix
            String marque = "Ford"; // Remplacez par la marque souhaitée
            double nouveauPrix = 22.00; // Remplacez par le nouveau prix souhaité

            // Appel de la procédure stockée
            String call = "{call MiseAJourPrixVehicules(?, ?)}";
            callableStatement = connection.prepareCall(call);
            callableStatement.setString(1, marque);
            callableStatement.setDouble(2, nouveauPrix);

            // Exécute la procédure stockée
            callableStatement.execute();

            System.out.println("Mise à jour réussie.");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (callableStatement != null) callableStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}