package fr.dwaps.model.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import fr.dwaps.model.BillDetailType;

@Entity
@Table(name="bill_detail")
public class BillDetail implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false, columnDefinition="VARCHAR(90) DEFAULT 'SERVICE'")
	private BillDetailType type = BillDetailType.SERVICE;
	@Column(columnDefinition="TEXT", nullable=false)
	private String description;
	@Column(columnDefinition="DECIMAL(5,2)", nullable=false)
	private double unitPrice;
	@Column(length=2,nullable=false)
	private int quantity;
	@Transient
	private double subTotal;

}
