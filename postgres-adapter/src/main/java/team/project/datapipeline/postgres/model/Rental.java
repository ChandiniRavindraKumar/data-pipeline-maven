package team.project.datapipeline.postgres.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the rental database table.
 * 
 */
@Entity
@Table(name="rental")
@NamedQuery(name="Rental.findAll", query="SELECT r FROM Rental r")
public class Rental implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="rental_id", unique=true, nullable=false)
	private Integer rentalId;

	@Column(name="last_update", nullable=false)
	private Timestamp lastUpdate;

	@Column(name="rental_date", nullable=false)
	private Timestamp rentalDate;

	@Column(name="return_date")
	private Timestamp returnDate;

	//bi-directional many-to-one association to Payment
	@OneToMany(mappedBy="rental")
	@JsonIgnore
	private List<Payment> payments;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="customer_id", nullable=false)
	private Customer customer;

	//bi-directional many-to-one association to Inventory
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="inventory_id", nullable=false)
	private Inventory inventory;

	//bi-directional many-to-one association to Staff
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="staff_id", nullable=false)
	private Staff staff;

	public Rental() {
	}

	public Integer getRentalId() {
		return this.rentalId;
	}

	public void setRentalId(Integer rentalId) {
		this.rentalId = rentalId;
	}

	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Timestamp getRentalDate() {
		return this.rentalDate;
	}

	public void setRentalDate(Timestamp rentalDate) {
		this.rentalDate = rentalDate;
	}

	public Timestamp getReturnDate() {
		return this.returnDate;
	}

	public void setReturnDate(Timestamp returnDate) {
		this.returnDate = returnDate;
	}

	public List<Payment> getPayments() {
		return this.payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public Payment addPayment(Payment payment) {
		getPayments().add(payment);
		payment.setRental(this);

		return payment;
	}

	public Payment removePayment(Payment payment) {
		getPayments().remove(payment);
		payment.setRental(null);

		return payment;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Inventory getInventory() {
		return this.inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public Staff getStaff() {
		return this.staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

}