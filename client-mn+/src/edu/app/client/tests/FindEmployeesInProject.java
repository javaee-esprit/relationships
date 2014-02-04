package edu.app.client.tests;

import java.util.List;

import edu.app.client.delagate.ManagerServiceDelegate;
import edu.app.model.Employee;
import edu.app.model.Project;

public class FindEmployeesInProject {
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
		
		List<Employee> employees = ManagerServiceDelegate.findEmployeesInProject(p4);
		for(Employee employee : employees){
			System.out.println(employee);
		}
	}
}
