package com.cubic.app.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Technology implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2370842131482390809L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	
	/*@OneToMany(mappedBy = "technology", cascade = CascadeType.ALL)
	private List<Candidate> candidates;*/
	
	/*public List<Candidate> getCandidates() {
		return candidates;
	}


	public void setCandidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}*/


	public Technology() {}

	
	public Technology(String name) {
		this.name = name;
		//this.candidates = null;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
