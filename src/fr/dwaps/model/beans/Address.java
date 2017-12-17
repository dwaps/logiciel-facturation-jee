package fr.dwaps.model.beans;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	@Column(name="address_street", length=120, nullable=false)
	private String street;
	@Column(name="address_zip", length=5, nullable=false)
	private String zip;
	@Column(name="address_city", length=70, nullable=false)
	private String city;
	@Column(name="address_country", length=70, nullable=false)
	private String country = "France";
	
	public Address() {}
	public Address(String street, String zip, String city) {
		this.street = street;
		this.zip = zip;
		this.city = city;
	}
	public Address(String street, String zip, String city, String country) {
		this(street, zip, city);
		this.country = country;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
