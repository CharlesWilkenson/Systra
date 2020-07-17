package com.projetsystra.metier.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="tb_region")
public class RegionEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="region_id")
	private String RegionId;
	public RegionEntity(String idRegion) {
		super();
		this.RegionId=idRegion;
		
		// TODO Auto-generated constructor stub
	}
	@Column(name="region_nom")
	private String RegionNom;
	private String zone_id;
	private String commune_id;
	
	
	public RegionEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RegionEntity(String regionId, String regionNom,String communeid,String zoneid) {
		super();
		RegionId = regionId;
		RegionNom = regionNom;
		commune_id=communeid;
		zone_id=zoneid;
	}
	public String getRegionId() {
		return RegionId;
	}
	public void setRegionId(String regionId) {
		RegionId = regionId;
	}
	public String getRegionNom() {
		return RegionNom;
	}
	public void setRegionNom(String regionNom) {
		RegionNom = regionNom;
	}
	public String getZone_id() {
		return zone_id;
	}
	public void setZone_id(String zone_id) {
		this.zone_id = zone_id;
	}
	public String getCommune_id() {
		return commune_id;
	}
	public void setCommune_id(String commune_id) {
		this.commune_id = commune_id;
	}
	
}
