package edu.app.entity;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Admin extends User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6762162980207739005L;
	
	private int adminLevel;
	
	public Admin() {
	}

	public Admin(String login, String password, int adminLevel) {
		super(login, password);
		this.setAdminLevel(adminLevel);
	}

	public int getAdminLevel() {
		return adminLevel;
	}

	public void setAdminLevel(int adminLevel) {
		this.adminLevel = adminLevel;
	}
	
	

}
