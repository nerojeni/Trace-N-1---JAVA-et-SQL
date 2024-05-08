import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


public class transaction {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/tp2_jdbc";
        String username = "root";
        String password = "";

        // Définir la connexion en dehors du bloc try pour qu'elle soit accessible dans le bloc finally
        Connection connection = null;

        try {
            // Charger le pilote JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Établir une connexion à la base de données
            connection = DriverManager.getConnection(url, username, password);

            // Exercice 6 - Transaction :
            // Désactivation du mode commit automatique :
            connection.setAutoCommit(false);

            withdraw(connection, 100001, 400000);

            // Effectuer un dépôt dans le compte 2 :
            deposit(connection, 100010, 500);

            // Valider la transaction :
            connection.commit();
            System.out.println("Transaction réussie !");
        } catch (SQLException e) {
            System.out.println("Transaction échouée ! : " + e);
            if (connection != null) {
                try {
                    connection.rollback(); // En cas d'erreur, annule la transaction
                } catch (SQLException rollbackException) {
                    System.err.println("Erreur lors de l'annulation de la transaction : " + rollbackException);
                }
            }
        } catch (ClassNotFoundException e) {
            // Gestion de l'exception ClassNotFoundException
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.setAutoCommit(true); // Réactive le mode commit automatique
                    connection.close(); // Ferme la connexion
                } catch (SQLException closeException) {
                    System.err.println("Erreur lors de la fermeture de la connexion : " + closeException);
                }
            }
        }
    }

    // Méthode withdraw :
    private static void withdraw(Connection connection, int Numéro_Compte, double valeur) throws SQLException {
        // Obtenir le solde actuel du compte
        double soldeActuel = getSolde(connection, Numéro_Compte);

        // Vérifier si le solde est suffisant pour le retrait
        if (soldeActuel >= valeur) {
            String sql = "UPDATE comptes SET Solde = Solde - ? WHERE Numéro_Compte = ?";
            // Préparation de la requête : 
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // Associer les valeurs :
                preparedStatement.setDouble(1, valeur);
                preparedStatement.setInt(2, Numéro_Compte);
                preparedStatement.executeUpdate();
            }
        } else {
            System.out.println("Solde insuffisant pour effectuer le retrait.");
        }
    }

    // Méthode pour obtenir le solde actuel du compte
    private static double getSolde(Connection connection, int Numéro_Compte) throws SQLException {
        String sql = "SELECT Solde FROM comptes WHERE Numéro_Compte = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, Numéro_Compte);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getDouble("Solde");
            }
            return 0.0; // Compte inexistant
    }
}


       // Méthode deposit :
    private static void deposit(Connection connection, int Numéro_Compte, double valeur) throws SQLException {
        // Vérifier si le compte existe
        if (getCompte(connection, Numéro_Compte)) {
            String sql = "UPDATE comptes SET Solde = Solde + ? WHERE Numéro_Compte = ?";
            // Préparation de la requête :
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // Associer les valeurs :
                preparedStatement.setDouble(1, valeur);
                preparedStatement.setInt(2, Numéro_Compte);
                preparedStatement.executeUpdate();
            }
        } else {
            System.out.println("Le compte source n'existe pas.");
        }
    }

    // Méthode pour vérifier si le compte existe
    private static boolean getCompte(Connection connection, int Numéro_Compte) throws SQLException {
        String sql = "SELECT COUNT(*) FROM comptes WHERE Numéro_Compte = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, Numéro_Compte);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getInt(1) == 1;
        }
    }
}
