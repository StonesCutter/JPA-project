package it.polimi.db2.project.entities;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name = "service", schema = "db2")
@DiscriminatorValue("Mobile Internet")
@NamedQuery(name = "MobileInternet.findServicesByPackID", query = "SELECT s FROM MobileInternet s JOIN s.packages p WHERE p.idPackage = ?1")
public class MobileInternet extends Service implements Serializable {
	private static final long serialVersionUID = 1L;

	private int GB;
	private int feeExtraGB;
	
	public MobileInternet() {
		super();
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