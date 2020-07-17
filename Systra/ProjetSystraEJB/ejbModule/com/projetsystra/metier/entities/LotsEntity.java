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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@NamedStoredProcedureQueries({@NamedStoredProcedureQuery(name="getAllLots",procedureName="GET_ALL_LOTS",resultClasses=LotsEntity.class)})
@Entity
@Table(name="tb_lots")
public class LotsEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="lot_id")
	private String Lotid;
	
	@Column(name="lot_no")
	private String lotno;
	
	@Column(name="lot_qttTotrecu")
	private int lotqttTotrecu;

	@Column(name="lot_qttTotapc")
	private int lotqttTotapc;
	
	@Temporal(TemporalType.DATE)
	private Date lotdate_transport;
	
	@Temporal(TemporalType.DATE)
	private Date lotdate_livraison;
	
	@Column(name="lot_transporteur")
	private String lottransporteur;
	
	@Column(name="lot_noplaque")
	private String lotnoplaque;
	
	@Column(name="lot_etat")
	private String lotetat;
	
	@ManyToOne
	@JoinColumn(name="regionId")
	private RegionEntity region;
	
	@ManyToOne
	@JoinColumn(name="fournisseur_id")
	private FournisseurEntity fournisseur;
	
	public LotsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LotsEntity(String lotid) {
		super();
		Lotid = lotid;
	}

	public LotsEntity(String lotid, String lotno, int lotqttTotrecu, int lotqttTotapc, Date lotdate_transport,
			Date lotdate_livraison, String lottransporteur, String lotnoplaque, String lotetat, RegionEntity region,
			FournisseurEntity fournisseur) {
		this.Lotid = lotid;
		this.lotno = lotno;
		this.lotqttTotrecu = lotqttTotrecu;
		this.lotqttTotapc = lotqttTotapc;
		this.lotdate_transport = lotdate_transport;
		this.lotdate_livraison = lotdate_livraison;
		this.lottransporteur = lottransporteur;
		this.lotnoplaque = lotnoplaque;
		this.lotetat = lotetat;
		this.region = region;
		this.fournisseur = fournisseur;
	}

	public String getLotid() {
		return Lotid;
	}

	public void setLotid(String lotid) {
		Lotid = lotid;
	}

	public String getLotno() {
		return lotno;
	}

	public void setLotno(String lotno) {
		this.lotno = lotno;
	}

	public int getLotqttTotrecu() {
		return lotqttTotrecu;
	}

	public void setLotqttTotrecu(int lotqttTotrecu) {
		this.lotqttTotrecu = lotqttTotrecu;
	}

	public int getLotqttTotapc() {
		return lotqttTotapc;
	}

	public void setLotqttTotapc(int lotqttTotapc) {
		this.lotqttTotapc = lotqttTotapc;
	}

	public Date getLotdate_transport() {
		return lotdate_transport;
	}

	public void setLotdate_transport(Date lotdate_transport) {
		this.lotdate_transport = lotdate_transport;
	}

	public Date getLotdate_livraison() {
		return lotdate_livraison;
	}

	public void setLotdate_livraison(Date lotdate_livraison) {
		this.lotdate_livraison = lotdate_livraison;
	}

	public String getLottransporteur() {
		return lottransporteur;
	}

	public void setLottransporteur(String lottransporteur) {
		this.lottransporteur = lottransporteur;
	}

	public String getLotnoplaque() {
		return lotnoplaque;
	}

	public void setLotnoplaque(String lotnoplaque) {
		this.lotnoplaque = lotnoplaque;
	}

	public String getLotetat() {
		return lotetat;
	}

	public void setLotetat(String lotetat) {
		this.lotetat = lotetat;
	}

	public RegionEntity getRegion() {
		return region;
	}

	public void setRegion(RegionEntity region) {
		this.region = region;
	}

	public FournisseurEntity getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(FournisseurEntity fournisseur) {
		this.fournisseur = fournisseur;
	}
	
	

	
	
}
