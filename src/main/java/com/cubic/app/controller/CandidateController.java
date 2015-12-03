package com.cubic.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cubic.app.domain.Candidate;
import com.cubic.app.service.CandidateService;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

	@Autowired
	private CandidateService candidateService;
	
	@RequestMapping("/list")
	public List<Candidate> getListOfCandidates() {
		return candidateService.getCandidateList();
	}
}
