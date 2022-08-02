package it.polimi.db2.project.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@IdClass(ReportId.class)
@Table(name = "report_pack_validity", schema = "db2")
@NamedQueries({ @NamedQuery(name = "ReportPackValidity.findAll", query = "SELECT r FROM ReportPackValidity r") })

public class ReportPackValidity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idPackage;
	@Id
	private int idValidityPeriod;
	
	private int numPurchase;

	public ReportPackValidity() {
	}

	public int getIdPackage() {
		return idPackage;
	}

	public void setIdPackage(int idPackage) {
		this.idPackage = idPackage;
	}

	public int getNumPurchase() {
		return numPurchase;
	}

	public void setNumPurchase(int numPurchase) {
		this.numPurchase = numPurchase;
	}

	public int getIdValidity() {
		return idValidityPeriod;
	}

	public void setIdValidity(int idValidity) {
		this.idValidityPeriod = idValidity;
	}

}