package model;

public interface IClient {

	/**
	 * @return 
	 * 	l'entité de l'entreprise
	 */
	public String getEntite();

	/**
	 * Permet de modifier le nom de l'entreprise.
	 * @param entite
	 * 	entité de l'entreprise
	 */
	public void setEntite(String entite);

	/**
	 * @return 
	 * 	Le nom du client de l'entreprise.
	 */
	public String getNom();

	/**
	 * Permet de modifier le nom duc lient de l'entreprise.
	 * @param nom
	 * 	Nom du client de l'entreprise
	 */
	public void setNom(String nom);

	/**
	 * @return 
	 * 	Le prénom du client de l'entreprise.
	 */
	public String getPrenom();

	/**
	 * Permet de modifier le prénom du client de l'entreprise.
	 * @param prenom
	 * 	Le prnom du client de l'entreprise
	 */
	public void setPrenom(String prenom);

	/**
	 * @return 
	 * 	Le pays du client de l'entreprise.
	 */
	public String getPays();

	/**
	 * Permet de modifier le pays du client de l'entreprise.
	 * @param pays
	 * 	Le pays du client de l'entreprise
	 */
	public void setPays(String pays);

	/**
	 * @return 
	 * 	La ville du client de l'entreprise.
	 */
	public String getVille();

	/**
	 * Permet de modifier la ville du client de l'entreprise.
	 * @param ville
	 * 	La ville du client de l'entreprise
	 */
	public void setVille(String ville);

	/**
	 * @return 
	 * 	La rue du client de l'entreprise.
	 */
	public String getRue();

	/**
	 * Permet de modifier la rue du client de l'entreprise.
	 * @param prenom
	 * 	La rue du client de l'entreprise
	 */
	public void setRue(String rue);

	/**
	 * @return 
	 * 	Le code postal du client de l'entreprise.
	 */
	public int getCp();

	/**
	 * Permet de modifier le code postal du client de l'entreprise.
	 * @param cp
	 * 	Le code postal du client de l'entreprise
	 */
	public void setCp(int cp);
}
