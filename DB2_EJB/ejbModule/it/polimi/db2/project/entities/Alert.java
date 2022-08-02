package it.polimi.db2.project.entities;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "alert", schema = "db2")
@NamedQueries({ @NamedQuery(name = "Alert.findAll", query = "SELECT a FROM Alert a"),
		@NamedQuery(name = "Alert.findByUser", query = "SELECT a FROM Alert a WHERE a.user.idUser = ?1"), })

public class Alert implements Serializable {
	private static final long serialVersionUID = 1L;

	// bi-directional many-to-one association to Package
	@Id
	@OneToOne
	@JoinColumn(name = "idUser")
	private User user;

	@Temporal(TemporalType.DATE)
	private Date date;

	private int totAmount;

	public Alert() {
	}

	public int getTotalAmount() {
		return totAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totAmount = totalAmount;
	}

	public String getDate() {
		DateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
		return (formatter.format(date));
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User idUser) {
		this.user = idUser;
	}
}