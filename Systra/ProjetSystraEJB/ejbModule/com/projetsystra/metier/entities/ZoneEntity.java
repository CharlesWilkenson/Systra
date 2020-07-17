package com.projetsystra.metier.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="tb_zones")
public class ZoneEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="zone_id")
	private String ZoneId;
	@Column(name="zone_nom")
	private String ZoneNom;
	
	public ZoneEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ZoneEntity(String zoneId, String zoneNom) {
		super();
		ZoneId = zoneId;
		ZoneNom = zoneNom;
	}
	public String getZoneId() {
		return ZoneId;
	}
	public void setZoneId(String zoneId) {
		ZoneId = zoneId;
	}
	public String getZoneNom() {
		return ZoneNom;
	}
	public void setZoneNom(String zoneNom) {
		ZoneNom = zoneNom;
	}
	
}
