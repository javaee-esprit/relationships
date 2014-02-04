package edu.app.client.delegate;

import java.util.List;

import edu.app.client.locator.ServiceLocator;
import edu.app.entity.Employee;
import edu.app.entity.User;
import edu.app.services.AuthenticationRemote;

public class AuthenticationServiceDelegate {
	
	private static final String jndiName = "ejb:/ejb-inheritence/Authentication!edu.app.services.AuthenticationRemote";

	public static void createUser(User user) {
		((AuthenticationRemote)ServiceLocator.getInstance().getRemoteInterface(jndiName)).createUser(user);
		
	}

	public static List<User> findAllUsers() {
		return ((AuthenticationRemote)ServiceLocator.getInstance().getRemoteInterface(jndiName)).findAllUsers();
	}

	public static User authenticate(String login, String password) {
		return ((AuthenticationRemote)ServiceLocator.getInstance().getRemoteInterface(jndiName)).authenticate(login, password);
	}

	public static List<Employee> findAllEmployee() {
		return ((AuthenticationRemote)ServiceLocator.getInstance().getRemoteInterface(jndiName)).findAllEmployees();
	}

	public static void saveOrUpdate(Employee employee) {
		((AuthenticationRemote)ServiceLocator.getInstance().getRemoteInterface(jndiName)).saveOrUpdate(employee);
		
	}

}
