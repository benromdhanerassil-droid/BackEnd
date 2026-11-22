package com.rassil.watche.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class StyleDeMontre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idStyle;
	private String nomStyle;
	private String descriptionStyle;

	@JsonIgnore
	@OneToMany(mappedBy = "styleDeMontre")
	private List<Watche> watches;

	public StyleDeMontre() {
		super();
	}

	public StyleDeMontre(String nomStyle, String descriptionStyle) {
		super();
		this.nomStyle = nomStyle;
		this.descriptionStyle = descriptionStyle;
	}

	public Long getIdStyle() {
		return idStyle;
	}

	public void setIdStyle(Long idStyle) {
		this.idStyle = idStyle;
	}

	public String getNomStyle() {
		return nomStyle;
	}

	public void setNomStyle(String nomStyle) {
		this.nomStyle = nomStyle;
	}

	public String getDescriptionStyle() {
		return descriptionStyle;
	}

	public void setDescriptionStyle(String descriptionStyle) {
		this.descriptionStyle = descriptionStyle;
	}

	public List<Watche> getWatches() {
		return watches;
	}

	public void setWatches(List<Watche> watches) {
		this.watches = watches;
	}

	@Override
	public String toString() {
		return "StyleDeMontre [idStyle=" + idStyle + ", nomStyle=" + nomStyle + ", descriptionStyle=" + descriptionStyle + "]";
	}
}
