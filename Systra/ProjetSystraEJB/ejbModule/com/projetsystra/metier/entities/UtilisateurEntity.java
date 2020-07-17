/**
 * 
 */
package com.projetsystra.metier.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author INGSAMUEL
 *
 */
@Entity
@Table(name="tb_Utilisateur")
public class UtilisateurEntity implements Serializable {

private static final long serialVersionUID = 1L;
@Id
@Column(name="Utilisateur_email")
private String UtilisateurEmail;
@Column(name="Utilisateur_nom")
private String UtilisateurNom;
@Column(name="Utilisateur_prenom")
private String UtilisateurPrenom;
@Column(name="Utilisateur_adresse")
private String UtilisateurAdresse;
@Column(name="Utilisateur_telephone")
private String UtilisateurTelephone;
@Column(name="Utilisateur_fonction")
private String UtilisateurFonction;

@Column(name="Utilisateur_sexe")
private String UtilisateurSexe;

public String getUtilisateurSexe() {
	return UtilisateurSexe;
}

public void setUtilisateurSexe(String utilisateurSexe) {
	UtilisateurSexe = utilisateurSexe;
}
@Column(name="Utilisateur_motdepasse")
private String UtilisateurMotdepasse;
@Column(name="Utilisateur_etatcompte")
private String UtilisateurEtatcompte;

/*@OneToOne(mappedBy="user",fetch=FetchType.EAGER)*/
/*private UserRole iDuserRole;



public UserRole getiDuserRole() {
	return iDuserRole;
}

public void setiDuserRole(UserRole iDuserRole) {
	this.iDuserRole = iDuserRole;
}*/

public UtilisateurEntity() {
	super();
	// TODO Auto-generated constructor stub
}

public UtilisateurEntity(String utilisateurEmail) {
	super();
	UtilisateurEmail = utilisateurEmail;
}

public UtilisateurEntity(String utilisateurEmail, String utilisateurNom, String utilisateurPrenom,
		String utilisateurAdresse, String utilisateurTelephone, String utilisateurFonction,
		String utilisateurMotdepasse, String utilisateurEtatcompte) {
	super();
	UtilisateurEmail = utilisateurEmail;
	UtilisateurNom = utilisateurNom;
	UtilisateurPrenom = utilisateurPrenom;
	UtilisateurAdresse = utilisateurAdresse;
	UtilisateurTelephone = utilisateurTelephone;
	UtilisateurFonction = utilisateurFonction;
	UtilisateurMotdepasse = utilisateurMotdepasse;
	UtilisateurEtatcompte = utilisateurEtatcompte;
/*	this.iDuserRole = iDuserRole;*/
}

public UtilisateurEntity(String utilisateuremail, String utilisateurNom, String utilisateurPrenom,
		String utilisateurSexe,String utilisateurAdresse, String utilisateurTelephone, String utilisateurFonction,
	String utilisateurMotdepasse, String utilisateurEtatcompte) {
	super();
	UtilisateurEmail = utilisateuremail;
	UtilisateurNom = utilisateurNom;
	UtilisateurPrenom = utilisateurPrenom;
	UtilisateurAdresse = utilisateurAdresse;
	UtilisateurTelephone = utilisateurTelephone;
	UtilisateurFonction = utilisateurFonction;
	UtilisateurMotdepasse = utilisateurMotdepasse;
	UtilisateurEtatcompte = utilisateurEtatcompte;
	 UtilisateurSexe= utilisateurSexe;
}

/*public UserRole getiDuserRole() {
	return iDuserRole;
}
public void setiDuserRole(UserRole iDuserRole) {
	this.iDuserRole = iDuserRole;
}*/
/**
 * @return the utilisateurId
 */
public String getUtilisateurEmail() {
	return UtilisateurEmail;
}
/**
 * @param utilisateurId the utilisateurId to set
 */
public void setUtilisateurEmail(String utilisateurId) {
	UtilisateurEmail = utilisateurId;
}
/**
 * @return the utilisateurNom
 */
public String getUtilisateurNom() {
	return UtilisateurNom;
}
/**
 * @param utilisateurNom the utilisateurNom to set
 */
public void setUtilisateurNom(String utilisateurNom) {
	UtilisateurNom = utilisateurNom;
}
/**
 * @return the utilisateurPrenom
 */
public String getUtilisateurPrenom() {
	return UtilisateurPrenom;
}
/**
 * @param utilisateurPrenom the utilisateurPrenom to set
 */
public void setUtilisateurPrenom(String utilisateurPrenom) {
	UtilisateurPrenom = utilisateurPrenom;
}
/**
 * @return the utilisateurAdresse
 */
public String getUtilisateurAdresse() {
	return UtilisateurAdresse;
}
/**
 * @param utilisateurAdresse the utilisateurAdresse to set
 */
public void setUtilisateurAdresse(String utilisateurAdresse) {
	UtilisateurAdresse = utilisateurAdresse;
}
/**
 * @return the utilisateurTelephone
 */
public String getUtilisateurTelephone() {
	return UtilisateurTelephone;
}
/**
 * @param utilisateurTelephone the utilisateurTelephone to set
 */
public void setUtilisateurTelephone(String utilisateurTelephone) {
	UtilisateurTelephone = utilisateurTelephone;
}
/**
 * @return the utilisateurFonction
 */
public String getUtilisateurFonction() {
	return UtilisateurFonction;
}
/**
 * @param utilisateurFonction the utilisateurFonction to set
 */
public void setUtilisateurFonction(String utilisateurFonction) {
	UtilisateurFonction = utilisateurFonction;
}
/**
 * @return the utilisateurPseudo
 */

/**
 * @return the utilisateurMotdepasse
 */
public String getUtilisateurMotdepasse() {
	return UtilisateurMotdepasse;
}
/**
 * @param utilisateurMotdepasse the utilisateurMotdepasse to set
 */
public void setUtilisateurMotdepasse(String utilisateurMotdepasse) {
	UtilisateurMotdepasse = utilisateurMotdepasse;
}
/**
 * @return the utilisateurEtatcompte
 */
public String getUtilisateurEtatcompte() {
	return UtilisateurEtatcompte;
}
/**
 * @param utilisateurEtatcompte the utilisateurEtatcompte to set
 */
public void setUtilisateurEtatcompte(String utilisateurEtatcompte) {
	UtilisateurEtatcompte = utilisateurEtatcompte;
}



}