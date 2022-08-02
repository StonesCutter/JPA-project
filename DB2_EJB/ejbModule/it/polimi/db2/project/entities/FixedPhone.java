package it.polimi.db2.project.entities;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name = "service", schema = "db2")
@DiscriminatorValue("Fixed Phone")
@NamedQuery(name = "FixedPhone.findServicesByPackID", query = "SELECT s FROM FixedPhone s JOIN s.packages p WHERE p.idPackage = ?1")
public class FixedPhone extends Service implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public FixedPhone() {
		super();
	}

}