package it.polimi.db2.project.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;


@Entity
@Table(name = "user", schema = "db2")
@NamedQueries({ @NamedQuery(name = "User.findAllInsolvent", query = "SELECT u FROM User u WHERE u.insolvent=true"),
	@NamedQuery(name = "User.checkCredentials", query = "SELECT r FROM User r  WHERE r.email = ?1 and r.password = ?2"),
	@NamedQuery(name = "User.findById", query="SELECT u FROM User u WHERE u.idUser = ?1")})

public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUser;
	
	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="user", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true )
	private List<Order> orders;
	
	//bi-directional many-to-one association to Order
	@OneToOne(mappedBy="user")
	private Alert alert;

	private String Name;

	private String password;

	private String Surname;

	private String email;
	
	private String role;
	
	private Boolean insolvent;
	
	private String username;

	public User() {
	}

	public int getId() {
		return this.idUser;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return this.username;
	}

	public void setId(int id) {
		this.idUser = id;
	}

	public String getName() {
		return this.Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSurname() {
		return this.Surname;
	}

	public void setSurname(String surname) {
		this.Surname = surname;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public Boolean getInsolvent() {
		return this.insolvent;
	}

	public void setInsolvent(Boolean insolvent) {
		this.insolvent = insolvent;
	}
	
	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	public void addOrder(Order o) {
		getOrders().add(o);
		o.setUser(this);
	}

	public void removeOrder(Order o) {
		getOrders().remove(o);
		o.setUser(null);
	}
	
	public Alert getAlert() {
		return this.alert;
	}
	
	public void setAlert(Alert alert) {
		this.alert = alert;
	}
}