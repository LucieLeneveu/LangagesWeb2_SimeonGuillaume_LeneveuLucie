package model;


public class Exigence {
	
	private int id;
	
	private String description;
	
	private int priorite;
	
	public Exigence() {
		
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the priorite
	 */
	public int getPriorite() {
		return priorite;
	}

	/**
	 * @param priorite the priorite to set
	 */
	public void setPriorite(int priorite) {
		this.priorite = priorite;
	}
}
