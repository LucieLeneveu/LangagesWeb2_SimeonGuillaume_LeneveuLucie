package model;

public interface ISTB {

	/**
	 * @return title of STB
	 */
	public String getTitre();
	
	/**
	 * @return version of STB
	 */
	public String getVersion();
	
	/**
	 * @return date of STB
	 */
	public String getDate();
	
	/**
	 * @return description of STB
	 */
	public String getDescription();
	
	/**
	 * @param titre : set title of STB
	 */
	public void setTitre(String titre);

	/**
	 * @param version : set version of STB
	 */
	public void setVersion(String version);

	/**
	 * @param date : set date of STB
	 */
	public void setDate(String date);
	
	/**
	 * @param description : set description of STB
	 */
	public void setDescription(String description);
}
