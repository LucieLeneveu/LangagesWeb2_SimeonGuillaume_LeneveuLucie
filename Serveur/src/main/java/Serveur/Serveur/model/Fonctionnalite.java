package Serveur.Serveur.model;

import java.util.List;

public class Fonctionnalite implements IFonctionnalite {
	/**
	 * Identifiant de la fonctionnalité.
	 */
	private int idFonc;
	/**
	 * Description de la fonctionnalité.
	 */
	private String description;
	/**
	 * Priorité de la fonctionnalité.
	 */
	private int priorite;
	/**
	 * Liste des exigences de la focntionnalité.
	 */
	private List<Exigence> exigences;

	public Fonctionnalite() {
		
	}
	
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

	public List<Exigence> getExigences() {
		return exigences;
	}

	public void setExigences(List<Exigence> exigences) {
		this.exigences = exigences;
	}

	public int getIdFonc() {
		return idFonc;
	}

	public void setIdFonc(int idFonc) {
		this.idFonc = idFonc;
	}
}
