package it.polimi.db2.project.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.polimi.db2.project.entities.ReportOptProducts;
import it.polimi.db2.project.entities.ReportPack;
import it.polimi.db2.project.entities.ReportPackValidity;

@Stateless
public class ReportService {
	@PersistenceContext(unitName = "DB2_EJB")
	private EntityManager em;

	public ReportService() {
	}

	// trova tutte le tipologie di package acquistati
	public List<ReportPack> findPurchaseByPack(){
		return em.createNamedQuery("ReportPack.findAll", ReportPack.class).getResultList();
	}
	// trova tutte le tipologie di package acquistati per validity period
	public List<ReportPackValidity> findPurchaseByPackAndValidity(){
		return em.createNamedQuery("ReportPackValidity.findAll", ReportPackValidity.class).getResultList();
	}
	// trova il bestseller tra gli optionalproduct
	public List<ReportOptProducts> findBestSeller(){
		return em.createNamedQuery("ReportOptProduct.findBestSeller", ReportOptProducts.class).getResultList();
	}
}