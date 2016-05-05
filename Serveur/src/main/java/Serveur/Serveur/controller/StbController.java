package Serveur.Serveur.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import Serveur.Serveur.model.Client;
import Serveur.Serveur.model.Exigence;
import Serveur.Serveur.model.Fonctionnalite;
import Serveur.Serveur.model.Liste;
import Serveur.Serveur.model.Membre;
import Serveur.Serveur.model.STB;
import Serveur.Serveur.model.STBComplete;
import Serveur.Serveur.validator.validateXML;

@RestController
public class StbController {
	
	@RequestMapping(value = "/resume")
	public ResponseEntity<Liste> resumeListe() {
		// On crée une liste de stb vide
		Liste liste = new Liste();
		try {
			// Driver de la base de donnée
			Class.forName("org.postgresql.Driver");
			// Lien vers la base de donnée
			String dbURL = "jdbc:postgresql://ec2-23-21-249-224.compute-1.amazonaws.com:5432/dbrnpln266lldh?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
			// Utilisateur de la base de donnée
			String user = "bxscmxnntkpyvj";
			// Mot de passe de la base de donnée
			String pass = "lOLzLinGoGCDKQ9L7it120aaOi";
			// On crée une connection à la base de donnée
			Connection conn = DriverManager.getConnection(dbURL, user, pass);
			Statement stmt = conn.createStatement();
			// On exécute la requête permettant de slectionner toutes les stb dans 
			// la base de donnée
		    ResultSet resultSet = stmt.executeQuery("SELECT * FROM Stb;");
		    // On crée une nouvelle liste de stb
		    List<STB> stbs = new ArrayList<STB>();
		    // Tant qu'il y a une ligne
			while (resultSet.next()) {
				// On crée une nouvelle stb
			  	STB stb = new STB();
			  	// On remplie ses champs avec les valeurs de la lignes de la 
			  	// base de donnée
			    stb.setTitre(resultSet.getString("titre"));
			    stb.setVersion(resultSet.getString("version"));
			    stb.setDate(resultSet.getString("date"));
			    stb.setDescription(resultSet.getString("description"));
			    // On ajoute la stb à la liste
			    stbs.add(stb);
			}
			// On ajoute notre liste de stb à la liste liste
		    liste.setStbs(stbs);
		    // On ferme la connection
		    conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// On renvoie la liste liste
        return new ResponseEntity<Liste>(liste, HttpStatus.OK);
    }
	
	/**
	 * Méthode permettant de récupérer une STB selon son id, dans la 
	 * base de données.
	 * @param id String
	 * @return
	 */
	@RequestMapping(value = "/resume/{id}")
	public ResponseEntity<STBComplete> resumeStb(@PathVariable("id") String id) {
		// On crée une stb
    	STBComplete stb = new STBComplete();
		try {
			// Driver de la base de donnée
			Class.forName("org.postgresql.Driver");
			// Lien vers la base de donnée
			String dbURL = "jdbc:postgresql://ec2-23-21-249-224.compute-1.amazonaws.com:5432/dbrnpln266lldh?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
			// Utilisateur de la base de donnée
			String user = "bxscmxnntkpyvj";
			// Mot de passe de la base de donnée
			String pass = "lOLzLinGoGCDKQ9L7it120aaOi";
			// On se connecte à la base de donnée
			Connection conn = DriverManager.getConnection(dbURL, user, pass);
			Statement stmt = conn.createStatement();
			// On exécute la requête permettant de récupérer les valeurs dans la stb ayant l'id id
		    ResultSet resultSet = stmt.executeQuery("SELECT * FROM Stb WHERE id = " + id + ";");
		    // Si on a pas de résultat alors on renvoie la stb vide
		    if (!resultSet.next()) {
		        return new ResponseEntity<STBComplete>(stb, HttpStatus.OK);
		    }
		    // Sinon on remplie les champs de la stb avec les valeurs de la lignes récupéré
		    // grâce à la requête
		    stb.setId(Integer.parseInt(id));
		    stb.setTitre(resultSet.getString("titre"));
		    stb.setVersion(resultSet.getString("version"));
		    stb.setDate(resultSet.getString("date"));
		    stb.setDescription(resultSet.getString("description"));
		    stb.setCommentaire(resultSet.getString("commentaire"));
		    
		    // On exécute une requête permettant de récupérer le client par rapport 
		    // à l'id de la stb 
		    resultSet = stmt.executeQuery("SELECT * FROM Client WHERE id = " + id + ";");
		    // On se place sur la ligne
		    resultSet.next();
		    // On crée un client
		    Client client = new Client();
		    // On remplie ses champs avec les valeurs récupérées grâce à la requête
		    client.setEntite(resultSet.getString("entite"));
		    client.setNom(resultSet.getString("nom"));
		    client.setPrenom(resultSet.getString("prenom"));
		    client.setPays(resultSet.getString("pays"));
		    client.setVille(resultSet.getString("ville"));
		    client.setRue(resultSet.getString("rue"));
		    client.setCp(Integer.parseInt(resultSet.getString("cp")));
		    // On ajoute le client à la stb
		    stb.setClient(client);
		    
		    // On exécute la requête permettant de récupéré les membres de la stb d'id id
		    resultSet = stmt.executeQuery("SELECT * FROM Membre WHERE id = " + id + ";");
		   // On crée une liste de membre
		    List<Membre> membres = new ArrayList<Membre>();
		    // Pour toutes les ligne sque la requête renvoie
		    while(resultSet.next()) {
		    	// On crée un membre
		    	Membre membre = new Membre();
			    // On remplie ses champs avec les valeurs récupérées grâce à la requête
		    	membre.setNom(resultSet.getString("nom"));
		    	membre.setPrenom(resultSet.getString("prenom"));
		    	membre.setGenre(resultSet.getBoolean("genre"));
		    	// On ajoute ce membre à la liste des membres
		    	membres.add(membre);
		    }
		    // On ajoute la liste de membres à la stb
		    stb.setMembres(membres);
		    
		    // On exécute la requête permettant de récupérer les fonctionnalités
		    // de la stb d'id id 
		    resultSet = stmt.executeQuery("SELECT * FROM Fonctionnalite WHERE id = " + id + ";");
		    // On crée une liste de fonctionnalité
		    List<Fonctionnalite> fonctionnalites = new ArrayList<Fonctionnalite>();
		    // Pour toutes les lignes renvoyées par la requête
		    while (resultSet.next()) {
		    	// On crée une nouvelle fonctionnalite
		    	Fonctionnalite fonctionnalite = new Fonctionnalite();
		    	// On récupère son id
		    	int idFonc = resultSet.getInt("idFonc");
			    // On remplie ses champs avec les valeurs récupérées grâce à la requête
		    	fonctionnalite.setIdFonc(idFonc);
		    	fonctionnalite.setDescription(resultSet.getString("description"));
		    	fonctionnalite.setPriorite(resultSet.getInt("priorite"));
		    	// On crée un liste d'exigences
		    	List<Exigence> exigences = new ArrayList<Exigence>();
		    	Statement stmt2 = conn.createStatement();
		    	// On exécute une requête permettant de récupérer les exigences
		    	// par rapport à l'id id
		    	ResultSet resultSet2 = stmt2.executeQuery("SELECT * FROM Exigence WHERE idfonc = " + idFonc + ";");
		    	// Pour toutes les lignes renvoyées par la requête
		    	while (resultSet2.next()) {
		    		// On crée une nouvelle exigence
		    		Exigence exigence = new Exigence();
				    // On remplie ses champs avec les valeurs récupérées grâce à la requête
		    		exigence.setDescription(resultSet2.getString("description"));
		    		exigence.setPriorite(resultSet2.getInt("priorite"));
		    		exigence.setId(resultSet2.getInt("identifiant"));
		    		// on ajoute cette exigence à la liste des exigences
		    		exigences.add(exigence);
		    	}
		    	// On ajoute les exigences à la fonctionnalité
		    	fonctionnalite.setExigences(exigences);
		    	// On ajoute cette fonctionnalité à la liste des fonctionnalités
		    	fonctionnalites.add(fonctionnalite);
		    }
		    // On ajoute les fonctionnalités à la stb
		    stb.setFonctionnalites(fonctionnalites);
		    // on ferme la connection à la base de donnée
		    conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// On renvoie la stb
        return new ResponseEntity<STBComplete>(stb, HttpStatus.OK);
    }
	
	/**
	 * Méthode permettant de supprimer une STB selon son id,
	 * présente dans la base de données.
	 * @param id String
	 * @return
	 */
	@RequestMapping(value = "/delete/{id}" )
	public ResponseEntity<String> deleteStb(@PathVariable("id") String id) {
		try {
			Class.forName("org.postgresql.Driver");
			String dbURL = "jdbc:postgresql://ec2-23-21-249-224.compute-1.amazonaws.com:5432/dbrnpln266lldh?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
			String user = "bxscmxnntkpyvj";
			String pass = "lOLzLinGoGCDKQ9L7it120aaOi";
			Connection conn = DriverManager.getConnection(dbURL, user, pass);
			Statement stmt = conn.createStatement();
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM Stb WHERE id = " + id + ";");
		    // Si on a pas de résultat alors on renvoie la stb vide
		    if (!resultSet.next()) {
		        return new ResponseEntity<String>("false", HttpStatus.OK);
		    }
			resultSet = conn.createStatement().executeQuery("SELECT * FROM Fonctionnalite WHERE id = " + id + ";");
			// On séletionne l'id des fonctionnalités afin de supprimer d'abord les exigences
			while(resultSet.next()) {
				int idFonc = resultSet.getInt("idFonc");
				// On supprime d'abord les exigences.
				conn.createStatement().execute("DELETE FROM Exigence WHERE idfonc = " + idFonc + ";");
			}
			// On supprime ensuite les fonctionnalités
			conn.createStatement().execute("DELETE FROM Fonctionnalite WHERE id = " + id + ";");
			// On supprime ensuite les membres.
			conn.createStatement().execute("DELETE FROM Membre WHERE id = " + id + ";");
			// On supprime ensuite le client.
			conn.createStatement().execute("DELETE FROM Client WHERE id = " + id + ";");
			// On récupère l'id de la STB qu'on sélectionne
			ResultSet id2 = conn.createStatement().executeQuery("SELECT id FROM Stb WHERE id = " + id + ";");
			int idStb = 0;
			if (id2.next()) {
				idStb = id2.getInt("id");
			}
			System.out.println(idStb);
			ResultSet maxId = conn.createStatement().executeQuery("SELECT MAX(id) FROM Stb;");
			int maxIdStb = 0;
			
			// On met à jour l'id des STBs
			if (maxId.next()) {
				maxIdStb = maxId.getInt("max");
			}
			System.out.println(maxIdStb);
			
			// On supprime enfin la Stb.
			conn.createStatement().execute("DELETE FROM Stb WHERE id = " + id + ";");
			int j = 0;
			for(int i = idStb + 1; i <= maxIdStb; ++i) {
				j = i - 1;
				conn.createStatement().execute("UPDATE Stb SET id = " + j + "WHERE id = "  + i);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return new ResponseEntity<String>("false", HttpStatus.OK);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return new ResponseEntity<String>("false", HttpStatus.OK);
		}
		return new ResponseEntity<String>("true", HttpStatus.OK);
	}
	
	/**
	 * Méthode permettant d'enregistrer une STB dans la base de données.
	 * @param stb String
	 * @return
	 */
	@RequestMapping(value="/depot", method=RequestMethod.POST)
	public ResponseEntity<String> depot(@RequestBody String stb) {
		// On crée un validator qui va nous permettre de valider le document
		validateXML validator = new validateXML();
		// On récupère le document
		Document d = validator.should_validate_with_DOM(stb);
		// si le document est null et que donc le fichier n'est pas valide
		if(validator.should_validate_with_DOM(stb) == null) {
			// On renvoie false
			return new ResponseEntity<String>("false", HttpStatus.OK);
		}
	    try {
			Class.forName("org.postgresql.Driver");
			String dbURL = "jdbc:postgresql://ec2-23-21-249-224.compute-1.amazonaws.com:5432/dbrnpln266lldh?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
			String user = "bxscmxnntkpyvj";
			String pass = "lOLzLinGoGCDKQ9L7it120aaOi";
			// Connection à la base de donnée
			Connection conn = DriverManager.getConnection(dbURL, user, pass);
			Statement stmt = conn.createStatement();
			// On exécute une requête permettant de sélectionner l'id max des stb
			ResultSet resultSet = stmt.executeQuery("SELECT MAX(id) FROM Stb;");
			int id = 1;
			// Si il y a au moins une ligne dans la base 
			if (resultSet.next()) {
				// on récupère cette valeur max 
				id = resultSet.getInt("max");
				// Puis on l'incrémente
				++id;
			}
			
			// On récupère les valeurs des champs de la stb 
			String titre = d.getElementsByTagName("p:Titre").item(0).getTextContent();
			String version = d.getElementsByTagName("p:Version").item(0).getTextContent();
			String date = d.getElementsByTagName("p:Date").item(0).getTextContent();
			String description = d.getElementsByTagName("p:Description").item(0).getTextContent();
			String commentaire = "Pas de commentaire";
			// Si il n'y a pas de commentaire on en met un par défaut 
			if (d.getElementsByTagName("p:Commentaire").getLength() != 0) {
				commentaire = d.getElementsByTagName("p:Commentaire").item(0).getTextContent();
			}
			// On insère dans la table Stb
			System.out.println("INSERT INTO Stb VALUES (" + id 
					+ ", \'" + titre  
					+ "\', \'" + version 
					+ "\', \'" + date  
					+ "\', \'" + description  
					+ "\', \'" + commentaire  
					+ "\');");
			int resultSet2 = stmt.executeUpdate("INSERT INTO Stb VALUES (" + id 
					+ ", \'" + titre  
					+ "\', \'" + version 
					+ "\', \'" + date  
					+ "\', \'" + description  
					+ "\', \'" + commentaire  
					+ "\');");
			
			if (resultSet2 == 0) {
				return new ResponseEntity<String>("false", HttpStatus.OK);
			}
			
			// on récupère les champs du client
			String entite = d.getElementsByTagName("p:entite").item(0).getTextContent();
	        NodeList membre = d.getElementsByTagName("p:Membre").item(0).getChildNodes();
	        String nomClient = membre.item(1).getTextContent();
	        String prenomClient  = membre.item(3).getTextContent();
	        System.out.println("taille adresse : " + d.getElementsByTagName("p:Adresse").item(0).getChildNodes().getLength());
	        
	        // On récupère les champs de l'adresse du client
	        NodeList adresseClient = d.getElementsByTagName("p:Adresse").item(0).getChildNodes();
	        System.out.println("1 :" + adresseClient.item(1).getTextContent());
	        System.out.println("3 :" + adresseClient.item(3).getTextContent());
	        System.out.println("5 :" + adresseClient.item(5).getTextContent());
	        System.out.println("7 :" + adresseClient.item(7).getTextContent());
	        String paysClient = adresseClient.item(1).getTextContent();
	        String villeClient = adresseClient.item(3).getTextContent();
	        String rueClient = adresseClient.item(5).getTextContent();
	        int cpClient = Integer.parseInt(adresseClient.item(7).getTextContent());
	        // On insère dans la table Client 
	        System.out.println("INSERT INTO Client VALUES (\'" 
	        		+ entite
					+ "\', \'" + nomClient
					+ "\', \'" + prenomClient 
					+ "\', " + id 
					+ ", " + cpClient
					+ ", \'" + paysClient
					+ "\', \'" + villeClient
					+ "\', \'" + rueClient
					+ "\');");
	        int resultSet3 = stmt.executeUpdate("INSERT INTO Client VALUES (\'" 
	        		+ entite
					+ "\', \'" + nomClient
					+ "\', \'" + prenomClient 
					+ "\', " + id 
					+ ", " + cpClient
					+ ", \'" + paysClient
					+ "\', \'" + villeClient
					+ "\', \'" + rueClient
					+ "\');");
	        if (resultSet3 == 0) {
				return new ResponseEntity<String>("false", HttpStatus.OK);
			}
	        
	        // Pour chaque membre de l'équipe
			NodeList equipe = d.getElementsByTagName("p:Equipe");
			for (int i = 0; i < equipe.getLength(); ++i) {
				// On récupère les champs 
				String nomEquipe = equipe.item(i).getChildNodes().item(3).getTextContent();
				String genre = equipe.item(i).getChildNodes().item(1).getTextContent();
				String prenomEquipe = equipe.item(i).getChildNodes().item(5).getTextContent();
				// On insère dans la table Membre
				System.out.println("INSERT INTO Membre VALUES (" 
						+ genre
						+ ", \'" + nomEquipe
						+ "\', \'" + prenomEquipe 
						+ "\', " + id + ");");
				int resultSet4 = stmt.executeUpdate("INSERT INTO Membre VALUES (" 
						+ genre
						+ ", \'" + nomEquipe
						+ "\', \'" + prenomEquipe 
						+ "\', " + id + ");");
				if (resultSet4 == 0) {
					return new ResponseEntity<String>("false", HttpStatus.OK);
				}
			}
			
			// Pour chaque fonctionnalité
			NodeList fonctionnalites = d.getElementsByTagName("p:Fonctionnalite");
			for (int i = 0; i < fonctionnalites.getLength(); ++i) {
				// On sélectionne le maximum des id des fonctionnalités
				ResultSet resultSetIdFonc = stmt.executeQuery("SELECT MAX(idfonc) FROM Fonctionnalite;");
				int idFonc = 1;
				// Si il y a au moins une ligne 
				if (resultSetIdFonc.next()) {
					// On récupère la valeur 
					idFonc = resultSetIdFonc.getInt("max");
					// On l'incrémente
					++idFonc;
				}
				// On récupère les valeurs des champs de la fonctionnalités
				String descFonc = fonctionnalites.item(i).getChildNodes().item(1).getTextContent();
				String prioriteFonc = fonctionnalites.item(i).getAttributes().getNamedItem("priorite").getTextContent();
				// On insère dans la table Fonctionnalite
				System.out.println("INSERT INTO Fonctionnalite VALUES (" + idFonc
						+ ", \'" + descFonc 
						+ "\', " + prioriteFonc
						+ ", " + id + ");");
				int resultSet5 = stmt.executeUpdate("INSERT INTO Fonctionnalite VALUES (" + idFonc
						+ ", \'" + descFonc 
						+ "\', " + prioriteFonc
						+ ", " + id + ");");
				if (resultSet5 == 0) {
					return new ResponseEntity<String>("false", HttpStatus.OK);
				}
				// Pour chacune des exigences
				NodeList exigences = fonctionnalites.item(i).getChildNodes();
				for (int j = 3; j < exigences.getLength(); j += 2) {
					// On récupère les valeurs des champs de cette exigence
					String identifiantExigence = exigences.item(j).getChildNodes().item(1).getTextContent();
					String descExigence = exigences.item(j).getChildNodes().item(3).getTextContent();
					String prioriteExigence = exigences.item(j).getChildNodes().item(5).getTextContent();
					// On insère dans la table Exigence
					System.out.println("INSERT INTO Exigence VALUES (" + identifiantExigence
							+ ", \'" + descExigence
							+ "\', " + prioriteExigence
							+ ", " + idFonc + ");");
					int resultSet6 = stmt.executeUpdate("INSERT INTO Exigence VALUES (" + identifiantExigence
							+ ", \'" + descExigence
							+ "\', " + prioriteExigence
							+ ", " + idFonc + ");");
					if (resultSet6 == 0) {
						return new ResponseEntity<String>("false", HttpStatus.OK);
					}
				}
			}
			// On ferme la connection
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// On renvoie la réponse
		return new ResponseEntity<String>("true", HttpStatus.CREATED);
    }
}
