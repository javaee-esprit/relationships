package edu.app.services;

import java.util.List;

import javax.ejb.Remote;

import edu.app.entity.Employee;
import edu.app.entity.User;

@Remote
public interface AuthenticationRemote {
	void createUser(User user);
	List<User> findAllUsers();
	User authenticate(String login, String password);
	List<Employee> findAllEmployees();
	void saveOrUpdate(Employee employee);
}
