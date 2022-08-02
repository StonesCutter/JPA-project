package it.polimi.db2.project.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.polimi.db2.project.entities.ValidityPeriod;
import it.polimi.db2.project.entities.Package;
import it.polimi.db2.project.exceptions.*;

@Stateless
public class ValidityPeriodService {
	@PersistenceContext(unitName = "DB2_EJB")
	private EntityManager em;

	public ValidityPeriodService() {
	}

	public void createValidityPeriod(int monthlyFee, int months, int packID) throws NullException {
		Package pack = em.find(Package.class, packID);
		
		if (pack == null || monthlyFee<=0 || months<=0) throw new NullException("Data are wrong, please try again"); 
		else {
			ValidityPeriod v = new ValidityPeriod();
			v.setMonthlyFee(monthlyFee);
			v.setMonths(months);
			v.setPackage(pack);
			pack.addValidity(v);
			em.persist(v);
		}
	}
	
	public List<ValidityPeriod> findByPackID(int packID){
		return em.createNamedQuery("Validity.findValidityByPackID", ValidityPeriod.class).setParameter(1, packID)
				.getResultList();
	}
	
	public ValidityPeriod findByID(int valID){
		return em.createNamedQuery("Validity.findByID", ValidityPeriod.class).setParameter(1, valID)
				.getSingleResult();
	}
	
	public List<ValidityPeriod> findAll(){
		return em.createNamedQuery("Validity.findAll", ValidityPeriod.class)
				.getResultList();
	}
}