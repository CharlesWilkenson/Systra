package com.projetsystra.metier.entities;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_lotExporter")
public class LotExporter implements Serializable{
	private static final long serialVersionUID = 1L;
@Id
private String id;
@ManyToOne
@JoinColumn(name="IdLot")
private LotsEntity idLot;

@ManyToOne
@JoinColumn(name="IdExportation")
private ExportationEntity idExportation;

@Column(name="prixLot_expo")
private double prixLot_expo;

@Column(name="qtt_exp")
private int qtt_exp;



public LotExporter(String id) {
	super();
	this.id = id;
}

public LotExporter(String id, LotsEntity idLot, ExportationEntity idExportation,double prixlot,int qtt_exp) {
	super();
	this.id = id;
	this.idLot = idLot;
	this.idExportation = idExportation;
	this.prixLot_expo=prixlot;
	this.qtt_exp=qtt_exp;
}

public LotExporter() {
	super();
	// TODO Auto-generated constructor stub
}

public LotExporter(LotsEntity idLot, ExportationEntity idExportation) {
	super();
	this.idLot = idLot;
	this.idExportation = idExportation;
}



public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public LotsEntity getIdLot() {
	return idLot;
}

public void setIdLot(LotsEntity idLot) {
	this.idLot = idLot;
}

public ExportationEntity getIdExportation() {
	return idExportation;
}

public void setIdExportation(ExportationEntity idExportation) {
	this.idExportation = idExportation;
}

public double getPrixLot_expo() {
	return prixLot_expo;
}

public void setPrixLot_expo(double prixLot_expo) {
	this.prixLot_expo = prixLot_expo;
}

public int getQtt_exp() {
	return qtt_exp;
}

public void setQtt_exp(int  qtt_exp) {
	this.qtt_exp = qtt_exp;
}


}
