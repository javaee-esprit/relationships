package edu.app.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
@Table( name = "t_department" )
public class Department implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1641519478861926520L;
	
	
	private int id;
	private String name;
	
	
	public Department() {
	}

	public Department(String name) {
		this.name = name;
	}

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}
	
	public void addEmployee(Employee employee){
		employee.setDepartment(this);
	}
	
	
	

}
