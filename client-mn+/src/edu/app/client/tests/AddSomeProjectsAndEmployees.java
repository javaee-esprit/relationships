package edu.app.client.tests;

import edu.app.client.delagate.ManagerServiceDelegate;
import edu.app.model.Employee;
import edu.app.model.Project;

public class AddSomeProjectsAndEmployees {
	
	public static void main(String[] args) {
		
		Employee e1 = new Employee(1, "slim", "slim@gmail.com");
		Employee e2 = new Employee(2, "amira", "amira@gmail.com");
		Employee e3 = new Employee(3, "fatma", "fatma@gmail.com");
		Employee e4 = new Employee(4, "amine", "amine@gmail.com");
		Employee e5 = new Employee(5, "yesser", "yesser@gmail.com");
		Employee e6 = new Employee(6, "zeineb", "zeineb@gmail.com");
		
		Project p1 = new Project(1, "GAMES PARK");
		Project p2 = new Project(2, "CROWD FUNDING");
		Project p3 = new Project(3, "COLOCATION PLATFORM");
		Project p4 = new Project(4, "ONLINE AUCTION");
		
		ManagerServiceDelegate.createEmployee(e1);
		ManagerServiceDelegate.createEmployee(e2);
		ManagerServiceDelegate.createEmployee(e3);
		ManagerServiceDelegate.createEmployee(e4);
		ManagerServiceDelegate.createEmployee(e5);
		ManagerServiceDelegate.createEmployee(e6);
		
		
		ManagerServiceDelegate.createProject(p1);
		ManagerServiceDelegate.createProject(p2);
		ManagerServiceDelegate.createProject(p3);
		ManagerServiceDelegate.createProject(p4);
	}

}
