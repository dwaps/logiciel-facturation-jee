package fr.dwaps.model.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import fr.dwaps.model.BillStatus;

@Entity
@Table(name="bill")
public class Bill implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final float TVA = 20.00f;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(length=5, nullable=false, unique=true)
	private String ref;
	@Transient
	private double subTotal; /* Without TVA */
	@Column(length=6)
	private double total;

	@Enumerated(EnumType.STRING)
	@Column(nullable=false, columnDefinition="VARCHAR(90) DEFAULT 'DRAFT'")
	private BillStatus status = BillStatus.DRAFT;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date createdAt; /* PreBill */
	@Temporal(TemporalType.TIMESTAMP)
	private Date finalizedAt;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(
		name="client_id",
		foreignKey=@ForeignKey(name="fk_bills_client"))
	private Client client;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(
		name="bill_id",
		foreignKey=@ForeignKey(name="fk_bill_details"))
	private List<BillDetail> details;

	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(
		name="bill_labels",
		joinColumns=@JoinColumn(
			name="bill_id",
			foreignKey=@ForeignKey(name="fk_bills"),
			unique=false),
		inverseJoinColumns=@JoinColumn(
			name="label_id",
			foreignKey=@ForeignKey(name="fk_labels"),
			unique=false))
	private List<Label> labels;

	public Bill() {
		this.status = BillStatus.DRAFT;
	}
	public Bill(String ref, BillStatus status) {
		this();
		this.ref = ref;
		this.status = status;
	}
	public Bill(String ref, BillStatus status, Client client) {
		this(ref, status);
		this.client = client;
	}
	public Bill(String ref, BillStatus status, Client client, List<BillDetail> details) {
		this(ref, status, client);
		this.details = details;
	}
	public Bill(
			String ref,
			double subTotal,
			BillStatus status,
			Date finalizedAt,
			Client client,
			List<BillDetail> details,
			List<Label> labels) {
		this(ref, status, client, details);
		this.finalizedAt = finalizedAt;
		this.labels = labels;
		setSubTotal(subTotal);
	}
	
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(double subtotal) {
		this.subTotal = subtotal;
	}
	public double getTotal() {
		this.total = subTotal - ((subTotal / 100) * 20);
		return total;
	}
	public BillStatus getStatus() {
		return status;
	}
	public void setStatus(BillStatus status) {
		this.status = status;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getFinalizedAt() {
		return finalizedAt;
	}
	public void setFinalizedAt(Date finalizedAt) {
		this.finalizedAt = finalizedAt;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<BillDetail> getDetails() {
		return details;
	}
	public void setDetails(List<BillDetail> details) {
		this.details = details;
	}
	public List<Label> getLabels() {
		return labels;
	}
	public void setLabels(List<Label> labels) {
		this.labels = labels;
	}
	public static float getTva() {
		return TVA;
	}
	public int getId() {
		return id;
	}
}
