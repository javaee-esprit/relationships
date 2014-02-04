package edu.app.entity;

import java.io.Serializable;
import java.util.ArrayList;
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
	
	
	private List<Employee> employees;
	
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

	@OneToMany( mappedBy = "department", fetch = FetchType.EAGER )
	public List<Employee> getEmployees() {
		if(employees == null)
			employees = new ArrayList<Employee>();
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}
	
	
	// gère les deux bout de l'association
	public void addEmployee(Employee employee){
		this.getEmployees().add(employee);
		employee.setDepartment(this);
	}
	
	
	

}
