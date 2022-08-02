package it.polimi.db2.project.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "report_optProd", schema = "db2")
@NamedQueries({ @NamedQuery(name = "ReportOptProduct.findBestSeller", query = "SELECT r FROM ReportOptProducts r ORDER BY r.sales DESC") })

public class ReportOptProducts implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idOptionalProduct;
	private int sales;

	public ReportOptProducts() {
	}

	public int getIdOptionalProduct() {
		return idOptionalProduct;
	}

	public void setIdOptionalProduct(int idOptionalProduct) {
		this.idOptionalProduct = idOptionalProduct;
	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	

}