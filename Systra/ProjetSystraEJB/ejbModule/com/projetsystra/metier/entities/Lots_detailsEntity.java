package com.projetsystra.metier.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_lots_details")
public class Lots_detailsEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String lots_detailsId;
	
	
	@Column(name="lot_qttrecu")
	private int lotqttrecu;
	
	@Column(name="lot_qttapc")
	private int lotqttapc;
	
	@ManyToOne
	@JoinColumn(name="LotsId")
	private LotsEntity Lot;
	
	@ManyToOne
	@JoinColumn(name="AchatsId")
	private AchatsEntity Achats;

	public Lots_detailsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Lots_detailsEntity( String idlotdetails,int lotqttrecu, int lotqttapc, LotsEntity lot, AchatsEntity achats) {
		this.lots_detailsId=idlotdetails;
		this.lotqttrecu = lotqttrecu;
		this.lotqttapc = lotqttapc;
		this.Lot = lot;
		this.Achats = achats;
	}

	public String getLots_detailsId() {
		return lots_detailsId;
	}

	public void setLots_detailsId(String lots_detailsId) {
		this.lots_detailsId = lots_detailsId;
	}

	public int getLotqttrecu() {
		return lotqttrecu;
	}

	public void setLotqttrecu(int lotqttrecu) {
		this.lotqttrecu = lotqttrecu;
	}

	public int getLotqttapc() {
		return lotqttapc;
	}

	public void setLotqttapc(int lotqttapc) {
		this.lotqttapc = lotqttapc;
	}

	public LotsEntity getLot() {
		return Lot;
	}

	public void setLot(LotsEntity lot) {
		Lot = lot;
	}

	public AchatsEntity getAchats() {
		return Achats;
	}

	public void setAchats(AchatsEntity achats) {
		Achats = achats;
	}
	
	
	
}
