package edu.app.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
@Table( name = "t_project" )
public class Project implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1641519478861926520L;
	
	
	private int id;
	private String name;
	
	
	private List<Employee> employees;
	
	
	public Project() {
	}

	public Project(String name) {
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

	@ManyToMany
	@JoinTable( name = "t_project_employee",
				joinColumns = {@JoinColumn( name = "project_fk" )} ,
				inverseJoinColumns = {@JoinColumn( name = "employee_fk")}
			)
	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}
	
	public void addEmployee(Employee employee){
		this.getEmployees().add(employee);
	}
	
	
	

}
