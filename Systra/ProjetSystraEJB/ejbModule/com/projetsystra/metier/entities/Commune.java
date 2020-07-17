package com.projetsystra.metier.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_communes")
public class Commune {

	@Id
	@Column(name="Id_commune")
	private String IdCommune;
	@Column(name="Nom_commune")
	private String NomCommune;
	
	@ManyToOne
	@JoinColumn(name="Id_departement")
	private Departement departement;
	public Commune() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Commune(String idCommune, String nomCommune, Departement departement) {
		super();
		IdCommune = idCommune;
		NomCommune = nomCommune;
		this.departement = departement;
	}

	public Commune(String idCommune) {
		super();
		IdCommune = idCommune;
	}



	public String getIdCommune() {
		return IdCommune;
	}

	public void setIdCommune(String idCommune) {
		IdCommune = idCommune;
	}

	public String getNomCommune() {
		return NomCommune;
	}

	public void setNomCommune(String nomCommune) {
		NomCommune = nomCommune;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	
}
