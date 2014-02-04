package edu.app.model;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Employee
 *
 */
@Entity
@Table(name="t_employee")

public class Employee implements Serializable {

	
	private int id;
	private String name;
	private String email;
	
	private List<Participation> participations;
	
	private static final long serialVersionUID = 1L;

	public Employee() {
	}
	
	
	public Employee(int id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}


	@Id    
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@OneToMany(mappedBy="employee", cascade = CascadeType.REMOVE)
	public List<Participation> getParticipations() {
		if(participations == null)
			participations = new ArrayList<Participation>();
		return participations;
	}
	public void setParticipations(List<Participation> participations) {
		this.participations = participations;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email
				+ "]";
	}
	
	
   
}
