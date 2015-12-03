package com.cubic.app.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class InterviewRound implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3658763045503950886L;

	/**
	 * 
	 */
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@OneToOne
	private Round round;
	
	@Enumerated(EnumType.STRING)
	private InterviewStatus interviewStatus;
	
	@OneToOne
	private InterviewType interviewType;
	
	@ManyToOne(cascade=CascadeType.MERGE, fetch = FetchType.LAZY)
	@JsonIgnore
	private Interview interview;
	
	public InterviewRound() {}
	
	
	public InterviewRound(Round round, InterviewStatus interviewStatus,
			InterviewType interviewType, Interview interview) {
		this.round = round;
		this.interviewStatus = interviewStatus;
		this.interviewType = interviewType;
		this.interview = interview;
	}


	public InterviewStatus getInterviewStatus() {
		return interviewStatus;
	}

	public void setInterviewStatus(InterviewStatus interviewStatus) {
		this.interviewStatus = interviewStatus;
	}

	public Interview getInterview() {
		return interview;
	}

	public void setInterview(Interview interview) {
		this.interview = interview;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Round getRound() {
		return round;
	}

	public void setRound(Round round) {
		this.round = round;
	}

	public InterviewStatus getStatus() {
		return interviewStatus;
	}

	public void setStatus(InterviewStatus interviewStatus) {
		this.interviewStatus = interviewStatus;
	}

	public InterviewType getInterviewType() {
		return interviewType;
	}

	public void setInterviewType(InterviewType interviewType) {
		this.interviewType = interviewType;
	}
	
	
}
