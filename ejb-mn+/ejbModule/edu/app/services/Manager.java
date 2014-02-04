package edu.app.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.app.model.Employee;
import edu.app.model.Participation;
import edu.app.model.Project;

@Stateless
public class Manager implements ManagerRemote, ManagerLocal {

	@PersistenceContext
	private EntityManager em;
	
    public Manager() {
    }

	public void createEmployee(Employee employee) {
		em.persist(employee);
	}

	public void createProject(Project project) {
		em.persist(project);
	}

	public Employee findEmployeeById(int id) {
		return em.find(Employee.class, id);
	}

	public Project findProjectBy(int id) {
		return em.find(Project.class, id);
	}

	public void assignEmployeeToProject(Employee employee, Project project,
			String role) {
		Participation participation = new Participation(employee, project, role);
		em.persist(participation);
	}

	public void removeEmployeeFromProject(Employee employee, Project project) {
		Participation participation = new Participation(employee, project, "");
		em.remove(em.merge(participation));
		
	}

	public void removeProject(Project project) {
		em.remove(em.merge(project));
		
	}

	@SuppressWarnings("unchecked")
	public List<Employee> findEmployeesInProject(Project project) {
		return em.createQuery("select e from Employee e join e.participations part where part.project=:p").setParameter("p", project).getResultList();
		
	}

	public List<Employee> findEmployeesNotInProject(Project project) {
		// 2 pts
		return null;
	}

}
