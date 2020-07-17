package com.projetsystra.metier.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class UserRole implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;


public UserRole() {
	super();
}





public UserRole(Long id) {
	super();
	this.id = id;
}





public UserRole(UtilisateurEntity user, Role role) {
	super();
	this.user = user;
	this.role = role;
}





public UtilisateurEntity getUser() {
	return user;
}

public void setUser(UtilisateurEntity user) {
	this.user = user;
}

public Role getRole() {
	return role;
}

public void setRole(Role role) {
	this.role = role;
}

@OneToOne
@JoinColumn(name="Email")
private UtilisateurEntity user;




@OneToOne
@JoinColumn(name="Role")
private Role role;
}
