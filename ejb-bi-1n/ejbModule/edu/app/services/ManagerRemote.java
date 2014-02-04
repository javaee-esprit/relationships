package edu.app.services;

import javax.ejb.Remote;

import edu.app.entity.Department;
import edu.app.entity.Employee;



@Remote
public interface ManagerRemote {
	
	void createDepartment(Department department);
	Department findDepartment(int id);
	void createEmployee(Employee employee);
	Employee findEmployee(int id);

}
