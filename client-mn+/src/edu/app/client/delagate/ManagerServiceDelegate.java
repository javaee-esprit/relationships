package edu.app.client.delagate;

import java.util.List;

import edu.app.client.locator.ServiceLocator;
import edu.app.model.Employee;
import edu.app.model.Project;
import edu.app.services.ManagerRemote;

public class ManagerServiceDelegate{
	
	private static String jndiName = "ejb:/ejb-mn+/Manager!edu.app.services.ManagerRemote";
	
	private static ManagerRemote getProxy(){
		return (ManagerRemote)ServiceLocator.getInstance().getRemoteInterface(jndiName);
	}

	
	
	public static void createEmployee(Employee employee) {
		getProxy().createEmployee(employee);
	}

	public static void createProject(Project project) {
		getProxy().createProject(project);
	}

	public static Employee findEmployeeById(int id) {
		return getProxy().findEmployeeById(id);
	}

	public static Project findProjectBy(int id) {
		return getProxy().findProjectBy(id);
	}

	public static void assignEmployeeToProject(Employee employee, Project project,
			String role) {
		getProxy().assignEmployeeToProject(employee, project, role);
	}

	public static void removeEmployeeFromProject(Employee employee, Project project) {
		getProxy().removeEmployeeFromProject(employee, project);
	}



	public static void removeProject(Project project) {
		getProxy().removeProject(project);
		
	}



	public static List<Employee> findEmployeesInProject(Project project) {
		return getProxy().findEmployeesInProject(project);
		
	}



	public static List<Employee> findEmployeesNotInProject(Project project) {
		return getProxy().findEmployeesNotInProject(project);
	}

}
