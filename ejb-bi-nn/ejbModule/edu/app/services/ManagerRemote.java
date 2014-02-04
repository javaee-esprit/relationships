package edu.app.services;

import javax.ejb.Remote;

import edu.app.entity.Project;
import edu.app.entity.Employee;



@Remote
public interface ManagerRemote {
	
	void createProject(Project project);
	Project findProject(int id);
	void createEmployee(Employee employee);
	Employee findEmployee(int id);

}
