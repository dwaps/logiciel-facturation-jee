package fr.dwaps.model.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

@Entity
@Table(name="client")
public class Client extends AbstractPersonDetail {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(
		name="client_labels",
		joinColumns=@JoinColumn(
			name="client_id",
			foreignKey=@ForeignKey(name="fk_clients"),
			unique=false),
		inverseJoinColumns=@JoinColumn(
			name="label_id",
			foreignKey=@ForeignKey(name="fk_labels"),
			unique=false))
	private List<Label> labels;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(
		name="organization_id",
		referencedColumnName="id",
		foreignKey=@ForeignKey(name="fk_clients_organization"))
	private Organization organization;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
		name="client_activities",
		joinColumns=@JoinColumn(name="client_id"),
		inverseJoinColumns=@JoinColumn(name="activity_id"),
		foreignKey=@ForeignKey(name="fk_client_activities"))
	private List<Activity> activities;
	
	@OneToMany(mappedBy="client")
	private List<Bill> bills;

	public Client() {}
	public Client(Organization organization) {
		this.organization = organization;
	}
	public Client(List<Label> labels, Organization organization) {
		this(organization);
		this.labels = labels;
	}
	
	public List<Bill> getBills() {
		return bills;
	}
	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Label> getLabels() {
		return labels;
	}
	public void setLabels(List<Label> labels) {
		this.labels = labels;
	}
	public Organization getOrganization() {
		return organization;
	}
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	public List<Activity> getActivities() {
		return activities;
	}
	public void setActivities(List<Activity> historicals) {
		this.activities = historicals;
	}
	public int getId() {
		return id;
	}
	public String getRef() {
		String ref = "CL";
		
		if (this.id < 10) ref += "000" + this.id;
		else if (this.id < 100) ref += "00" + this.id;
		else if (this.id < 1000) ref += "0" + this.id;
		
		return ref;
	}
}
