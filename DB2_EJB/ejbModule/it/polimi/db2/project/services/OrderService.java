package it.polimi.db2.project.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.polimi.db2.project.entities.*;
import it.polimi.db2.project.entities.Package;
import it.polimi.db2.project.exceptions.NullException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Stateless
public class OrderService {
	@PersistenceContext(unitName = "DB2_EJB")
	private EntityManager em;

	public OrderService() {
		// TODO Auto-generated constructor stub
	}

	public Order findById(int id) {
		return em.find(Order.class, id);
	}

	public List<Order> findByUser(String email) {
		return em.createNamedQuery("Order.findByUser", Order.class).setParameter("email", email).getResultList();
	}

	public List<Order> findRejectedByUser(String email) {
		return em.createNamedQuery("Order.findRejectedByUser", Order.class).setParameter("email", email)
				.getResultList();
	}

	public List<OptionalProduct> findOptProd(int id) {
		return em.find(Order.class, id).getOptProducts();
	}
	
	/*public Order findMaxByUser(String email) {
		return em.createNamedQuery("Order.findLastByUser", Order.class).setParameter("email", email).getSingleResult();
	}*/
	
	public List<Order> findAllRejected() {
		return em.createNamedQuery("Order.findAllRejected", Order.class)
				.getResultList();
	}
	
	public void createOrder(int userID, int validityID, int packID, Date from, int totalAmount, Boolean status,
			List<Integer> optProdID, Date now) throws NullException {
		
		User u = em.find(User.class, userID);
		ValidityPeriod v = em.find(ValidityPeriod.class, validityID);
		Package p = em.find(Package.class, packID);

		List<OptionalProduct> opt = new ArrayList<OptionalProduct>();
		if (!optProdID.isEmpty()) {
			for (int i = 0; i < optProdID.size(); i++) {
				opt.add(em.find(OptionalProduct.class, optProdID.get(i)));
			}
			if (opt.isEmpty()) {
				throw new NullException("Data are wrong, please try again");
			}
		}

		if (u == null || v == null || p == null || now == null) {
			System.out.println("we are here");
			throw new NullException("Data are wrong, please try again");
		} else {
			Order o = new Order();
			o.setUser(u);
			o.setPeriod(v);
			o.setPack(p);
			if (opt != null)
				o.setOptProducts(opt);
			o.setFromWhen(from);
			o.setTotalAmount(totalAmount);
			o.setStatus(status);
			if (status == false) {
				u.setInsolvent(true);
			}
			u.addOrder(o);
			p.addOrder(o); // needed for the employee to show the number of total purchases per package
			o.setDate(now);
			em.persist(o);
		}
	}
}

/*
 * public void addTagToPhoto(int photoId, String label) { Photo ph =
 * em.find(Photo.class, photoId); Tag existingTag = null; // This line missing
 * in V1, added in V2 if (ph == null) return; List<Tag> tags =
 * em.createNamedQuery("Tag.findByLabel", Tag.class).setParameter("label",
 * label).getResultList(); if (tags.isEmpty()) { Tag t = new Tag();
 * em.persist(t); t.setLabel(label); t.addPhoto(ph); ph.addTag(t); } else {
 * existingTag = tags.get(0); // This line missing in V1, added in V2
 * ph.addTag(existingTag); existingTag.addPhoto(ph); // This line missing in V1,
 * added in V2 } }
 * 
 * public void deletePhoto(int photoId) { Photo ph = em.find(Photo.class,
 * photoId); if (ph == null) return; em.remove(ph); }
 */
