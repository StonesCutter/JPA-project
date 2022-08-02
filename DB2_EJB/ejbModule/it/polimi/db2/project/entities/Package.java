package it.polimi.db2.project.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;


@Entity
@Table(name = "package", schema = "db2")
@NamedQueries({ @NamedQuery(name = "Package.findAll", query = "SELECT p FROM Package p"), @NamedQuery(name="Package.findByID", query="SELECT p FROM Package p WHERE p.idPackage = ?1")})
public class Package implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPackage;
	private String packageName;
	
	//bi-directional many-to-one association to ValidityPeriod
	@OneToMany(mappedBy="pack", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true )
	private List<ValidityPeriod> validities;
	
	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="pack", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true )
	private List<Order> orders;
	
	// bi-directional many-to-many association to Services
	@ManyToMany(mappedBy="packages")
	private List<Service> services = new ArrayList<Service>();
	
	// bi-directional many-to-many association to OptionalProducts
	@ManyToMany(mappedBy="pack")
	private List<OptionalProduct> optProducts = new ArrayList<OptionalProduct>();

	public Package() {
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	
	public int getId() {
		return this.idPackage;
	}

	public void setId(int id) {
		this.idPackage = id;
	}
	
	public List<ValidityPeriod> getValidities() {
		return validities;
	}

	public void setValidities(List<ValidityPeriod> validities) {
		this.validities = validities;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}
	
	public void addService(Service s) {
		this.services.add(s);
	}

	public List<OptionalProduct> getOptProducts() {
		return optProducts;
	}

	public void setOptProducts(List<OptionalProduct> optProducts) {
		this.optProducts = optProducts;
	}
	
	public void addOrder(Order o) {
		getOrders().add(o);
	}
	
	public void addValidity (ValidityPeriod v) {
		getValidities().add(v);
	}

	public void removeOrder(Order o) {
		getOrders().remove(o);
	}
	
	public void addOptProd(OptionalProduct o) {
		getOptProducts().add(o);
	}

	public void removeOptProd(OptionalProduct o) {
		getOptProducts().remove(o);
	}

}