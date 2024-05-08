import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ConnectDB {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/tp2_jdbc";
        String username = "root";
        String password = "";

        // Définir la connexion en dehors du bloc try pour qu'elle soit accessible dans
        // le bloc finally
        Connection connection = null;

        try {
            // Charger le pilote JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Établir une connexion à la base de données
            connection = DriverManager.getConnection(url, username, password);

            // Création d'une instruction SQL :
            // PreparedStatement prepStatement = connection.prepareStatement();

            if (connection != null) {
                System.out.println("Connexion à la base de données réussie !");

                // Exercice 2 :

                // Afficher le résultat :
                // int id_client = 3;
                // String selectionSQL = "SELECT * FROM locations WHERE ID_client = " +
                // id_client ;

                // Première exemple sans utiliser PreparedStatement :
                // Créer une instruction SQL
                // Statement statement = connection.createStatement();
                // String selectQuery = "SELECT * FROM locations WHERE ID_client = " + id_client
                // ;
                // ResultSet resultSet = statement.executeQuery(selectQuery);

                // Deuxième exemple utiSlisation de PreparedStatement :
                // PreparedStatement prepStatement = connection.prepareStatement(selectionSQL);

                // ResultSet resultSet = prepStatement.executeQuery();

                // while (resultSet.next()){
                // // Récupérer les donnéesQ
                // int ID_location = resultSet.getInt("ID_location");
                // int ID_Véhicule = resultSet.getInt("ID_Véhicule");
                // int ID_Employé = resultSet.getInt("ID_Employé");
                // Date Date_Début = resultSet.getDate("Date_Début");
                // Date Date_Fin = resultSet.getDate("Date_Fin");
                // int Coût_Total = resultSet.getInt("Coût_Total");
                // System.out.println("Le client avec l'id :" + id_client + " a effectué une
                // location ( ID_location : " + ID_location + " ) de véhicule ( ID_Véhicule : "
                // + ID_Véhicule + String insertSQL = "INSERT INTO clients (ID_Client, Nom,
                // Prénom, Adresse, Numéro_Téléphone) VALUES (?, ?, ?, ?, ?)";

                // // Exercice 3 - Insertion de données :

                // // Requête pour insérer les données :
                // String insertSQL = "INSERT INTO Clients (Nom,Prénom,Adresse,Numéro_Téléphone)
                // VALUE ('Kamil','Leo','1 rue perdu 23449 Perdu', '09-34-34-34-34')";
                // // Préparer la commande :
                // PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
                // // Exécuter la commande :
                // int rowsInserted = preparedStatement.executeUpdate();

                // // Si l'insertion est un succès :
                // if (rowsInserted > 0) {
                // System.out.println("Les données ont été insérées avec succès !");
                // } else {
                // System.out.println("Les données n'ont pas été insérées avec succès.");
                // }

                // }

                // Exercice 4 - Suppression de données :

                // Requête sql pour supprpimer les données :
                // String delSQL = "DELETE FROM Locations WHERE Coût_total > 275";
                // // Préparer la commande :
                // PreparedStatement prepStatement = connection.prepareStatement(delSQL);
                // // Exécuter la commande :
                // int rowsDeleted = prepStatement.executeUpdate();

                // // Vérifier si la suppression a été faite :
                // if (rowsDeleted != 0) {
                //     System.out.println("Les données ont été supprimées avec succès !");
                // } else {
                //     System.out.println("Les données n'ont pas été supprimées ...");
                // }


            }   

        } catch (ClassNotFoundException e) {
            System.out.println("Erreur lors du chargement du pilote JDBC : " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erreur lors de la connexion à la base de données : " + e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                    System.out.println("Connexion fermée avec succès.");
                }
            } catch (SQLException e) {
                System.out.println("Erreur lors de la fermeture de la connexion : " + e.getMessage());
            }
        }
    }
}