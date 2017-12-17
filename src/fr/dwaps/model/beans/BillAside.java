package fr.dwaps.model.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BillAside implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(columnDefinition="TEXT", name="bill_end_text")
	private String endText;
	@Column(columnDefinition="TEXT", name="bill_footer")
	private String footer;

}
