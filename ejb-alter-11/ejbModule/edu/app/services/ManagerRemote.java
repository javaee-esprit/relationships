package edu.app.services;

import javax.ejb.Remote;

import edu.app.entity.Address;
import edu.app.entity.Employee;



@Remote
public interface ManagerRemote {
	
	void createEmployee(Employee employee);
	Employee findEmployee(int id);

}
