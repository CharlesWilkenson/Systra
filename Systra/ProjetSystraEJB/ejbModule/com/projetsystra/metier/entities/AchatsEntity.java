package com.projetsystra.metier.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@NamedStoredProcedureQueries({@NamedStoredProcedureQuery(name="getAllAchats",procedureName="GET_ALL_ACHAT",resultClasses=AchatsEntity.class),
	
	@NamedStoredProcedureQuery(name="GetAllAchatbyLot",procedureName="GET_ALL_ACHAT_BY_LOT",
	resultClasses={AchatsEntity.class},
	parameters={@StoredProcedureParameter(name="lotid",type=String.class,mode=ParameterMode.IN)}),
	
	
	@NamedStoredProcedureQuery(name="getAllAchatsByFourn",procedureName="GET_ALL_ACHAT_BY_FOURN",resultClasses=AchatsEntity.class,parameters={@StoredProcedureParameter(name="idfourn", type = String.class,mode=ParameterMode.IN)})})



@Entity
@Table(name="tb_achats")
public class AchatsEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="Achat_id")
	private String AchatId;
	
	@Column(name="Achat_qtt")
	private int AchatQtTotal;
	
	@Column(name="Achat_prix")
	private double AchatPrix;
	
	@Temporal(TemporalType.DATE)
	private Date AchatDate;
	
	@Column(name="Achat_etat")
	private String AchatEtat;
	
	@ManyToOne
	@JoinColumn(name="Fournisseur_id")
	private FournisseurEntity fournisseur;

	@ManyToOne
	@JoinColumn(name="regionId")
	private RegionEntity region;
	
	@ManyToOne
	@JoinColumn(name="ProducteurId")
	private ProducteurEntity producteur;
	
	@ManyToOne
	@JoinColumn(name="ParcelleId")
	private ParcelleEntity parcelle;

	public String getAchatId() {
		return AchatId;
	}

	public void setAchatId(String achatId) {
		AchatId = achatId;
	}

	public int getAchatQtTotal() {
		return AchatQtTotal;
	}

	public void setAchatQtTotal(int achatQtTotal) {
		AchatQtTotal = achatQtTotal;
	}

	public double getAchatPrix() {
		return AchatPrix;
	}

	public void setAchatPrix(double achatPrix) {
		AchatPrix = achatPrix;
	}

	public Date getAchatDate() {
		return AchatDate;
	}

	public void setAchatDate(Date achatDate) {
		AchatDate = achatDate;
	}

	public String getAchatEtat() {
		return AchatEtat;
	}

	public void setAchatEtat(String achatEtat) {
		AchatEtat = achatEtat;
	}

	public FournisseurEntity getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(FournisseurEntity fournisseur) {
		this.fournisseur = fournisseur;
	}

	public RegionEntity getRegion() {
		return region;
	}

	public void setRegion(RegionEntity region) {
		this.region = region;
	}

	public ProducteurEntity getProducteur() {
		return producteur;
	}

	public void setProducteur(ProducteurEntity producteur) {
		this.producteur = producteur;
	}

	public ParcelleEntity getParcelle() {
		return parcelle;
	}

	public void setParcelle(ParcelleEntity parcelle) {
		this.parcelle = parcelle;
	}

	public AchatsEntity() {
		super();
	
	}

	public AchatsEntity(String achatId, int achatQtTotal, double achatPrix, Date achatDate, String achatEtat,
			FournisseurEntity fournisseur, RegionEntity region, ProducteurEntity producteur, ParcelleEntity parcelle) {
		AchatId = achatId;
		AchatQtTotal = achatQtTotal;
		AchatPrix = achatPrix;
		AchatDate = achatDate;
		AchatEtat = achatEtat;
		this.fournisseur = fournisseur;
		this.region = region;
		this.producteur = producteur;
		this.parcelle = parcelle;
	}
	
	public AchatsEntity(String achatId) {
		super();
		AchatId = achatId;
	}
}
