package edu.app.client.tests;

import edu.app.client.delagate.ManagerServiceDelegate;
import edu.app.model.Employee;
import edu.app.model.Project;

public class AssignEmployeesToProjects {
	
	public static void main(String[] args) {
		Employee e1 = ManagerServiceDelegate.findEmployeeById(1);
		Employee e2 = ManagerServiceDelegate.findEmployeeById(2);
		Employee e3 = ManagerServiceDelegate.findEmployeeById(3);
		Employee e4 = ManagerServiceDelegate.findEmployeeById(4);
		Employee e5 = ManagerServiceDelegate.findEmployeeById(5);
		Employee e6 = ManagerServiceDelegate.findEmployeeById(6);
		
		Project p1 = ManagerServiceDelegate.findProjectBy(1);
		Project p2 = ManagerServiceDelegate.findProjectBy(2);
		Project p3 = ManagerServiceDelegate.findProjectBy(3);
		Project p4 = ManagerServiceDelegate.findProjectBy(4);
		
		ManagerServiceDelegate.assignEmployeeToProject(e1, p1, "dev");
		ManagerServiceDelegate.assignEmployeeToProject(e2, p2, "scrum master");
		ManagerServiceDelegate.assignEmployeeToProject(e3, p3, "dev");
		ManagerServiceDelegate.assignEmployeeToProject(e4, p4, "product owner");
		ManagerServiceDelegate.assignEmployeeToProject(e5, p3, "tester");
		ManagerServiceDelegate.assignEmployeeToProject(e6, p4, "boss");
		
		
	}

}
