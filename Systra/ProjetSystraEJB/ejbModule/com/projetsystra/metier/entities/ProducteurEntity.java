/**
 * 
 */
package com.projetsystra.metier.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@NamedStoredProcedureQueries(
{@NamedStoredProcedureQuery(name="getAllProductors",
procedureName="GET_ALL_PRODUCTORS",
resultClasses=ProducteurEntity.class),
@NamedStoredProcedureQuery(name="getAllProductorsByEtat",
procedureName="GET_ALL_PRODUCTORS_BYETAT",
resultClasses=ProducteurEntity.class)})
@Entity
@Table(name="tb_Producteur")
public class ProducteurEntity implements Serializable{

	private static final long serialVersionUID = 1L;
@Id
@Column(name="Producteur_id")
private String ProducteurId;
public ProducteurEntity(String producteurId) {
	super();
	ProducteurId = producteurId;
}
@Column(name="Producteur_nomcomplet")
private String ProducteurNomComplet;
@Column(name="Producteur_sexe")
private String ProducteurSexe;
@Column(name="Producteur_telephone")
private String ProducteurTelephone;
@Column(name="Producteur_etat")
private String ProducteurEtat;

@OneToMany(mappedBy="producteur",cascade=CascadeType.MERGE,fetch=FetchType.LAZY)
private Collection<ParcelleEntity>parcelles;

@OneToMany(mappedBy="producteur",fetch=FetchType.LAZY)
private Collection<AchatsEntity>AchatsEntity;


public ProducteurEntity() {
	super();
	// TODO Auto-generated constructor stub
}
/**
 * @param producteurId
 * @param producteurNomComplet
 * @param producteurSexe
 * @param producteurTelephone
 * @param producteurEtat
 */
public ProducteurEntity(String producteurId, String producteurNomComplet, String producteurSexe,
		String producteurTelephone, String producteurEtat) {
	super();
	ProducteurId = producteurId;
	ProducteurNomComplet = producteurNomComplet;
	ProducteurSexe = producteurSexe;
	ProducteurTelephone = producteurTelephone;
	ProducteurEtat = producteurEtat;
}


public String getProducteurId() {
	return ProducteurId;
}
/**
 * @param producteurId the producteurId to set
 */
public void setProducteurId(String producteurId) {
	ProducteurId = producteurId;
}
/**
 * @return the producteurNomComplet
 */
public String getProducteurNomComplet() {
	return ProducteurNomComplet;
}
/**
 * @param producteurNomComplet the producteurNomComplet to set
 */
public void setProducteurNomComplet(String producteurNomComplet) {
	ProducteurNomComplet = producteurNomComplet;
}
/**
 * @return the producteurSexe
 */
public String getProducteurSexe() {
	return ProducteurSexe;
}
/**
 * @param producteurSexe the producteurSexe to set
 */
public void setProducteurSexe(String producteurSexe) {
	ProducteurSexe = producteurSexe;
}
/**
 * @return the producteurTelephone
 */
public String getProducteurTelephone() {
	return ProducteurTelephone;
}
/**
 * @param producteurTelephone the producteurTelephone to set
 */
public void setProducteurTelephone(String producteurTelephone) {
	ProducteurTelephone = producteurTelephone;
}
/**
 * @return the producteurEtat
 */
public String getProducteurEtat() {
	return ProducteurEtat;
}
/**
 * @param producteurEtat the producteurEtat to set
 */
public void setProducteurEtat(String producteurEtat) {
	ProducteurEtat = producteurEtat;
}



}
