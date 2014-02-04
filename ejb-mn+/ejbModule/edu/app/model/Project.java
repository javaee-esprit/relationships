package edu.app.model;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Project
 *
 */
@Entity
@Table(name="t_project")

public class Project implements Serializable {

	
	private int id;
	private String name;
	
	private List<Participation> participations;
	
	private static final long serialVersionUID = 1L;

	public Project() {
	}
	
	
	
	public Project(int id, String name) {
		this.id = id;
		this.name = name;
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
	@OneToMany( mappedBy = "project", cascade = CascadeType.REMOVE)
	public List<Participation> getParticipations() {
		if(participations == null)
			participations = new ArrayList<Participation>();
		return participations;
	}
	public void setParticipations(List<Participation> participations) {
		this.participations = participations;
	}
   
}
