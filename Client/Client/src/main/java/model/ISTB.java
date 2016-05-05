package model;

public interface ISTB {
	/**
	 * @return
	 * 	Le titre de la stb.
	 */
	public String getTitre();
	
	/**
	 * @return
	 * 	La version de la stb.
	 */
	public String getVersion();
	
	/**
	 * @return
	 * 	La date de la stb.
	 */
	public String getDate();
	
	/**
	 * @return
	 * 	La description de la stb.
	 */
	public String getDescription();
	
	/**
	 * @param titre
	 * 	Le titre de la stb.
	 */
	public void setTitre(String titre);

	/**
	 * @param version
	 * 	La version de la stb.
	 */
	public void setVersion(String version);

	/**
	 * @param date
	 * 	La date de la stb.
	 */
	public void setDate(String date);
	
	/**
	 * @param description
	 * 	La description de la stb.
	 */
	public void setDescription(String description);
}
