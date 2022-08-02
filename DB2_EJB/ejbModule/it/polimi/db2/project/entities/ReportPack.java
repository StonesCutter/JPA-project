package it.polimi.db2.project.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "report_pack", schema = "db2")
@NamedQueries({ @NamedQuery(name = "ReportPack.findAll", query = "SELECT a FROM ReportPack a") })

public class ReportPack implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idPackage;
	
	private int numPurchase;
	private int totAmount;
	private int totAmountWithoutOpt;
	private float avgOptProducts;

	public ReportPack() {
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

	public int getTotAmount() {
		return totAmount;
	}

	public void setTotAmount(int totAmount) {
		this.totAmount = totAmount;
	}

	public int getTotAmountWithoutOpt() {
		return totAmountWithoutOpt;
	}

	public void setTotAmountWithoutOpt(int totAmountWithoutOpt) {
		this.totAmountWithoutOpt = totAmountWithoutOpt;
	}

	public float getAvgOptProducts() {
		return avgOptProducts;
	}

	public void setAvgOptProducts(float avgOptProducts) {
		this.avgOptProducts = avgOptProducts;
	}
}