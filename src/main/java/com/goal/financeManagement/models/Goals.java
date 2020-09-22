package com.goal.financeManagement.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity
public class Goals {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name="goal_name")
	private String name;
	
	private String details;
	
	@Column(name="goal_amount")
	private Long amount;
	
	private Long microSave;
	
	private Long moreMicroSave;
	
	private Long remainAmount;

	public Goals() {
		
	}

	public Goals(Long id, String name, String details, Long amount, Long microSave,Long moreMicroSave, Long remainAmount) {
		super();
		this.id = id;
		this.name = name;
		this.details = details;
		this.amount = amount;
	    this.microSave=microSave;
	    this.moreMicroSave=moreMicroSave;
	    this.remainAmount=remainAmount;
	}

	public Long getmoreMicroSave() {
		return moreMicroSave;
	}

	public void setmoreMicroSave(Long moreMicroSave) {
		this.moreMicroSave = moreMicroSave;
	}

	public Long getMicroSave() {
		return microSave;
	}

	public void setMicroSave(Long microSave) {
		this.microSave = microSave;
	}

	public Long getRemainAmount() {
		return remainAmount;
	}

	public void setRemainAmount(Long remainAmount) {
		this.remainAmount = remainAmount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

}
