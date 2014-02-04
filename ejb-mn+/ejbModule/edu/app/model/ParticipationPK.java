package edu.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ParticipationPK implements Serializable{
	
	private int employeeId;
	private int projectId;
	
	public ParticipationPK() {
	}

	@Column( name = "employee_fk")
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	@Column( name = "project_fk")
	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employeeId;
		result = prime * result + projectId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParticipationPK other = (ParticipationPK) obj;
		if (employeeId != other.employeeId)
			return false;
		if (projectId != other.projectId)
			return false;
		return true;
	}
	
	
	
	
	
	

}
