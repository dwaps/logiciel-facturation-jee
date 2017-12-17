package fr.dwaps.model.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import fr.dwaps.model.Theme;

@Embeddable
public class UserSetting implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Enumerated(EnumType.STRING)
	@Column(length=20)
	private Theme theme;
	
	@Embedded
	private 	BillAside invoiceAside;

	public UserSetting() {}
	public UserSetting(Theme theme) {
		super();
		this.theme = theme;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}
}
