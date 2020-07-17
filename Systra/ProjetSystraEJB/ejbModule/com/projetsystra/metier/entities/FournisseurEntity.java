package com.projetsystra.metier.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.Table;

@NamedStoredProcedureQueries({@NamedStoredProcedureQuery(name="getAllFournisseur",procedureName="GET_ALL_FOURNISSEURS",resultClasses=FournisseurEntity.class)})
@Entity
@Table(name="tb_Fournisseur")
public class FournisseurEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="Fournisseur_id")
	private String FournisseurId;
	public FournisseurEntity(String fournisseurId) {
		super();
		FournisseurId = fournisseurId;
	}
	@Column(name="Fournisseur_nom")
	private String FournisseurNom;
	@Column(name="Fournisseur_prenom")
	private String FournisseurPrenom;
	@Column(name="Fournisseur_cin_nif")
	private String FournisseurCin_nif;
	@Column(name="Fournisseur_telephone")
	private String FournisseurTelephone;
	@Column(name="Fournisseur_adresse")
	private String FournisseurAdresse;
	@Column(name="Fournisseur_email")
	private String FournisseurEmail;
	@Column(name="Fournisseur_usine")
	private String FournisseurUsine;
	@Column(name="Fournisseur_etat")
	private String FournisseurEtat;
	

	public FournisseurEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FournisseurEntity(String fournisseurId, String fournisseurNom, String fournisseurPrenom,
			String fournisseurCin_nif, String fournisseurTelephone, String fournisseurAdresse, String fournisseurEmail,
			String fournisseurUsine, String fournisseurEtat) {
		super();
		FournisseurId = fournisseurId;
		FournisseurNom = fournisseurNom;
		FournisseurPrenom = fournisseurPrenom;
		FournisseurCin_nif = fournisseurCin_nif;
		FournisseurTelephone = fournisseurTelephone;
		FournisseurAdresse = fournisseurAdresse;
		FournisseurEmail = fournisseurEmail;
		FournisseurUsine = fournisseurUsine;
		FournisseurEtat = fournisseurEtat;
	}
	public String getFournisseurId() {
		return FournisseurId;
	}
	public void setFournisseurId(String fournisseurId) {
		FournisseurId = fournisseurId;
	}
	public String getFournisseurNom() {
		return FournisseurNom;
	}
	public void setFournisseurNom(String fournisseurNom) {
		FournisseurNom = fournisseurNom;
	}
	public String getFournisseurPrenom() {
		return FournisseurPrenom;
	}
	public void setFournisseurPrenom(String fournisseurPrenom) {
		FournisseurPrenom = fournisseurPrenom;
	}
	public String getFournisseurCin_nif() {
		return FournisseurCin_nif;
	}
	public void setFournisseurCin_nif(String fournisseurCin_nif) {
		FournisseurCin_nif = fournisseurCin_nif;
	}
	public String getFournisseurTelephone() {
		return FournisseurTelephone;
	}
	public void setFournisseurTelephone(String fournisseurTelephone) {
		FournisseurTelephone = fournisseurTelephone;
	}
	public String getFournisseurAdresse() {
		return FournisseurAdresse;
	}
	public void setFournisseurAdresse(String fournisseurAdresse) {
		FournisseurAdresse = fournisseurAdresse;
	}
	public String getFournisseurEmail() {
		return FournisseurEmail;
	}
	public void setFournisseurEmail(String fournisseurEmail) {
		FournisseurEmail = fournisseurEmail;
	}
	public String getFournisseurUsine() {
		return FournisseurUsine;
	}
	public void setFournisseurUsine(String fournisseurUsine) {
		FournisseurUsine = fournisseurUsine;
	}
	public String getFournisseurEtat() {
		return FournisseurEtat;
	}
	public void setFournisseurEtat(String fournisseurEtat) {
		FournisseurEtat = fournisseurEtat;
	}
	
	
	
}
