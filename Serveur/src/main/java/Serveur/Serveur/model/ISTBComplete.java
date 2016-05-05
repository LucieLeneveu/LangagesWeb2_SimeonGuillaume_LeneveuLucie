package Serveur.Serveur.model;

import java.util.List;

public interface ISTBComplete {
	/**
	 * @return 
	 * 	L'identifiant de la stb.
	 */
	public int getId();

	/**
	 * @param id
	 * 	L'identifiant à ajouté.
	 */
	public void setId(int id);

	/**
	 * @return 
	 * 	Le titre de la stb.
	 */
	public String getTitre();

	/**
	 * @param titre
	 * 	Le titre à ajouté.
	 */
	public void setTitre(String titre);

	/**
	 * @return 
	 * 	La version de la stb.
	 */
	public String getVersion();

	/**
	 * @param version
	 * 	La version à ajouté.
	 */
	public void setVersion(String version);

	/**
	 * @return
	 * 	La date de la stb.
	 */
	public String getDate();

	/**
	 * @param date
	 * 	La date à ajouté.
	 */
	public void setDate(String date);

	/**
	 * @return
	 * 	La description de la stb.
	 */
	public String getDescription();

	/**
	 * @param description
	 * 	La description à ajouté.
	 */
	public void setDescription(String description);

	/**
	 * @return 
	 * 	Le commentaire de la stb.
	 */
	public String getCommentaire();

	/**
	 * @param commentaire
	 * 	Le commentaire à ajouté.
	 */
	public void setCommentaire(String commentaire);

	/**
	 * @return
	 * 	Le client de la stb.
	 */
	public Client getClient();

	/**
	 * @param client
	 * 	Le client à ajouté.
	 */
	public void setClient(Client client);

	/**
	 * @return 
	 * 	Les membres de la stb.
	 */
	public List<Membre> getMembres();

	/**
	 * @param membres 
	 * 	Les membres à ajouté.
	 */
	public void setMembres(List<Membre> membres);

	/**
	 * @return 
	 * 	Les fonctionnalités de la stb.
	 */
	public List<Fonctionnalite> getFonctionnalites();

	/**
	 * @param fonctionnalites
	 * 	Les fonctionnalités à ajouté.
	 */
	public void setFonctionnalites(List<Fonctionnalite> fonctionnalites);
}
