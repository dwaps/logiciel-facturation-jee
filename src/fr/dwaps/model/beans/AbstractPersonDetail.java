package fr.dwaps.model.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractPersonDetail implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(length=90, nullable=false)
	private String firstname;
	@Column(length=90, nullable=false)
	private String lastname;
	@Column(length=90, nullable=false, unique=true)
	private String email;
	@Column(length=10, nullable=false)
	private String phoneNumber;
	
	@Embedded
	private Address address;

	public AbstractPersonDetail() {}
	public AbstractPersonDetail(String firstname, String lastname, String email, String phoneNumber) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	public AbstractPersonDetail(String firstname, String lastname, String email, String phoneNumber, Address address) {
		this(firstname, lastname, email, phoneNumber);
		this.address = address;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

}
