package edu.app.client.tests;

import edu.app.client.locator.ServiceLocator;
import edu.app.entity.Admin;
import edu.app.entity.Employee;
import edu.app.entity.User;
import edu.app.services.AuthenticationRemote;

public class AddSomeUsers {
	
	private AuthenticationRemote remote;
	
	public AddSomeUsers() {
		remote =  (AuthenticationRemote) ServiceLocator.getInstance()
				.getRemoteInterface("ejb:/ejb-inheritence/Authentication!edu.app.services.AuthenticationRemote");
	}
	
	public static void main(String[] args) {
		User u1 = new Admin("admin", "adminpassword", 1);
		User u2 = new Admin("admin2", "adminpassword2", 2);
		User u3 = new Employee("john", "doe", "john@gmail.com");
		AddSomeUsers program = new AddSomeUsers();
		program.remote.createUser(u1);
		program.remote.createUser(u2);
		program.remote.createUser(u3);
	}

}
