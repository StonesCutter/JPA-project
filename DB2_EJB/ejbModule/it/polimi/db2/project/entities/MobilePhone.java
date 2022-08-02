package it.polimi.db2.project.entities;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name = "service", schema = "db2")
@DiscriminatorValue("Mobile Phone")
@NamedQuery(name = "MobilePhone.findServicesByPackID", query = "SELECT s FROM MobilePhone s JOIN s.packages p WHERE p.idPackage = ?1")
public class MobilePhone extends Service implements Serializable {
	private static final long serialVersionUID = 1L;

	private int minutes;
	private int SMS;
	private int feeExtraMin;
	private int feeExtraSMS;
	
	public MobilePhone() {
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getSMS() {
		return SMS;
	}

	public void setSMS(int sMS) {
		SMS = sMS;
	}

	public int getFeeExtraMin() {
		return feeExtraMin;
	}

	public void setFeeExtraMin(int feeExtraMin) {
		this.feeExtraMin = feeExtraMin;
	}

	public int getFeeExtraSMS() {
		return feeExtraSMS;
	}

	public void setFeeExtraSMS(int feeExtraSMS) {
		this.feeExtraSMS = feeExtraSMS;
	}


}