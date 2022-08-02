package it.polimi.db2.project.entities;

import java.io.Serializable;
import java.util.Objects;

public class ReportId implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idPackage;

	private int idValidityPeriod;

	public ReportId(int idPackage, int idValidity) {
	        this.idPackage = idPackage;
	        this.idValidityPeriod = idValidity;
	    }
	
	public ReportId() {
		super();
    }

	@Override
	public int hashCode() {
		return Objects.hash(idPackage, idValidityPeriod);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReportId other = (ReportId) obj;
		return idPackage == other.idPackage && idValidityPeriod == other.idValidityPeriod;
	}
}