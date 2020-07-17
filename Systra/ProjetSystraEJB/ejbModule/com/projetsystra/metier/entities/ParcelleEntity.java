
package com.projetsystra.metier.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
@NamedStoredProcedureQueries({@NamedStoredProcedureQuery(name="GetAllParcelle",procedureName="GET_ALL_PARCELLE_BY_ETAT",resultClasses=ParcelleEntity.class),

	@NamedStoredProcedureQuery(name="GetAllParcellebyprod",procedureName="GET_ALL_PARCELLE_BY_PROD",
resultClasses={ParcelleEntity.class},
parameters={@StoredProcedureParameter(name="idprod",type=String.class,mode=ParameterMode.IN)})})
@Entity
@Table(name="tb_Parcelle")
public class ParcelleEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="Parcelle_id")
	private String ParcelleId;

	@Column(name="Parcelle_commune")
	private String ParcelleCommune;

	@Column(name="Parcelle_Section_communale")
	private String ParcelleSectioncommunale;

	@Column(name="Parcelle_localite")
	private String ParcelleLocalite;

	@Column(name="Parcelle_marndr")
	private String ParcelleMarndr;

	@Column(name="Parcelle_regime_foncier")
	private String ParcelleRegimeFoncier;

	@Column(name="Parcelle_type_culture")
	private String ParcelleTypeCulture;

	@Column(name="Parcelle_fertilisation_chimique")
	private String ParcelleFertilisationChimique;

	@Column(name="Parcelle_fertilisation_organique")
	private String ParcelleFertilisationOrganique;

	@Column(name="Parcelle_presence_elevage")
	private String ParcellePresenceElevage;

	@Column(name="Parcelle_type_elevage")
	private String ParcelleTypeElevage;

	@Column(name="Parcelle_presence_Latrine")
	private String ParcellePresenceLatrine;

	@Column(name="Parcelle_point_latitude_latrine")
	private Double ParcellePointLatitudeLatrine;

	@Column(name="Parcelle_point_longitude_latrine")
	private Double ParcellePointLongitudeLatrine;

	@Column(name="Parcelle_type_traitrement_phytosanitaire")
	private String ParcelleTypeTraitrementPhytosanitaire;

	@Column(name="Parcelle_probleme_inondation")
	private String ParcelleProblemeInondation;

	@Column(name="Parcelle_frequence_inondation")
	private String ParcelleFrequenceInondation;

	@Column(name="Parcelle_plante_hote")
	private String ParcellePlanteHote;

	@Column(name="Parcelle_age_plantation")
	private int ParcelleAgePlantation;

	@Column(name="Parcelle_nbre_manguier")
	private int ParcelleNbreManguier;

	@Column(name="Parcelle_nbre_manguier_en_production")
	private int ParcelleNbreManguierEnProduction;

	@Column(name="Parcelle_production_annuelle_mangue")
	private int ParcelleProductionAnnuelleMangue;

	@Column(name="Parcelle_parc_irrigue")
	private String ParcelleParcIrrigue;

	@Column(name="Parcelle_type_eau")
	private String ParcelleTypeEau;

	@Column(name="Parcelle_commercialisation")
	private String ParcelleCommercialisation;

	@Column(name="Parcelle_point_latitude1")
	private Double ParcellePointLatitude1;
	
	@Column(name="Parcelle_point_longitude1")
	private Double ParcellePointLongitude1;
	
	@Column(name="Parcelle_point_latitude2")
	private Double ParcellePointLatitude2;
	
	@Column(name="Parcelle_point_longitude2")
	private Double ParcellePointLongitude2;
	
	@Column(name="Parcelle_point_latitude3")
	private Double ParcellePointLatitude3;
	
	@Column(name="Parcelle_point_longitude3")
	private Double ParcellePointLongitude3;
	
	@Column(name="Parcelle_point_latitude4")
	private Double ParcellePointLatitude4;
	
	@Column(name="Parcelle_point_longitude4")
	private Double ParcellePointLongitude4;
	
	@Column(name="Parcelle_superficie")
	private Double ParcelleSuperficie;
	
	@Column(name="Parcelle_etat")
	private String ParcelleEtat;
	
	@ManyToOne
	@JoinColumn(name="Producteur_id")
	private ProducteurEntity producteur;

	
	public ParcelleEntity() {
		super();
		
	}
	public ParcelleEntity(String parcelleid) {
		super();
		ParcelleId=parcelleid;
		
	}

	public ParcelleEntity(String parcelleId,ProducteurEntity producteurid, String parcelleCommune,
			String parcelleSectioncommunale, String parcelleLocalite, String parcelleMarndr,
			String parcelleRegimeFoncier, String parcelleTypeCulture, String parcelleFertilisationChimique,
			String parcelleFertilisationOrganique, String parcellePresenceElevage, String parcelleTypeElevage,
			String parcellePresenceLatrine, Double parcellePointLatitudeLatrine, Double parcellePointLongitudeLatrine,
			String parcelleTypeTraitrementPhytosanitaire, String parcelleProblemeInondation,
			String parcelleFrequenceInondation, String parcellePlanteHote, int parcelleAgePlantation,
			int parcelleNbreManguier, int parcelleNbreManguierEnProduction, int parcelleProductionAnnuelleMangue,
			String parcelleParcIrrigue, String parcelleTypeEau, String parcelleCommercialisation,
			Double parcellePointLatitude1, Double parcellePointLongitude1, Double parcellePointLatitude2,
			Double parcellePointLongitude2, Double parcellePointLatitude3, Double parcellePointLongitude3,
			Double parcellePointLatitude4, Double parcellePointLongitude4, Double parcelleSuperficie,
			String parcelleEtat) {
		super();
		ParcelleId = parcelleId;
		ParcelleCommune = parcelleCommune;
		ParcelleSectioncommunale = parcelleSectioncommunale;
		ParcelleLocalite = parcelleLocalite;
		ParcelleMarndr = parcelleMarndr;
		ParcelleRegimeFoncier = parcelleRegimeFoncier;
		ParcelleTypeCulture = parcelleTypeCulture;
		ParcelleFertilisationChimique = parcelleFertilisationChimique;
		ParcelleFertilisationOrganique = parcelleFertilisationOrganique;
		ParcellePresenceElevage = parcellePresenceElevage;
		ParcelleTypeElevage = parcelleTypeElevage;
		ParcellePresenceLatrine = parcellePresenceLatrine;
		ParcellePointLatitudeLatrine = parcellePointLatitudeLatrine;
		ParcellePointLongitudeLatrine = parcellePointLongitudeLatrine;
		ParcelleTypeTraitrementPhytosanitaire = parcelleTypeTraitrementPhytosanitaire;
		ParcelleProblemeInondation = parcelleProblemeInondation;
		ParcelleFrequenceInondation = parcelleFrequenceInondation;
		ParcellePlanteHote = parcellePlanteHote;
		ParcelleAgePlantation = parcelleAgePlantation;
		ParcelleNbreManguier = parcelleNbreManguier;
		ParcelleNbreManguierEnProduction = parcelleNbreManguierEnProduction;
		ParcelleProductionAnnuelleMangue = parcelleProductionAnnuelleMangue;
		ParcelleParcIrrigue = parcelleParcIrrigue;
		ParcelleTypeEau = parcelleTypeEau;
		ParcelleCommercialisation = parcelleCommercialisation;
		ParcellePointLatitude1 = parcellePointLatitude1;
		ParcellePointLongitude1 = parcellePointLongitude1;
		ParcellePointLatitude2 = parcellePointLatitude2;
		ParcellePointLongitude2 = parcellePointLongitude2;
		ParcellePointLatitude3 = parcellePointLatitude3;
		ParcellePointLongitude3 = parcellePointLongitude3;
		ParcellePointLatitude4 = parcellePointLatitude4;
		ParcellePointLongitude4 = parcellePointLongitude4;
		ParcelleSuperficie = parcelleSuperficie;
		ParcelleEtat = parcelleEtat;
		producteur=producteurid;
	}

	

	public ProducteurEntity getProducteur() {
		return producteur;
	}

	public void setProducteur(ProducteurEntity producteur) {
		this.producteur = producteur;
	}

	
	public String getParcelleId() {
		return ParcelleId;
	}

	/**
	 * @param parcelleId the parcelleId to set
	 */
	public void setParcelleId(String parcelleId) {
		ParcelleId = parcelleId;
	}




	public String getParcelleCommune() {
		return ParcelleCommune;
	}
	public void setParcelleCommune(String parcelleCommune) {
		ParcelleCommune = parcelleCommune;
	}
	public String getParcelleSectioncommunale() {
		return ParcelleSectioncommunale;
	}
	public void setParcelleSectioncommunale(String parcelleSectioncommunale) {
		ParcelleSectioncommunale = parcelleSectioncommunale;
	}
	/**
	 * @return the parcelleLocalite
	 */
	public String getParcelleLocalite() {
		return ParcelleLocalite;
	}

	/**
	 * @param parcelleLocalite the parcelleLocalite to set
	 */
	public void setParcelleLocalite(String parcelleLocalite) {
		ParcelleLocalite = parcelleLocalite;
	}

	/**
	 * @return the parcelleMarndr
	 */
	public String getParcelleMarndr() {
		return ParcelleMarndr;
	}

	/**
	 * @param parcelleMarndr the parcelleMarndr to set
	 */
	public void setParcelleMarndr(String parcelleMarndr) {
		ParcelleMarndr = parcelleMarndr;
	}

	/**
	 * @return the parcelleRegimeFoncier
	 */
	public String getParcelleRegimeFoncier() {
		return ParcelleRegimeFoncier;
	}

	/**
	 * @param parcelleRegimeFoncier the parcelleRegimeFoncier to set
	 */
	public void setParcelleRegimeFoncier(String parcelleRegimeFoncier) {
		ParcelleRegimeFoncier = parcelleRegimeFoncier;
	}

	/**
	 * @return the parcelleTypeCulture
	 */
	public String getParcelleTypeCulture() {
		return ParcelleTypeCulture;
	}

	/**
	 * @param parcelleTypeCulture the parcelleTypeCulture to set
	 */
	public void setParcelleTypeCulture(String parcelleTypeCulture) {
		ParcelleTypeCulture = parcelleTypeCulture;
	}

	/**
	 * @return the parcelleFertilisationChimique
	 */
	public String getParcelleFertilisationChimique() {
		return ParcelleFertilisationChimique;
	}

	/**
	 * @param parcelleFertilisationChimique the parcelleFertilisationChimique to set
	 */
	public void setParcelleFertilisationChimique(String parcelleFertilisationChimique) {
		ParcelleFertilisationChimique = parcelleFertilisationChimique;
	}

	/**
	 * @return the parcelleFertilisationOrganique
	 */
	public String getParcelleFertilisationOrganique() {
		return ParcelleFertilisationOrganique;
	}

	/**
	 * @param parcelleFertilisationOrganique the parcelleFertilisationOrganique to set
	 */
	public void setParcelleFertilisationOrganique(String parcelleFertilisationOrganique) {
		ParcelleFertilisationOrganique = parcelleFertilisationOrganique;
	}

	/**
	 * @return the parcellePresenceElevage
	 */
	public String getParcellePresenceElevage() {
		return ParcellePresenceElevage;
	}

	/**
	 * @param parcellePresenceElevage the parcellePresenceElevage to set
	 */
	public void setParcellePresenceElevage(String parcellePresenceElevage) {
		ParcellePresenceElevage = parcellePresenceElevage;
	}

	/**
	 * @return the parcelleTypeElevage
	 */
	public String getParcelleTypeElevage() {
		return ParcelleTypeElevage;
	}

	/**
	 * @param parcelleTypeElevage the parcelleTypeElevage to set
	 */
	public void setParcelleTypeElevage(String parcelleTypeElevage) {
		ParcelleTypeElevage = parcelleTypeElevage;
	}

	/**
	 * @return the parcellePresenceLatrine
	 */
	public String getParcellePresenceLatrine() {
		return ParcellePresenceLatrine;
	}

	/**
	 * @param parcellePresenceLatrine the parcellePresenceLatrine to set
	 */
	public void setParcellePresenceLatrine(String parcellePresenceLatrine) {
		ParcellePresenceLatrine = parcellePresenceLatrine;
	}

	/**
	 * @return the parcellePointLatitudeLatrine
	 */
	public Double getParcellePointLatitudeLatrine() {
		return ParcellePointLatitudeLatrine;
	}

	/**
	 * @param parcellePointLatitudeLatrine the parcellePointLatitudeLatrine to set
	 */
	public void setParcellePointLatitudeLatrine(Double parcellePointLatitudeLatrine) {
		ParcellePointLatitudeLatrine = parcellePointLatitudeLatrine;
	}

	/**
	 * @return the parcellePointLongitudeLatrine
	 */
	public Double getParcellePointLongitudeLatrine() {
		return ParcellePointLongitudeLatrine;
	}

	/**
	 * @param parcellePointLongitudeLatrine the parcellePointLongitudeLatrine to set
	 */
	public void setParcellePointLongitudeLatrine(Double parcellePointLongitudeLatrine) {
		ParcellePointLongitudeLatrine = parcellePointLongitudeLatrine;
	}

	/**
	 * @return the parcelleTypeTraitrementPhytosanitaire
	 */
	public String getParcelleTypeTraitrementPhytosanitaire() {
		return ParcelleTypeTraitrementPhytosanitaire;
	}

	/**
	 * @param parcelleTypeTraitrementPhytosanitaire the parcelleTypeTraitrementPhytosanitaire to set
	 */
	public void setParcelleTypeTraitrementPhytosanitaire(String parcelleTypeTraitrementPhytosanitaire) {
		ParcelleTypeTraitrementPhytosanitaire = parcelleTypeTraitrementPhytosanitaire;
	}

	/**
	 * @return the parcelleProblemeInondation
	 */
	public String getParcelleProblemeInondation() {
		return ParcelleProblemeInondation;
	}

	/**
	 * @param parcelleProblemeInondation the parcelleProblemeInondation to set
	 */
	public void setParcelleProblemeInondation(String parcelleProblemeInondation) {
		ParcelleProblemeInondation = parcelleProblemeInondation;
	}

	/**
	 * @return the parcelleFrequenceInondation
	 */
	public String getParcelleFrequenceInondation() {
		return ParcelleFrequenceInondation;
	}

	/**
	 * @param parcelleFrequenceInondation the parcelleFrequenceInondation to set
	 */
	public void setParcelleFrequenceInondation(String parcelleFrequenceInondation) {
		ParcelleFrequenceInondation = parcelleFrequenceInondation;
	}

	/**
	 * @return the parcellePlanteHote
	 */
	public String getParcellePlanteHote() {
		return ParcellePlanteHote;
	}

	/**
	 * @param parcellePlanteHote the parcellePlanteHote to set
	 */
	public void setParcellePlanteHote(String parcellePlanteHote) {
		ParcellePlanteHote = parcellePlanteHote;
	}

	/**
	 * @return the parcelleAgePlantation
	 */
	public int getParcelleAgePlantation() {
		return ParcelleAgePlantation;
	}

	/**
	 * @param parcelleAgePlantation the parcelleAgePlantation to set
	 */
	public void setParcelleAgePlantation(int parcelleAgePlantation) {
		ParcelleAgePlantation = parcelleAgePlantation;
	}

	/**
	 * @return the parcelleNbreManguier
	 */
	public int getParcelleNbreManguier() {
		return ParcelleNbreManguier;
	}

	/**
	 * @param parcelleNbreManguier the parcelleNbreManguier to set
	 */
	public void setParcelleNbreManguier(int parcelleNbreManguier) {
		ParcelleNbreManguier = parcelleNbreManguier;
	}

	/**
	 * @return the parcelleNbreManguierEnProduction
	 */
	public int getParcelleNbreManguierEnProduction() {
		return ParcelleNbreManguierEnProduction;
	}

	/**
	 * @param parcelleNbreManguierEnProduction the parcelleNbreManguierEnProduction to set
	 */
	public void setParcelleNbreManguierEnProduction(int parcelleNbreManguierEnProduction) {
		ParcelleNbreManguierEnProduction = parcelleNbreManguierEnProduction;
	}

	/**
	 * @return the parcelleProductionAnnuelleMangue
	 */
	public int getParcelleProductionAnnuelleMangue() {
		return ParcelleProductionAnnuelleMangue;
	}

	/**
	 * @param parcelleProductionAnnuelleMangue the parcelleProductionAnnuelleMangue to set
	 */
	public void setParcelleProductionAnnuelleMangue(int parcelleProductionAnnuelleMangue) {
		ParcelleProductionAnnuelleMangue = parcelleProductionAnnuelleMangue;
	}

	/**
	 * @return the parcelleParcIrrigue
	 */
	public String getParcelleParcIrrigue() {
		return ParcelleParcIrrigue;
	}

	/**
	 * @param parcelleParcIrrigue the parcelleParcIrrigue to set
	 */
	public void setParcelleParcIrrigue(String parcelleParcIrrigue) {
		ParcelleParcIrrigue = parcelleParcIrrigue;
	}

	/**
	 * @return the parcelleTypeEau
	 */
	public String getParcelleTypeEau() {
		return ParcelleTypeEau;
	}

	/**
	 * @param parcelleTypeEau the parcelleTypeEau to set
	 */
	public void setParcelleTypeEau(String parcelleTypeEau) {
		ParcelleTypeEau = parcelleTypeEau;
	}

	/**
	 * @return the parcelleCommercialisation
	 */
	public String getParcelleCommercialisation() {
		return ParcelleCommercialisation;
	}

	/**
	 * @param parcelleCommercialisation the parcelleCommercialisation to set
	 */
	public void setParcelleCommercialisation(String parcelleCommercialisation) {
		ParcelleCommercialisation = parcelleCommercialisation;
	}

	/**
	 * @return the parcellePointLatitude1
	 */
	public Double getParcellePointLatitude1() {
		return ParcellePointLatitude1;
	}

	/**
	 * @param parcellePointLatitude1 the parcellePointLatitude1 to set
	 */
	public void setParcellePointLatitude1(Double parcellePointLatitude1) {
		ParcellePointLatitude1 = parcellePointLatitude1;
	}

	/**
	 * @return the parcellePointLongitude1
	 */
	public Double getParcellePointLongitude1() {
		return ParcellePointLongitude1;
	}

	/**
	 * @param parcellePointLongitude1 the parcellePointLongitude1 to set
	 */
	public void setParcellePointLongitude1(Double parcellePointLongitude1) {
		ParcellePointLongitude1 = parcellePointLongitude1;
	}

	/**
	 * @return the parcellePointLatitude2
	 */
	public Double getParcellePointLatitude2() {
		return ParcellePointLatitude2;
	}

	/**
	 * @param parcellePointLatitude2 the parcellePointLatitude2 to set
	 */
	public void setParcellePointLatitude2(Double parcellePointLatitude2) {
		ParcellePointLatitude2 = parcellePointLatitude2;
	}

	/**
	 * @return the parcellePointLongitude2
	 */
	public Double getParcellePointLongitude2() {
		return ParcellePointLongitude2;
	}

	/**
	 * @param parcellePointLongitude2 the parcellePointLongitude2 to set
	 */
	public void setParcellePointLongitude2(Double parcellePointLongitude2) {
		ParcellePointLongitude2 = parcellePointLongitude2;
	}

	/**
	 * @return the parcellePointLatitude3
	 */
	public Double getParcellePointLatitude3() {
		return ParcellePointLatitude3;
	}

	/**
	 * @param parcellePointLatitude3 the parcellePointLatitude3 to set
	 */
	public void setParcellePointLatitude3(Double parcellePointLatitude3) {
		ParcellePointLatitude3 = parcellePointLatitude3;
	}

	/**
	 * @return the parcellePointLongitude3
	 */
	public Double getParcellePointLongitude3() {
		return ParcellePointLongitude3;
	}

	/**
	 * @param parcellePointLongitude3 the parcellePointLongitude3 to set
	 */
	public void setParcellePointLongitude3(Double parcellePointLongitude3) {
		ParcellePointLongitude3 = parcellePointLongitude3;
	}

	/**
	 * @return the parcellePointLatitude4
	 */
	public Double getParcellePointLatitude4() {
		return ParcellePointLatitude4;
	}

	/**
	 * @param parcellePointLatitude4 the parcellePointLatitude4 to set
	 */
	public void setParcellePointLatitude4(Double parcellePointLatitude4) {
		ParcellePointLatitude4 = parcellePointLatitude4;
	}

	/**
	 * @return the parcellePointLongitude4
	 */
	public Double getParcellePointLongitude4() {
		return ParcellePointLongitude4;
	}

	/**
	 * @param parcellePointLongitude4 the parcellePointLongitude4 to set
	 */
	public void setParcellePointLongitude4(Double parcellePointLongitude4) {
		ParcellePointLongitude4 = parcellePointLongitude4;
	}

	/**
	 * @return the parcelleSuperficie
	 */
	public Double getParcelleSuperficie() {
		return ParcelleSuperficie;
	}

	/**
	 * @param parcelleSuperficie the parcelleSuperficie to set
	 */
	public void setParcelleSuperficie(Double parcelleSuperficie) {
		ParcelleSuperficie = parcelleSuperficie;
	}

	/**
	 * @return the parcelleEtat
	 */
	public String getParcelleEtat() {
		return ParcelleEtat;
	}

	/**
	 * @param parcelleEtat the parcelleEtat to set
	 */
	public void setParcelleEtat(String parcelleEtat) {
		ParcelleEtat = parcelleEtat;
	}

}
