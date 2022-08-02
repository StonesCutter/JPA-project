package it.polimi.db2.project.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "optionalproduct", schema = "db2")
@NamedQueries({ @NamedQuery(name = "OptionalProduct.findAll", query = "SELECT o FROM OptionalProduct o"),
	@NamedQuery(name = "OptionalProduct.findOptByPackID", query = "SELECT o FROM OptionalProduct o JOIN o.pack p WHERE p.idPackage = ?1"),
	@NamedQuery(name = "OptionalProduct.findByID", query = "SELECT o FROM OptionalProduct o WHERE o.idOptionalProduct = ?1")
	//@NamedQuery(name = "OptionalProduct.findBestSeller", query = "SELECT max(o.sizeOrders) FROM OptionalProduct o")
})
public class OptionalProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idOptionalProduct;
	
	@ManyToMany
	@JoinTable(name = "ord_optprod", schema = "db2", joinColumns = @JoinColumn(name = "idOptionalproduct"), inverseJoinColumns = @JoinColumn(name = "idOrder"))
	private List<Order> orders = new ArrayList<Order>();
		
	// bi-directional many-to-many association to OptionalProducts
	@ManyToMany
	@JoinTable(name = "pack_optprod", schema = "db2", joinColumns = @JoinColumn(name = "idOptionalproduct"), inverseJoinColumns = @JoinColumn(name = "idPackage"))
	private List<Package> pack = new ArrayList<Package>();
	
	private String description;
	private String optionalProductName;
	private int monthlyFeeOptProd;

	public OptionalProduct() {
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String packageName) {
		this.description = packageName;
	}
	
	public int getId() {
		return this.idOptionalProduct;
	}

	public void setId(int id) {
		this.idOptionalProduct = id;
	}
	
	public String getName() {
		return optionalProductName;
	}

	public void setName(String optionalProductName) {
		this.optionalProductName = optionalProductName;
	}

	public int getMonthlyFee() {
		return monthlyFeeOptProd;
	}

	public void setMonthlyFee(int monthlyFeeOptionalProduct) {
		this.monthlyFeeOptProd = monthlyFeeOptionalProduct;
	}

	public List<Package> getPack() {
		return pack;
	}

	public void setPack(List<Package> pack2) {
		this.pack = pack2;
	}
	
	public void addPack(Package p) {
		this.pack.add(p);
	}
	
	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> o) {
		this.orders = o;
	}
	
	public void addOrder(Order o) {
		this.orders.add(o);
	}

}