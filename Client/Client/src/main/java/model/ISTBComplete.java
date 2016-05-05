package model;

import java.util.List;

public interface ISTBComplete {
	/**
	 * @return the id
	 */
	public int getId();

	/**
	 * @param id the id to set
	 */
	public void setId(int id);

	/**
	 * @return the titre
	 */
	public String getTitre();

	/**
	 * @param titre the titre to set
	 */
	public void setTitre(String titre);

	/**
	 * @return the version
	 */
	public String getVersion();

	/**
	 * @param version the version to set
	 */
	public void setVersion(String version);

	/**
	 * @return the date
	 */
	public String getDate();

	/**
	 * @param date the date to set
	 */
	public void setDate(String date);

	/**
	 * @return the description
	 */
	public String getDescription();

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description);

	/**
	 * @return the commentaire
	 */
	public String getCommentaire();

	/**
	 * @param commentaire the commentaire to set
	 */
	public void setCommentaire(String commentaire);

	/**
	 * @return the client
	 */
	public Client getClient();

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client);

	/**
	 * @return the membres
	 */
	public List<Membre> getMembres();

	/**
	 * @param membres the membres to set
	 */
	public void setMembres(List<Membre> membres);

	/**
	 * @return the fonctionnalites
	 */
	public List<Fonctionnalite> getFonctionnalites();

	/**
	 * @param fonctionnalites the fonctionnalites to set
	 */
	public void setFonctionnalites(List<Fonctionnalite> fonctionnalites);
}
