package edu.app.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.app.entity.Address;
import edu.app.entity.Employee;



/**
 * Session Bean implementation class Manager
 */
@Stateless
public class Manager implements ManagerRemote {
	
	@PersistenceContext( unitName = "myPU" )
	private EntityManager em;

    /**
     * Default constructor. 
     */
    public Manager() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void createAddress(Address address) {
		em.persist(address);
		
	}

	@Override
	public Address findAddress(int id) {
		
		return em.find(Address.class, id);
	}

	

	

	@Override
	public void createEmployee(Employee employee) {
		em.persist(em.merge(employee));
		
	}

	@Override
	public Employee findEmployee(int id) {
		return em.find(Employee.class, id);
	}
	
	
	
    
    

}
