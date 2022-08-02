package it.polimi.db2.project.entities;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "order", schema = "db2")
@NamedQueries({ @NamedQuery(name = "Order.findAll", query = "SELECT o FROM Order o"),
	@NamedQuery(name = "Order.findByUser", query = "SELECT o FROM Order o WHERE o.user.email = :email"),
	@NamedQuery(name = "Order.findAllRejected", query = "SELECT o FROM Order o WHERE o.status=false"), 
	@NamedQuery(name = "Order.findRejectedByUser", query = "SELECT o FROM Order o WHERE o.status=false AND o.user.email = :email"), 
})

public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idOrder;
	
	// bi-directional many-to-one association to Package
	@ManyToOne
	@JoinColumn(name = "idPackage")
	private Package pack;

	// bi-directional many-to-one association to Package
	@ManyToOne
	@JoinColumn(name = "idUser")
	private User user;
	
	// bi-directional many-to-one association to Package
	//NON CI INTERESSA AVERE LA LISTA DEGLI ORDINI CON UNA DETERMINATA VALIDITY QUINDI POSSO ANCHE NON METTERE LA LISTA IN ValidityPeriod ???
	@ManyToOne
	@JoinColumn(name = "idvalidityPeriod")
	private ValidityPeriod period;
	
	// bi-directional many-to-many association to OptionalProducts
	@ManyToMany
	@JoinTable(name = "ord_optprod", schema = "db2", joinColumns = @JoinColumn(name = "idOrder"), inverseJoinColumns = @JoinColumn(name = "idOptionalproduct"))
	private List<OptionalProduct> optProducts = new ArrayList<OptionalProduct>();

	@Temporal(TemporalType.DATE)
	private Date date;
	
	private int totalAmount;
	private Date fromWhen;
	private Boolean status;
	
	public Order() {
	}

	public int getId() {
		return this.idOrder;
	}

	public void setId(int id) {
		this.idOrder = id;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getDate() {
		DateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
		return (formatter.format(date));
	}
	
	public Date getDateInDateType() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getFromWhen() {
		return fromWhen;
	}

	public void setFromWhen(Date fromWhen) {
		this.fromWhen = fromWhen;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Package getPack() {
		return pack;
	}

	public void setPack(Package idPackage) {
		this.pack = idPackage;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User idUser) {
		this.user = idUser;
	}

	public ValidityPeriod getPeriod() {
		return period;
	}

	public void setPeriod(ValidityPeriod idValidity) {
		this.period = idValidity;
	}

	public List<OptionalProduct> getOptProducts() {
		return optProducts;
	}

	public void setOptProducts(List<OptionalProduct> optProducts) {
		this.optProducts = optProducts;
	}
	
}