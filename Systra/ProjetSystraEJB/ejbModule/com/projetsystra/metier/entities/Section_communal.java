package com.projetsystra.metier.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_section_communal")
public class Section_communal {
	@Id
	@Column(name="Id_sectionCommunal")
	private String SectionCommunal;
	
	@Column(name="nom_sectionCommunal")
	private String NomSectionCommunal;
	
	@ManyToOne
	@JoinColumn(name="Id_commune")
	private Commune commune;

	public Section_communal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Section_communal(String sectionCommunal) {
		super();
		SectionCommunal = sectionCommunal;
	}

	public Section_communal(String sectionCommunal, String nomSectionCommunal, Commune commune) {
		super();
		SectionCommunal = sectionCommunal;
		NomSectionCommunal = nomSectionCommunal;
		this.commune = commune;
	}

	public String getSectionCommunal() {
		return SectionCommunal;
	}

	public void setSectionCommunal(String sectionCommunal) {
		SectionCommunal = sectionCommunal;
	}

	public String getNomSectionCommunal() {
		return NomSectionCommunal;
	}

	public void setNomSectionCommunal(String nomSectionCommunal) {
		NomSectionCommunal = nomSectionCommunal;
	}

	public Commune getCommune() {
		return commune;
	}

	public void setCommune(Commune commune) {
		this.commune = commune;
	}

	
	
	
}
