package edu.app.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.app.entity.Project;
import edu.app.entity.Employee;


@Stateless
public class Manager implements ManagerRemote {
	
	@PersistenceContext( unitName = "myPU" )
	private EntityManager em;

    /**
     * Default constructor. 
     */
    public Manager() {
    }

	@Override
	public void createProject(Project project) {
		em.persist(project);
		
	}

	@Override
	public Project findProject(int id) {
		
		return em.find(Project.class, id);
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
