package model;

/**
 * Définit un client.
 *
 */
public interface IClient {
	/**
	 * @return the entite
	 */
	public String getEntite();

	/**
	 * @param entite the entite to set
	 */
	public void setEntite(String entite);

	/**
	 * @return the nom
	 */
	public String getNom();

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom);

	/**
	 * @return the prenom
	 */
	public String getPrenom();

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom);

	/**
	 * @return the country
	 */
	public String getPays();

	/**
	 * @param pays : set the country
	 */
	public void setPays(String pays);

	/**
	 * @return the town
	 */
	public String getVille();

	/**
	 * @param ville : set the town
	 */
	public void setVille(String ville);

	/**
	 * @return street
	 */
	public String getRue();

	/**
	 * @param rue : set street
	 */
	public void setRue(String rue);

	/**
	 * @return cp
	 */
	public int getCp();

	/**
	 * @param cp : set cp
	 */
	public void setCp(int cp);
}
