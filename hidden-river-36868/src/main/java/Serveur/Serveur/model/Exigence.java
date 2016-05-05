package Serveur.Serveur.model;

public class Exigence implements IExigence {
	/**
	 * L'identifiant de l'exigence.
	 */
	private int id;
	/**
	 * La description de l'exigence.
	 */
	private String description;
	/**
	 * La priorité de l'exigence.
	 */
	private int priorite;
	
	public Exigence() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getPriorite() {
		return priorite;
	}

	public void setPriorite(int priorite) {
		this.priorite = priorite;
	}
}
