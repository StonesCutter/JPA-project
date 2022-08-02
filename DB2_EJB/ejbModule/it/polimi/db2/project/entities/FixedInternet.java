package it.polimi.db2.project.entities;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name = "service", schema = "db2")
@DiscriminatorValue("Fixed Internet")
@NamedQuery(name = "FixedInternet.findServicesByPackID", query = "SELECT s FROM FixedInternet s JOIN s.packages p WHERE p.idPackage = ?1")
public class FixedInternet extends Service implements Serializable  {
	private static final long serialVersionUID = 1L;
	
	private int GB;
	private int feeExtraGB;
	
/*	@ManyToMany
	@JoinTable(name = "pack-serv", schema = "db2", joinColumns = @JoinColumn(name = "idService"), inverseJoinColumns = @JoinColumn(name = "idPackage"))
	private List<Package> packages;*/
	
	public FixedInternet() {
		super();
	}
	
	@Column(name="serviceType", insertable = false, updatable = false)
	protected String type;

	public String getSubTypeId() {
	    return type;
	}

	/*public String getServiceType() {
		return super.getType();
	}
	
	public void setServiceType() {
		super.setType("FixedInternet");
	}*/
	
	public int getId() {
		return super.getId();
	}

	public void setId(int id) {
		super.setId(id);
	}
	
	public int getGB() {
		return GB;
	}

	public void setGB(int gB) {
		GB = gB;
	}

	public int getFeeExtraGB() {
		return feeExtraGB;
	}

	public void setFeeExtraGB(int feeExtraGB) {
		this.feeExtraGB = feeExtraGB;
	}


}