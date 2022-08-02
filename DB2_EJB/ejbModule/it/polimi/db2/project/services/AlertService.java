package it.polimi.db2.project.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.polimi.db2.project.entities.Alert;

@Stateless
public class AlertService {
	@PersistenceContext(unitName = "DB2_EJB")
	private EntityManager em;

	public AlertService() {
	}
	
	public List<Alert> findAll(){
		return em.createNamedQuery("Alert.findAll", Alert.class).getResultList();
	}
}