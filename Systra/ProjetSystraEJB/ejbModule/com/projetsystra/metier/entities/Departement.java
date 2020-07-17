package com.projetsystra.metier.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_departement")
public class Departement {
	
	@Id
	@Column(name="Id_departement")
	private String IdDepartement;
	@Column(name="Nom_departement")
	private String NomDepartement;
	
	
	public String getIdDepartement() {
		return IdDepartement;
	}
	public void setIdDepartement(String idDepartement) {
		IdDepartement = idDepartement;
	}
	public String getNomDepartement() {
		return NomDepartement;
	}
	public void setNomDepartement(String nomDepartement) {
		NomDepartement = nomDepartement;
	}
	
}
