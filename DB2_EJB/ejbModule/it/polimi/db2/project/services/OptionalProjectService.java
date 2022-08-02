package it.polimi.db2.project.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.polimi.db2.project.entities.OptionalProduct;
import it.polimi.db2.project.exceptions.*;
import it.polimi.db2.project.entities.Package;

import java.util.ArrayList;
import java.util.List;

@Stateless
public class OptionalProjectService {
	@PersistenceContext(unitName = "DB2_EJB")
	private EntityManager em;

	public OptionalProjectService() {
	}
	
	public void createOptProduct(String description, String name, int monthlyFee, List<Integer> p) throws NullException {
		List<Package> pack = new ArrayList<Package>();
		for (int i=0; i<p.size(); i++) {
				pack.add(em.find(Package.class, p.get(i)));
		}
		if (description == null || name == null || monthlyFee <= 0 || pack == null || pack.isEmpty()) throw new NullException("Data are wrong, please try again"); 
		else {
			OptionalProduct optProd = new OptionalProduct();
			optProd.setMonthlyFee(monthlyFee);
			optProd.setName(name);
			optProd.setDescription(description);
			optProd.setPack(pack);
			for (int i=0; i<p.size(); i++) {
				pack.get(i).addOptProd(optProd);
			}
			em.persist(optProd);
		}
	}
	
	public List<OptionalProduct> findAll(){
		return em.createNamedQuery("OptionalProduct.findAll", OptionalProduct.class)
				.getResultList();
	}
	
	public List<OptionalProduct> findByPackID(int packID){
		return em.createNamedQuery("OptionalProduct.findOptByPackID", OptionalProduct.class).setParameter(1, packID)
				.getResultList();
	}
	
	public OptionalProduct findByID(int optID){
		return em.createNamedQuery("OptionalProduct.findByID", OptionalProduct.class).setParameter(1, optID)
				.getSingleResult();
	}
}