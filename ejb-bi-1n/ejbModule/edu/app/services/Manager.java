package edu.app.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.app.entity.Department;
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
	public void createDepartment(Department department) {
		em.persist(department);
		
	}

	@Override
	public Department findDepartment(int id) {
		
		return em.find(Department.class, id);
	}

	

	

	@Override
	public void createEmployee(Employee employee) {
		em.persist(employee);
		
	}

	@Override
	public Employee findEmployee(int id) {
		return em.find(Employee.class, id);
	}
	
	
	
    
    

}
