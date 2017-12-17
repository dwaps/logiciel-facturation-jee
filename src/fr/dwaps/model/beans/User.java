package fr.dwaps.model.beans;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User extends AbstractPersonDetail {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(length=20, nullable=false, unique=true)
	private String pseudo;
	@Column(length=40, nullable=false, unique=true)
	private String password;
	
	@Embedded
	private UserSetting preference;
	
	public User() {}
	public User(
		String firstname,
		String lastname,
		String pseudo,
		String email,
		String phoneNumber,
		String password) {
		super(firstname, lastname, email, phoneNumber);
		this.pseudo = pseudo;
		this.password = password;
	}
	public User(
		String pseudo,
		String firstname,
		String lastname,
		String email,
		String phoneNumber,
		String password,
		Address address,
		UserSetting preference) {
		super(firstname, lastname, email, phoneNumber, address);
		this.pseudo = pseudo;
		this.password = password;
		this.preference = preference;
	}

	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserSetting getPreferences() {
		return preference;
	}
	public void setPreferences(UserSetting preferences) {
		this.preference = preferences;
	}
	public int getId() {
		return id;
	}
}
