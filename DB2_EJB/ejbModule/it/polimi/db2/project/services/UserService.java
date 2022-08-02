package it.polimi.db2.project.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.NonUniqueResultException;

import it.polimi.db2.project.entities.User;
import it.polimi.db2.project.exceptions.*;

@Stateless
public class UserService {
	@PersistenceContext(unitName = "DB2_EJB")
	private EntityManager em;

	public UserService() {
	}

	public User checkCredentials(String email, String pwd) throws CredentialsException, NonUniqueResultException {
		User u = null;
		try {
			u = em.createNamedQuery("User.checkCredentials", User.class).setParameter(1, email).setParameter(2, pwd).getSingleResult();
			return u;
		} catch (EntityNotFoundException e) {
			throw new CredentialsException("No table exists");
		} catch (NullPointerException e) {
			throw new CredentialsException("Wrong Email or Password");
		} catch (NonUniqueResultException e) {
			throw new CredentialsException("More than one user registered with same credentials");
		} catch (NoResultException e) {
			throw new CredentialsException("No user with that email or psw");
		}
	}
	
	public void createUser(String email, String psw, String name, String surname, String role, String username) throws NullException {		
		     if ( email == null || psw ==  null ||  name == null  ||  surname == null || role == null || username == null ) throw new NullException("Data are wrong, please try again"); 
		else {
			User u = new User();
			u.setEmail(email);
			u.setUsername(username);
			u.setName(name);
			u.setSurname(surname);
			u.setPassword(psw);
			u.setRole(role);
			u.setInsolvent(false);
			em.persist(u);
		}
	}
	
	public User findByID(int id) {
		User u = em.createNamedQuery("User.findById", User.class).setParameter(1, id).getSingleResult();
		return u;
	}
	
	public List<User> findAllInsolvent(){
		return em.createNamedQuery("User.findAllInsolvent", User.class).getResultList();
	}
}