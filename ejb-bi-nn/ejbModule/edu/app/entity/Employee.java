package edu.app.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table( name = "t_employee" )
public class Employee implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2351557570459619762L;
	
	
	private int id;
	private String firstname;
	private String lastname;
	
	private List<Project> projects;
	
	public Employee() {
	}


	public Employee(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}


	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	@ManyToMany( mappedBy = "employees" )
	public List<Project> getProjects() {
		return projects;
	}


	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstname=" + firstname
				+ ", lastname=" + lastname + "]";
	}
	
	
	
	
	
	
	

}
