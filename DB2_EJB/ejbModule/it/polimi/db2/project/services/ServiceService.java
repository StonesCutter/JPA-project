package it.polimi.db2.project.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import it.polimi.db2.project.entities.Package;
import it.polimi.db2.project.entities.FixedInternet;
import it.polimi.db2.project.entities.FixedPhone;
import it.polimi.db2.project.entities.MobileInternet;
import it.polimi.db2.project.entities.MobilePhone;
import it.polimi.db2.project.entities.Service;
import it.polimi.db2.project.exceptions.*;

@Stateless
public class ServiceService {
	@PersistenceContext(unitName = "DB2_EJB")
	private EntityManager em;

	public ServiceService() {
	}

	public Service createMobileInternet(int gb, int feeExtraGB) throws NullException {
		if (gb <= 0 || feeExtraGB <= 0)
			throw new NullException("Data are wrong, please try again");
		else {
			MobileInternet m = new MobileInternet();
			List<Package> p = new ArrayList<Package>();
			m.setPackages(p);
			m.setFeeExtraGB(feeExtraGB);
			m.setGB(gb);
			em.persist(m);
			return m;
		}
	}

	public Service createFixedInternet(int gb, int feeExtraGB, Package p) throws NullException {
		if (gb <= 0 || feeExtraGB <= 0)
			throw new NullException("Data are wrong, please try again");
		else {
			FixedInternet m = new FixedInternet();
			List<Package> packages = new ArrayList<Package>();
			packages.add(p);
			m.setPackages(packages);
			m.setFeeExtraGB(feeExtraGB);
			m.setGB(gb);
			em.persist(m);
			return m;
		}
	}

	public Service createMobilePhone(int min, int sms, int feeExtraMin, int feeExtraSMS) throws NullException {
		if (min <= 0 || feeExtraMin <= 0 || sms <= 0 || feeExtraSMS <= 0)
			throw new NullException("Data are wrong, please try again");
		else {
			MobilePhone m = new MobilePhone();
			List<Package> p = new ArrayList<Package>();
			m.setPackages(p);
			m.setFeeExtraMin(feeExtraMin);
			m.setFeeExtraSMS(feeExtraSMS);
			m.setMinutes(min);
			m.setSMS(sms);
			em.persist(m);
			return m;
		}
	}

	public Service createFixedPhone() throws NullException {
		FixedPhone m = new FixedPhone();
		List<Package> p = new ArrayList<Package>();
		m.setPackages(p);
		em.persist(m);
		return m;
	}

	public List<Service> findAll() {
		return em.createNamedQuery("Service.findAll", Service.class).getResultList();
	}

	public FixedPhone findFPByPackID(int packID) {
		try {
			return em.createNamedQuery("FixedPhone.findServicesByPackID", FixedPhone.class).setParameter(1, packID)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public MobileInternet findMIByPackID(int packID) {
		try {
			return em.createNamedQuery("MobileInternet.findServicesByPackID", MobileInternet.class)
					.setParameter(1, packID).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public FixedInternet findFIByPackID(int packID) {
		try {
			return em.createNamedQuery("FixedInternet.findServicesByPackID", FixedInternet.class)
					.setParameter(1, packID).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public MobilePhone findMPByPackID(int packID) {
		try {
			return em.createNamedQuery("MobilePhone.findServicesByPackID", MobilePhone.class).setParameter(1, packID)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}