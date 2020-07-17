package com.projetsystra.metier.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity()
@Table(name="tb_role")
public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String rolename;
	
	@OneToMany(mappedBy="role")
	private List<UserRole> iDuserRole;
	public Role(String rolename) {
		super();
		this.rolename = rolename;
	}




	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}




	public List<UserRole> getiDuserRole() {
		return iDuserRole;
	}


	public void setiDuserRole(List<UserRole> iDuserRole) {
		this.iDuserRole = iDuserRole;
	}




	public String getRolename() {
		return rolename;
	}




	public void setRolename(String rolename) {
		this.rolename = rolename;
	}




	public Role(String rolename, List<UserRole> iDuserRole) {
		super();
		this.rolename = rolename;
		this.iDuserRole = iDuserRole;
	}



	
	
}
