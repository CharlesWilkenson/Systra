package com.projetsystra.metier.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tb_Message")
public class MessageEntity implements Serializable{

	private static final long serialVersionUID = 1L;	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
	private String nomComplet;
	private String email;
	@Lob
	private String message;
	private String etat;
	public MessageEntity(String nomComplet, String email, String message, String etat, Date date) {
		super();
		this.nomComplet = nomComplet;
		this.email = email;
		this.message = message;
		this.etat = etat;
		this.date = date;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public MessageEntity(Long id) {
		super();
		this.id = id;
	}

	@Temporal(TemporalType.DATE)
	private Date date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomComplet() {
		return nomComplet;
	}

	public void setNomComplet(String nomComplet) {
		this.nomComplet = nomComplet;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public MessageEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MessageEntity(String nomComplet, String email, String message, Date date) {
		super();
		this.nomComplet = nomComplet;
		this.email = email;
		this.message = message;
		this.date = date;
	}
	
	
	
}
