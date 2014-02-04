package edu.app.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "t_participation")
public class Participation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4184130162056395469L;
	
	private ParticipationPK pk;
	
	private String role;
	private Employee employee;
	private Project project;
	
	public Participation() {
	}
	
	

	public Participation( Employee employee, Project project, String role) {
		this.getPk().setEmployeeId(employee.getId());
		this.getPk().setProjectId(project.getId());
		this.employee = employee;
		this.project = project;
		this.role = role;
	}



	@EmbeddedId
	public ParticipationPK getPk() {
		if(pk == null)
			pk = new ParticipationPK();
		return pk;
	}

	public void setPk(ParticipationPK pk) {
		this.pk = pk;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@ManyToOne
	@JoinColumn( name = "employee_fk", insertable = false, updatable = false)
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@ManyToOne
	@JoinColumn( name = "project_fk", insertable = false, updatable = false )
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}
