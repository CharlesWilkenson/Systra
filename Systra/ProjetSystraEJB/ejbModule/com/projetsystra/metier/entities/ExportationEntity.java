package com.projetsystra.metier.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tb_exportation")
public class ExportationEntity implements Serializable{
private static final long serialVersionUID = 1L;
	@Id
private String	idExportation ;
public ExportationEntity(double prixtotal_export) {
		super();
		this.prixtotal_export = prixtotal_export;
	}

private int	qtt_exporter ;
private double	prixtotal_export ;
@Temporal(TemporalType.DATE)
private Date date_export ;
private String	client ;


@OneToMany(mappedBy="idExportation")
private Collection<LotExporter> idLotExporter;

public String getIdExportation() {
	return idExportation;
}

public void setIdExportation(String idExportation) {
	this.idExportation = idExportation;
}

public int getqtt_exporter() {
	return qtt_exporter;
}

public void setqttlot_exporter(int qttlot_exporter) {
	this.qtt_exporter = qttlot_exporter;
}

public double getPrixtotal_export() {
	return prixtotal_export;
}

public void setPrix_export(double prix_export) {
	this.prixtotal_export = prix_export;
}

public Date getDate_export() {
	return date_export;
}

public void setDate_export(Date date_export) {
	this.date_export = date_export;
}

public String getClient() {
	return client;
}

public void setClient(String client) {
	this.client = client;
}



public ExportationEntity() {
	super();
	// TODO Auto-generated constructor stub
}

public ExportationEntity(String idExportation, int qtt_exporter, double prixtotal_export, Date date_export, String client) {
	super();
	this.idExportation = idExportation;
	this.qtt_exporter = qtt_exporter;
	this.prixtotal_export = prixtotal_export;
	this.date_export = date_export;
	this.client = client;
	
}

public ExportationEntity(String idExportation) {
	super();
	this.idExportation = idExportation;
}

public Collection<LotExporter> getIdLotExporter() {
	return idLotExporter;
}

public void setIdLotExporter(Collection<LotExporter> idLotExporter) {
	this.idLotExporter = idLotExporter;
}

 


}
