package model;

import java.util.List;


public class Fonctionnalite {
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((exigences == null) ? 0 : exigences.hashCode());
		result = prime * result + idFonc;
		result = prime * result + priorite;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fonctionnalite other = (Fonctionnalite) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (exigences == null) {
			if (other.exigences != null)
				return false;
		} else if (!exigences.equals(other.exigences))
			return false;
		if (idFonc != other.idFonc)
			return false;
		if (priorite != other.priorite)
			return false;
		return true;
	}

	private int idFonc;

	private String description;
	
	private int priorite;
	
	private List<Exigence> exigences;

	public Fonctionnalite() {
		
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

	/**
	 * @return the exigences
	 */
	public List<Exigence> getExigences() {
		return exigences;
	}

	/**
	 * @param exigences the exigences to set
	 */
	public void setExigences(List<Exigence> exigences) {
		this.exigences = exigences;
	}

	/**
	 * @return the idFonc
	 */
	public int getIdFonc() {
		return idFonc;
	}

	/**
	 * @param idFonc the idFonc to set
	 */
	public void setIdFonc(int idFonc) {
		this.idFonc = idFonc;
	}
}
