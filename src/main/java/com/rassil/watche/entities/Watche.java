package com.rassil.watche.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Watche {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idwatche;
	private String nomWatche;
	private Double prixWatches;
	private Date dateCreation;
	private String typeMouvement;

	@ManyToOne
	private StyleDeMontre styleDeMontre;

	public Watche() {
		super();
	}

	public Watche(String nomWatche, Double prixWatches, Date dateCreation) {
		super();
		this.nomWatche = nomWatche;
		this.prixWatches = prixWatches;
		this.dateCreation = dateCreation;
	}

	public Long getIdwatche() {
		return idwatche;
	}

	public void setIdwatche(Long idwatche) {
		this.idwatche = idwatche;
	}

	public String getNomWatche() {
		return nomWatche;
	}

	public void setNomWatche(String nomWatche) {
		this.nomWatche = nomWatche;
	}

	public Double getPrixWatches() {
		return prixWatches;
	}

	public void setPrixWatches(Double prixWatches) {
		this.prixWatches = prixWatches;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getTypeMouvement() {
		return typeMouvement;
	}

	public void setTypeMouvement(String typeMouvement) {
		this.typeMouvement = typeMouvement;
	}

	public StyleDeMontre getStyleDeMontre() {
		return styleDeMontre;
	}

	public void setStyleDeMontre(StyleDeMontre styleDeMontre) {
		this.styleDeMontre = styleDeMontre;
	}

	@Override
	public String toString() {
		return "Watche [idwatche=" + idwatche + ", nomWatche=" + nomWatche + ", prixWatches=" + prixWatches
				+ ", dateCreation=" + dateCreation + ", styleDeMontre=" + styleDeMontre + "]";
	}
}
