package Client.Client;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;

import model.Exigence;
import model.Fonctionnalite;
import model.Liste;
import model.Membre;
import model.STBComplete;

import org.springframework.web.client.RestTemplate;

public class App {
	/**
	 * Longueur de la fenêtre.
	 */
	private static final int FRAME_WIDTH = 1200;
	/**
	 * Hauteur de la fenêtre.
	 */
	private static final int FRAME_HEIGHT = 1000;
	/**
	 * La fenêtre de l'application.
	 */
	private JFrame mainFrame;
	/**
	 * Bouton permettant d'afficher toutes les stb.
	 */
	private JButton listesStb;
	/**
	 * Permet d'entrer l'identifiant de la stb voulu.
	 */
	private JTextField stbNumber;
	/**
	 * Permet d'affciher une stb avec un identifiant donné.
	 */
	private JButton resumeStb;
	/**
	 * Permer de faire défiler le text area.
	 */
	private JScrollPane jsp;
	/**
	 * Contiendra le chemin du fichier de la stb a ajouter.
	 */
	private JTextField pathStb;
	/**
	 * Permet de sélectionner la stb.
	 */
	private JButton parcourir;
	/**
	 * Permet d'ajouter la stb.
	 */
	private JButton ajouter;
	/**
	 * Fichier que l'on souhaite ajouter.
	 */
	private File file;
	/**
	 * Contiendra le résultat de la page d'accueil.
	 */
	static public JLabel accueil;

	/**
	 * Permet de déposer une stb via un formulaire.
	 */
	private JButton deposer;
	/**
	 * EditorPane affichant les informations demandés par le client.
	 */
	private JEditorPane ep;
	/**
	 * Bouton permettant de supprimer une Stb
	 */
	private JButton delete;
	/**
	 * JTextField permettant de sélectionner la Stb à supprimer.
	 */
	private JTextField stbNumber2;
	/**
	 * Fenetre du formulaire d'ajout de Stb
	 */
	private Formulaire form;
	
	// CONSTRUCTEURS
	/**
	 * Une application java.
	 */
	public App() {
	    createView();
	    placeComponents();
	    createController();
	}
	
	// COMMANDES
	/**
	 * Rend l'application visible au centre de l'écran.
	 */
	public void display() {
	    mainFrame.pack();
	    mainFrame.setLocationRelativeTo(null);
	    mainFrame.setVisible(true);
	}

	
	// OUTILS	
	private void createView() {
		// Fenêtre de l'application principale
	    mainFrame = new JFrame("Langages web 2");
	    // Dimension de la fenêtre principale
	    mainFrame.setPreferredSize(new 
	    		Dimension(FRAME_WIDTH, FRAME_HEIGHT));
	    // Bouton permettant d'afficher toutes les stb présentes dans la
	    // base de donnée
	    listesStb = new JButton("Afficher toutes les Stb");
	    // Permet de donner le numéro de la stb que l'on souhaite afficher
		stbNumber = new JTextField(3);
		// Permet d'afficher une stb suivant son identifiant
		resumeStb  = new JButton("Afficher la Stb");
		// Permet de voir les informations 
		ep = new JEditorPane();
		ep.setEditable(false);
		ep.setContentType("text/html");
		// Associe un HTMLEditorKit au pane afin de gérer le CSS
		HTMLEditorKit kit = new HTMLEditorKit();
		ep.setEditorKit(kit);
		// Ajout des règles CSS
		StyleSheet styleSheet = kit.getStyleSheet();
		styleSheet.addRule(" .responstable {"
				+	  "margin: 1em 0;"
				+	  "width: 100%;"
				+	  "overflow: hidden;"
				+	  "background: white;"
				+	  "border-radius: 10px;"
				+	  "border: 1px solid #167F92;"
				+	"}");
		styleSheet.addRule(".fonc {"
				+ "background-color: #E8E8E8; } ");
		styleSheet.addRule("div.img {"
				+ "position: absolute;"
				+ "text-align: center;"
				+ "margin: 5px;"
				+ "border: 1px solid #ccc;"
				+ "float: left;"
				+ "width: 100px;"
				+ "}");
		styleSheet.addRule("div.desc {"
				+ "padding: 5px;"
				+ "text-align: center;"
				+ "}");
		styleSheet.addRule("h1, h2 {text-align:center;}");
		styleSheet.addRule(".logo {float:right;}");
		styleSheet.addRule(".stb, .client {text-decoration: underline;");
		styleSheet.addRule(".afficheAll {border: 1px solid black;");
		//Scrollpane de l'editorPane
		jsp = new JScrollPane(ep);
		// Permet d'afficher le chemin du fichier de la stb choisie
		pathStb = new JTextField(20);
		// Permet de ne pas pouvoir modifier le chemin de la stb
		pathStb.setEditable(false);
		// Permet de sélectionner le fichier de la stb
		parcourir = new JButton("Parcourir ...");
		// Permet d'ajouter la stb à la base de donnée
		ajouter = new JButton("Ajouter la Stb");
		// Fichier de la stb
		file = null;
		// Permet de déposer une stb via un formulaire
		deposer = new JButton("Ouvrir le formulaire");
		// Permet de récupérer le nombre de stb présent dans la base de donnée
//		final String uri = "http://localhost:8080/";
		final String uri = "https://hidden-river-36868.herokuapp.com/";
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class);
		accueil = new JLabel(result);
		// Permet de supprimer une Stb
		delete = new JButton("Supprimer la STB");
		// Permet de sélectionner une Stb à supprimer
		stbNumber2 = new JTextField(3);
		// On crée le formulaire
		form = new Formulaire();
	}
	
	/**
	 * Permet de placer tous les composants sur la fenêtre principale (mainframe)
	 */
	private void placeComponents() {
		JPanel p = new JPanel(new GridLayout(3, 2)); {
			JPanel q = new JPanel(); {
				q.add(new JLabel("Bienvenue sur l'application de Siméon Guillaume et Leneveu Lucie"));
			}
			p.add(q, BorderLayout.CENTER);
			q = new JPanel(); {
				q.add(accueil);
			}
			p.add(q, BorderLayout.CENTER);
		}
		mainFrame.add(p, BorderLayout.NORTH);
		p.add(jsp);
		mainFrame.add(jsp, BorderLayout.CENTER);
		
		p = new JPanel(new BorderLayout()); {
			JPanel t = new JPanel(new GridLayout(2, 2)); {
				JPanel q = new JPanel(); {
					q.add(new JLabel("Afficher toutes les STBs présentes dans la base : "));
					q.add(listesStb);
				}
				t.add(q);
				
				q = new JPanel(new GridLayout(1, 1)); {
					JPanel r = new JPanel(); {
						r.add(new JLabel("Choisissez le numéro de la STB que vous souhaitez afficher : "));
						r.add(stbNumber);
						r.add(resumeStb);
					}
					q.add(r);
				}
				t.add(q);
				q = new JPanel(new GridLayout(1, 1)); {
					JPanel r = new JPanel(); {
						r.add(new JLabel("Déposer une Stb personnalisée en remplissant un formulaire : "));
						r.add(deposer);
					}
					q.add(r);
				}
				t.add(q);
				q = new JPanel(new GridLayout(1, 1)); {
					JPanel r = new JPanel(); {
						r.add(new JLabel("Choisissez le numéro de la STB que vous souhaitez supprimer : "));
						r.add(stbNumber2);
						r.add(delete);
					}
					q.add(r);
				}
				t.add(q);
			}
			p.add(t, BorderLayout.NORTH);
			JPanel q = new JPanel(new GridLayout(1, 3)); {
				JPanel r = new JPanel(); {
					r.add(new JLabel("Veuillez choisir la stb au format xml que vous souhaitez enregistrer : "));
					r.add(pathStb);
					r.add(parcourir);
					r.add(ajouter);
				}
				q.add(r);
			}
			p.add(q, BorderLayout.SOUTH);
		}
		mainFrame.add(p, BorderLayout.SOUTH);
	}
		
	/**
	 * On associe une action à chacun des boutons.  
	 */
	private void createController() {
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Permet d'afficher toutes les stb
		listesStb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// URL que l'on utilise pour envoyer la requête
//				final String uri = "http://localhost:8080/resume";
				final String uri = "https://hidden-river-36868.herokuapp.com/resume";
				// Création du RestTemplate permettant l'envoie et la récupération 
				// de la requête
			    RestTemplate restTemplate = new RestTemplate();
			    // Envoie et récupération du résultat
			    Liste result = restTemplate.getForObject(uri, Liste.class);
			    
			    // Affichage dans l'editorPane
			    ep.setText("");
			    // Si le résultat renvoie une liste vide (ie, aucune STB enregistrée en base)
			    if (result.getStbs() == null) {
			    	// On le signifie au client en écrivant le message sur l'editorPane
			    	StringBuilder sb = new StringBuilder();
			    	sb.append("<h1>Aucune STB présente dans la base de données</h1>");
			    	ep.setText(sb.toString());
			    } else {
			    	StringBuilder t = new StringBuilder();
			    	// Sinon, on affiche chacune des STB sous forme HTML
				    for (int i = 0; i < result.getStbs().size(); ++i) {
				    	t.append("<table style=\"border: 1px black solid; width: 250px; text-align: center;\"><tr><th colspan=\"2\" style=\"text-align: center;\">STB n°" + (i+1) + "</p>" 
				    			+ "<tr><td class=\"afficheAll\">Titre : </td><td class=\"afficheAll\">" + result.getStbs().get(i).getTitre()
				    			+ "</td></tr><td class=\"afficheAll\">Date : </td><td class=\"afficheAll\">" + result.getStbs().get(i).getDate() 
				    			+ "</td></tr><td class=\"afficheAll\">Version : </td><td class=\"afficheAll\">" + result.getStbs().get(i).getVersion()
				    			+ "</td></tr><td class=\"afficheAll\">Description : </td><td class=\"afficheAll\">" + result.getStbs().get(i).getDescription() 
				    			+ "</td></tr></table>"
				    			+ "<br>");
				    }
				    ep.setText(t.toString());
			    }
			}
		});
		
		// Permet d'afficher une stb complète
		resumeStb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// On récupère la valeur entré par l'utilisateur
				String number = stbNumber.getText();
				try {
					// Si la conversion en int ne génère aucune erreur
					Integer.parseInt(number);
					// Si l'identifiant est supérieur à 1
					if(Integer.parseInt(number) >= 1) {
						// URL que l'on utilise pour envoyer la requête
//						final String uri = "http://localhost:8080/resume/" + number;
						final String uri = "https://hidden-river-36868.herokuapp.com/resume/" + number;
						// Création d'une map qui contiendra l'identifiant de 
						// la stb à récupérer
					    Map<String, String> params = new HashMap<String, String>();
					    // Ajout de l'identifiant de la stb voulue
					    params.put("id", number);
					    // Création du RestTemplate permettant l'envoie et la récupération 
						// de la requête 
					    RestTemplate restTemplate = new RestTemplate();
					    // Envoie et récupération du résultat
					    STBComplete result = restTemplate.getForObject(uri, STBComplete.class, params);    
					    ep.setText("");
					    // Si la STB est vide
					    if (result.getTitre() == null) {
					    	// On le signifie au client en écrivant un message sur l'editorPane
					    	StringBuilder sb = new StringBuilder();
					    	sb.append("<html><body><h1>STB non trouvée</h1></body></html>");
					    	ep.setText(sb.toString());
					    	
					    } else {
					    	// Sinon, on affiche la STB complète
						    ep.setText(afficherStbComplete(result).toString());
					    }
					// Si l'utilisateur entre un id invalide, on affiche un message d'erreur
					} else {
						JOptionPane.showMessageDialog(null, "Numéro de Stb invalide", "Format invalide", 1);
					}
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Numéro de Stb invalide", "Format invalide", 1);
				}
			}
		});
		
		// Permet de supprimer une STB selon son id
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// On récupère l'id entré par l'utilisateur
				String number = stbNumber2.getText();
				try {
					Integer.parseInt(number);
					// Si l'id entré est correct
					if(Integer.parseInt(number) >= 1) {
						// URL que l'on utilise pour envoyer la requête
//						final String uri = "http://localhost:8080/delete/" + number;
						final String uri = "https://hidden-river-36868.herokuapp.com/delete/" + number;
						// Création d'une map qui contiendra l'identifiant de 
						// la stb à récupérer 
					    Map<String, String> params = new HashMap<String, String>();
					    params.put("id", number);
					    // Création du RestTemplate permettant l'envoie et la récupération 
						// de la requête 
					    RestTemplate restTemplate = new RestTemplate();
					    String result = restTemplate.getForObject(uri, String.class, params);
					    // Si la STB est présente dans la base de donnée
					    if (result.equals("true")) {
					    	// On affiche un message pour signifier à l'utilisateur
					    	// qu'elle a bien été supprimée
					    	JOptionPane.showMessageDialog(null, "Stb supprimée avec succès", "Suppression Stb", 1);
					    	// On récupère le nombre de STB présente en base
					    	restTemplate = new RestTemplate();
//					    	String uri2 = "http://localhost:8080/";
							final String uri2 = "https://hidden-river-36868.herokuapp.com/";
						    result = restTemplate.getForObject(uri2, String.class);
						    // Et on met à jour l'affichage de nombre de STB
					    	accueil.setText(result);
					    } else {
					    	// Sinon, on signifie à l'utilisateur que la STB qu'il souhaite supprimer
					    	// n'existe pas
					    	JOptionPane.showMessageDialog(null, "La STB que vous souhaitez supprimer n'existe pas.", "Suppression Stb", 1);
					    }
					// Sinon, si l'utilisateur entre un id invalide, on affiche un message d'erreur
					} else {
						JOptionPane.showMessageDialog(null, "Numéro de Stb invalide", "Format invalide", 1);
					}
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Numéro de Stb invalide", "Format invalide", 1);
				}
			}
		});
		
		// Permet de choisir un fichier xml
		parcourir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// On crée une fenêtre de sélection de fichier
				JFileChooser j = new JFileChooser();
				int v = j.showOpenDialog(mainFrame);
				// Si on a appuyer sur ouvrir
	    		if (v == JFileChooser.APPROVE_OPTION) {
	    			file = j.getSelectedFile();
	    			// On affiche le chemin du fichier dans le text field
	    			pathStb.setText(file.getAbsolutePath());
	    		}
			}
		});
		
		// Permet d'ajouter un fichier xml à la base de donnée
		ajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// URL que l'on utilise pour envoyer la requête
//    			final String uri = "http://localhost:8080/depot";
				final String uri = "https://hidden-river-36868.herokuapp.com/depot";
    			// On sépare le nom du fichier selon le caractère '.'
    			String[] tab = file.getName().split("\\.");
    			// Si le fichier est bien au format xml
    			if (tab[tab.length - 1].equals("xml")) {
					try {
						// On crée un file reader permetttant de lire dans le fichier
						FileReader fr = new FileReader(file);
						// On crée un buffered reader sur ce file reader
						BufferedReader br = new BufferedReader(fr);
						// On crée la chaîne contenant le contenue du fichier
						String contain = "";
					    String s = null;
					    // Tant que l'on arrive à lire dans le fichier
					    while ((s = br.readLine()) != null) {
					    	contain += s;
					    }
					    // On ferme notre buffer et notre FileReader
					    br.close();
					    fr.close();
						JOptionPane.showMessageDialog(null, contain);
					    // Création du RestTemplate permettant l'envoie et la récupération 
						// de la requête
					    RestTemplate restTemplate = new RestTemplate();
					    String result = restTemplate.postForObject(uri, contain, String.class);
					    // Si la stb a bien été ajoutée à la base de donnée
					    if (result.equals("true")) {
					    	// Affichage d'un message d'information indiquant que 
					    	// l'ajout de la stb à bien été effectué
					    	JOptionPane.showMessageDialog(null, "Ajout de la nouvelle Stb réussi", "Ajout d'une STB", 1);
					    	// On récupère le nouveau nombre de STB présente en base
					    	restTemplate = new RestTemplate();
//					    	String uri2 = "http://localhost:8080/";
							final String uri2 = "https://hidden-river-36868.herokuapp.com/";
						    result = restTemplate.getForObject(uri2, String.class);
					    	// Et on met à jour l'affichage sur la page d'accueil
						    accueil.setText(result);
					    } else {
					    	// Affichage d'un message indiquant que la stb n'est pas au bon format
					    	JOptionPane.showMessageDialog(null, "La Stb que vous souhaitez ajouter n'est pas au bon format", "Ajout d'une STB", 1);
					    }
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				// Si le fichier n'est pas au bon format
    			} else {
    				// Affichage d'un message d'erreur
    				JOptionPane.showMessageDialog(null, "Le fichier doit être au format xml", "Format invalide", 1);
    			}
			}
		});
		
		// Permet d'ouvrir une nouvelle fenêtre permettant l'ajout d'une STB
		// via un formulaire
		deposer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				form.display2();
			}
		});
	}
	
	/**
	 * @param stb STBComplete
	 * @return StringBuilder
	 */
	private StringBuilder afficherStbComplete(STBComplete stb) {
		// On crée un StringBuilder affin de créer notre chaine qui formera notre STB
		StringBuilder sb = new StringBuilder();
		// On ajout à notre StringBuilder les informations générales de la STB sous format HTML
		sb.append("<html><body><h1>Spécification Techniques des Besoins n°" + stb.getId() + "</h1>");
		sb.append("<div style=\"text-align: center\">"
					+ "<h2>" + stb.getTitre() + "</h2>"
					+ "<br><br>"
					+ "<table style=\"border: 1px solid black; width: 300px;\">"
						+ "<tr><td class=\"stb\" >Date : </td><td>" + stb.getDate() + "</td></tr>"
						+ "<tr><td class=\"stb\">Version : </td><td> " + stb.getVersion() + "</td></tr>"
						+ "<tr><td class=\"stb\">Description : </td><td>" + stb.getDescription() + "</td></tr>"
					+ "</table>"
				+ "</div><br>"
				+ "<hr>");
		// On ajoute ensuite les informations du client
		sb.append("<h2>Informations du client</h2>");
		sb.append("<table style=\"width: 300px;\">"
				+ "<tr><td class=\"client\">Entreprise : </td><td>" + stb.getClient().getEntite() + "</td></tr>"
				+ "<tr><td class=\"client\">Nom : </td><td>" + stb.getClient().getNom() + "</td></tr>"
				+ "<tr><td class=\"client\">Prénom : </td><td>" + stb.getClient().getPrenom() + "</td></tr>"
				+ "<tr><td class=\"client\">Adresse : </td><td>" + stb.getClient().getRue() + ", " + stb.getClient().getCp() + ", "
						+ stb.getClient().getVille() + ", " + stb.getClient().getPays() + "</td></tr>"
				+ "</table><br><hr><br>");
		// Puis les informations sur les membres
		sb.append("<h2>Membres du projet</h2>");
		sb.append("<table><tr>");
		for (Membre membre : stb.getMembres()) {
			String gender; 
			if(!membre.isGenre()){
				gender = "madame.png"; 
			} else {
				gender = "monsieur.png";
			}
			URL url = getClass().getResource(gender);
			sb.append("<td><div class=\"img\">"
						+ "<img src=\"" + url + "\">" 
						+ "<div class=\"desc\">" + membre.getNom() + " <br> " + membre.getPrenom() + "</div>" 
					+ "</td>");
		}
		sb.append("</tr></table><hr>");
//		System.out.println(sb.toString());
		sb.append("<br>");
		// Et enfin les informations sur les fonctionnalités et les exigences
		sb.append("<h2>Fonctionnalités et Exigences</h2>");
		sb.append("<table class=\"responstable\" border=\"1\">");
		sb.append("<tr>"
				+ "<th>Fonctionnalités</th>"
				+ "<th>Exigences</th>"
				+ "</tr>");
		for (Fonctionnalite fonc : stb.getFonctionnalites()) {
			sb.append("<td><table class=\"responstable\">"
						+ "<tr>"
							+ "<th>ID</th>"
							+ "<th>Description</th>"
							+ "<th>Priorité</th>"
						+ "</tr>"
						+ "<tr>"
							+ "<td class=\"fonc\">" + fonc.getIdFonc() + "</td>"
							+ "<td class=\"fonc\">" + fonc.getDescription() + "</td>"
							+ "<td class=\"fonc\">" + fonc.getPriorite() + "</td>"
						+ "</tr></table></td>"
						+ "<td>"
						+ "<table class=\"responstable\">"
							+ "<tr>"
								+ "<th>ID</th>"
								+ "<th>Description</th>"
								+ "<th>Priorité</th>"
							+ "</tr>");
			for (Exigence exigence : fonc.getExigences()) {
				sb.append("<tr>"
						+ "<td class=\"fonc\">" + exigence.getId() + "</td>"
						+ "<td class=\"fonc\">" + exigence.getDescription() + "</td>"
						+ "<td class=\"fonc\">" + exigence.getPriorite() + "</td></tr>");
			}
			sb.append("</table></td></tr>");
		}
//	    s += "\n     Commentaire : " + stb.getCommentaire();
		sb.append("</table><br><hr>"
				+ "<h2>Commentaire</h2>"
				+ "<p>" + stb.getCommentaire() + "</p>"
				+ "</body></html>");
		return sb;
	}
	
	// POINT D'ENTREE
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	            new App().display();
	        }
	    });
	}
}
