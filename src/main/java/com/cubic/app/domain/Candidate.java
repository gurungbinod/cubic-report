package com.cubic.app.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Candidate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1018012965701760497L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String firstName;
	private String lastName;
	
	@Column(unique=true)
	private String SSN;
	
	private String phone_m;
	private String phone_o;
	private String email_m;
	private String email_o;
	private String skype_id_m;
	private String skype_id_o;
	
	@Enumerated(EnumType.STRING)
	private CandidateStatus status;
	
	@OneToMany(cascade=CascadeType.MERGE, mappedBy = "candidate")
	private List<Interview> interviews;
	
	@OneToOne(cascade=CascadeType.MERGE, fetch = FetchType.EAGER)
	private Technology technology;
	
	public Candidate() {}

	public Candidate(String firstName, String lastName, String sSN,
			String phone_m, String phone_o, String email_m, String email_o,
			String skype_id_m, String skype_id_o, CandidateStatus status,
			List<Interview> interviews, Technology technology) {
		this.firstName = firstName;
		this.lastName = lastName;
		SSN = sSN;
		this.phone_m = phone_m;
		this.phone_o = phone_o;
		this.email_m = email_m;
		this.email_o = email_o;
		this.skype_id_m = skype_id_m;
		this.skype_id_o = skype_id_o;
		this.status = status;
		this.interviews = interviews;
		this.technology = technology;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSSN() {
		return SSN;
	}

	public void setSSN(String sSN) {
		SSN = sSN;
	}

	public String getPhone_m() {
		return phone_m;
	}

	public void setPhone_m(String phone_m) {
		this.phone_m = phone_m;
	}

	public String getPhone_o() {
		return phone_o;
	}

	public void setPhone_o(String phone_o) {
		this.phone_o = phone_o;
	}

	public String getEmail_m() {
		return email_m;
	}

	public void setEmail_m(String email_m) {
		this.email_m = email_m;
	}

	public String getEmail_o() {
		return email_o;
	}

	public void setEmail_o(String email_o) {
		this.email_o = email_o;
	}

	public String getSkype_id_m() {
		return skype_id_m;
	}

	public void setSkype_id_m(String skype_id_m) {
		this.skype_id_m = skype_id_m;
	}

	public String getSkype_id_o() {
		return skype_id_o;
	}

	public void setSkype_id_o(String skype_id_o) {
		this.skype_id_o = skype_id_o;
	}

	public CandidateStatus getStatus() {
		return status;
	}

	public void setStatus(CandidateStatus status) {
		this.status = status;
	}
	
	
	
}
