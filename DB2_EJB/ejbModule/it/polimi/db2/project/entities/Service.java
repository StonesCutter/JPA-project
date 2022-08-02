package it.polimi.db2.project.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "service", schema = "db2")
//@NamedQuery(name = "Service.findServicesByPackID", query = "SELECT s FROM Service s JOIN s.packages p WHERE p.idPackage = ?1")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
    name = "serviceType"
)
public abstract class Service implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idService;
	//private String type;
	
	@ManyToMany
	@JoinTable(name = "pack_serv", schema = "db2", joinColumns = @JoinColumn(name = "idService"), inverseJoinColumns = @JoinColumn(name = "idPackage"))
	private List<Package> packages = new ArrayList<Package>();
	
	public Service() {
	}

	public int getId() {
		return this.idService;
	}

	public void setId(int id) {
		this.idService = id;
	}
	
	public List<Package> getPackages() {
		return packages;
	}

	public void setPackages(List<Package> packages) {
		this.packages = packages;
	}
	
	public void addPackage(Package p) {
		this.packages.add(p);
	}
}