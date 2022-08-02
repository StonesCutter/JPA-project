package it.polimi.db2.project.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "validityperiod", schema = "db2")
@NamedQueries({
		@NamedQuery(name = "Validity.findValidityByPackID", query = "SELECT v FROM ValidityPeriod v WHERE v.pack.idPackage = ?1"),
		@NamedQuery(name = "Validity.findByID", query = "SELECT v FROM ValidityPeriod v WHERE v.idvalidityPeriod = ?1"),
		@NamedQuery(name = "Validity.findAll", query = "SELECT v FROM ValidityPeriod v")})

public class ValidityPeriod implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idvalidityPeriod;

	// bi-directional many-to-one association to Package
	@ManyToOne
	@JoinColumn(name = "idPackage")
	private Package pack;

	private int months;
	private int monthlyFee;

	public ValidityPeriod() {
	}

	public int getId() {
		return this.idvalidityPeriod;
	}

	public void setId(int id) {
		this.idvalidityPeriod = id;
	}

	public int getMonths() {
		return months;
	}

	public void setMonths(int months) {
		this.months = months;
	}

	public int getMonthlyFee() {
		return monthlyFee;
	}

	public void setMonthlyFee(int monthlyFee) {
		this.monthlyFee = monthlyFee;
	}

	public Package getPackage() {
		return pack;
	}

	public void setPackage(Package idPackage) {
		this.pack = idPackage;
	}

}