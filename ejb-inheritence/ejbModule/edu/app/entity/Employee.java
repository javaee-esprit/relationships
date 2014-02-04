package edu.app.entity;

import java.io.Serializable;

import javax.persistence.Entity;
@Entity
public class Employee extends User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2266212277802018650L;
	
	private String email;
	
	public Employee() {
	}

	public Employee(String login, String password, String email) {
		super(login, password);
		this.setEmail(email);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee[id="+getId()+", login="+getLogin()+", password="+getPassword()+", email="+email+"]";
	}
	
	
	

}
