package it.polimi.db2.project.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.polimi.db2.project.entities.OptionalProduct;
import it.polimi.db2.project.entities.Order;
import it.polimi.db2.project.entities.ValidityPeriod;
import it.polimi.db2.project.entities.Service;
import it.polimi.db2.project.entities.Package;
import it.polimi.db2.project.exceptions.*;

import java.util.ArrayList;
import java.util.List;

@Stateless
public class PackageService {
	@PersistenceContext(unitName = "DB2_EJB")
	private EntityManager em;

	public PackageService() {
	}
	
	public Package createPackage(String packageName, List<Integer> optProductID) throws NullException {
		List<OptionalProduct> optProd = new ArrayList<OptionalProduct>();
		for (int i = 0; i<optProductID.size(); i++) {
			optProd.add(em.find(OptionalProduct.class, optProductID.get(i)));
		}
		List<Order> orders = new ArrayList<Order>();
		List<ValidityPeriod> validities = new ArrayList<ValidityPeriod>();
		List<Service> s = new ArrayList<Service>();
		
		if (packageName == null || optProd==null || packageName.isEmpty()) throw new NullException("Data are wrong, please try again"); 
		else {
			Package p = new Package();
			p.setPackageName(packageName);
			p.setOrders(orders);
			p.setServices(s);
			p.setOptProducts(optProd);
			p.setValidities(validities);
			for (int i = 0; i < optProd.size(); i++) {
				optProd.get(i).addPack(p);
			}
			em.persist(p);
			return p;
		}
	}
	
	public List<Package> findAll(){
		return em.createNamedQuery("Package.findAll", Package.class)
				.getResultList();
	}
	
	public Package findByID(int packID) {
		return em.createNamedQuery("Package.findByID", Package.class).setParameter(1, packID)
				.getSingleResult();
	}

}