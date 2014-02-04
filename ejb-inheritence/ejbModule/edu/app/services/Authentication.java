package edu.app.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.app.entity.Employee;
import edu.app.entity.User;

/**
 * Session Bean implementation class Authentication
 */
@Stateless
public class Authentication implements AuthenticationRemote {

	@PersistenceContext(unitName = "myPU")
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public Authentication() {
        
    }

	@Override
	public void createUser(User user) {
		em.persist(user);
		
	}
	

	@Override
	public User authenticate(String login, String password) {
		String jpql = "select u from User u where u.login=:login and u.password=:password";
		User found = null;
		Query query = em.createQuery(jpql);
		query.setParameter("login", login);
		query.setParameter("password", password);
		try{
			found = (User) query.getSingleResult();
		}catch(Exception ex){
		}
		return found;
	}

	@SuppressWarnings("unchecked")
	public List<User> findAllUsers() {
		
		return em.createNamedQuery("all-employees").getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Employee> findAllEmployees() {
		
		return em.createQuery("select e from Employee e").getResultList();
	}

	public void saveOrUpdate(Employee employee) {
		em.merge(employee);
	}

}
