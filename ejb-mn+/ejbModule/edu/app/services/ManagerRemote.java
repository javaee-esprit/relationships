package edu.app.services;

import java.util.List;

import javax.ejb.Remote;

import edu.app.model.Employee;
import edu.app.model.Project;

@Remote
public interface ManagerRemote {
	
	void createEmployee(Employee employee);
	void createProject(Project project);
	
	Employee findEmployeeById(int id);
	Project findProjectBy(int id);
	
	void assignEmployeeToProject(Employee employee, Project project, String role);
	void removeEmployeeFromProject(Employee employee, Project project);
	void removeProject(Project project);
	List<Employee> findEmployeesInProject(Project project);
	List<Employee> findEmployeesNotInProject(Project project);

}
