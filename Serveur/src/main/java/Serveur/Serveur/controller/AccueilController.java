package Serveur.Serveur.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccueilController {
	
	@RequestMapping(value="/")
    public String accueil () {
		int nb = 0;
		try {
			// Driver pour la base de donnée
			Class.forName("org.postgresql.Driver");
			// Lien vers la base de donnée
			String dbURL = "jdbc:postgresql://ec2-23-21-249-224.compute-1.amazonaws.com:5432/dbrnpln266lldh?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
			// Utilisateur pour se connecter à la base de donnée
			String user = "bxscmxnntkpyvj";
			// Mot de passe pour se connecter à la base de donnée
			String pass = "lOLzLinGoGCDKQ9L7it120aaOi";
			// On crée une connection à la base de donnée
			Connection conn = DriverManager.getConnection(dbURL, user, pass);
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
					ResultSet.CONCUR_READ_ONLY,ResultSet.HOLD_CURSORS_OVER_COMMIT);
			// On exécute la requête afin  de sélectionner toutes les stb
		    ResultSet resultSet = stmt.executeQuery("select * from Stb"); 
		    // On se place à la dernière ligne du résultat
		    resultSet.last();
		    // On récupère le numéro de la ligne
		    nb = resultSet.getRow();
		    // On ferme la connection
		    conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// On retourne une chaîne indiquant le nombre de stb stockées
		return "Vous avez actuellement " + nb + " Stb stockées dans la base de donnée";
    }
}
