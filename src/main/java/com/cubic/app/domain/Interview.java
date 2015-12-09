package com.cubic.app.domain;

import java.io.Serializable;
//import java.sql.Date;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Interview implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2321264184668986082L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@ManyToOne(cascade = CascadeType.MERGE)
	private Candidate candidate;

	@OneToOne(cascade = CascadeType.MERGE)
	private Client client;
	@OneToOne(cascade = CascadeType.MERGE)
	private Vendor vendor;
	@OneToOne(cascade = CascadeType.MERGE)
	private User vc;
	@OneToOne(cascade = CascadeType.MERGE)
	private User marketing;
	// private Date date;

	@OneToOne(cascade = CascadeType.MERGE)
	private Technology technology;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "interview")
	// @JoinTable(name="INTERVIEW_AND_ROUNDS", joinColumns =
	// {@JoinColumn(name="interview_id",referencedColumnName="id")},
	// inverseJoinColumns={@JoinColumn(name="interview_round_id",
	// referencedColumnName="id")})
	@JsonIgnore
	private List<InterviewRound> interviewRound;

	public Interview() {
	}

	public Interview(Candidate candidate, Client client, Vendor vendor,
			User vc, User marketing, Technology technology,
			List<InterviewRound> interviewRound) {
		this.candidate = candidate;
		this.client = client;
		this.vendor = vendor;
		this.vc = vc;
		this.marketing = marketing;
		this.technology = technology;
		this.interviewRound = interviewRound;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public User getVc() {
		return vc;
	}

	public void setVc(User vc) {
		this.vc = vc;
	}

	public User getMarketing() {
		return marketing;
	}

	public void setMarketing(User marketing) {
		this.marketing = marketing;
	}

	public Technology getTechnology() {
		return technology;
	}

	public void setTechnology(Technology technology) {
		this.technology = technology;
	}

	public List<InterviewRound> getInterviewRound() {
		return interviewRound;
	}

	public void setInterviewRound(List<InterviewRound> interviewRound) {
		this.interviewRound = interviewRound;
	}

}
