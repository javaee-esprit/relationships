package edu.app.client.tests;

import edu.app.client.locator.ServiceLocator;
import edu.app.entity.Admin;
import edu.app.entity.Employee;
import edu.app.entity.User;
import edu.app.services.AuthenticationRemote;

public class TestAuthenticate {
	
	private AuthenticationRemote remote;
	
	public TestAuthenticate() {
		remote = (AuthenticationRemote) ServiceLocator.getInstance()
.getRemoteInterface("ejb:/ejb-inheritence/Authentication!edu.app.services.AuthenticationRemote");
	}
	
	public static void main(String[] args) {
		TestAuthenticate test = new TestAuthenticate();
		User user = test.remote.authenticate("john", "doe");
		if(user == null){
			System.out.println("FAILED");
		}else{
			if(user instanceof Admin){
				System.out.println("ADMIN OK");
			}else if(user instanceof Employee){
				System.out.println("EMPLOYEE OK");
			}
			
		}
	}

}
