package com.cubic.app;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cubic.app.domain.Candidate;
import com.cubic.app.domain.CandidateStatus;
import com.cubic.app.domain.Client;
import com.cubic.app.domain.Interview;
import com.cubic.app.domain.InterviewRound;
import com.cubic.app.domain.InterviewStatus;
import com.cubic.app.domain.InterviewType;
import com.cubic.app.domain.Role;
import com.cubic.app.domain.Round;
import com.cubic.app.domain.Technology;
import com.cubic.app.domain.User;
import com.cubic.app.domain.Vendor;
import com.cubic.app.service.CandidateService;
import com.cubic.app.service.ClientService;
import com.cubic.app.service.InterviewRoundService;
import com.cubic.app.service.InterviewService;
import com.cubic.app.service.InterviewTypeService;
import com.cubic.app.service.RoundService;
import com.cubic.app.service.TechnologyService;
import com.cubic.app.service.UserService;
import com.cubic.app.service.VendorService;

@Component
public class StartUp {
	private static final Logger logger = LoggerFactory.getLogger(CandidateService.class);
	public StartUp() {
	// TODO Auto-generated constructor stub
	}
	@Autowired
	private UserService userService;
	@Autowired
	private TechnologyService technologyService;
	@Autowired
	private VendorService vendorService;
	@Autowired
	private RoundService roundService;
	@Autowired
	private InterviewTypeService interviewTypeService;
	@Autowired
	private ClientService clientService;
	@Autowired
	private InterviewService interviewService;
	@Autowired
	private CandidateService candidateService;
	@Autowired
	private InterviewRoundService interivewRoundService;

	private static final String userName1 = "gurung.binod@gmail.com";
	private static final String userName2 = "naren.thapa@gmail.com";
	private static final String userName3 = "amrit.khadka@gmail.com";

	@PostConstruct
	public void init() {
		// insertIntoDb();
		insertUser();
		insertInterviewType();
		insertClient();
		insertRound();
		insertTechnology();
		insertVendor();
		insertInterview();
		insertCandidate();
		insertIntoDb();
	}

	private void insertUser() {
		/*BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		String pwd = bcrypt.encode("password");*/
		String pwd = "password";
		User user1 = new User("Binod Gurung", "6414514617", userName1,
				pwd, true, Role.ROLE_ADMIN);
		User user2 = new User("Anil", "6414514617", userName2, pwd,
				true, Role.ROLE_VC);
		User user3 = new User("Chandi", "6414514617", userName3, pwd,
				true, Role.ROLE_MARKETING);

		userService.save(user1);
		userService.save(user2);
		userService.save(user3);
	}
	
	private void insertTechnology() {
		Technology tech1 = new Technology("JAVA");
		Technology tech2 = new Technology(".NET");

		technologyService.save(tech1);
		technologyService.save(tech2);
	}
	
	private void insertRound() {
		Round round1 = new Round("Round 1");
		Round round2 = new Round("Round 2");
		List<Round> roundList = new ArrayList<Round>();
		roundList.add(round1);

		roundService.save(round1);
		roundService.save(round2);
	}
	
	private void insertVendor() {
		Vendor vendor1 = new Vendor("Disys", "description");
		Vendor vendor2 = new Vendor("Infosys", "description");

		vendorService.save(vendor1);
		vendorService.save(vendor2);
	}
	
	private void insertInterviewType() {
		InterviewType interviewT1 = new InterviewType("Phone");
		InterviewType interviewT2 = new InterviewType("Skype");
		InterviewType interviewT3 = new InterviewType("Webex");

		

		interviewTypeService.save(interviewT1);
		interviewTypeService.save(interviewT2);
		interviewTypeService.save(interviewT3);
	}
	
	private void insertClient() {
		Client client1 = new Client("IBM");
		Client client2 = new Client("Microsoft");
		Client client3 = new Client("Apple");

		clientService.save(client1);
		clientService.save(client2);
		clientService.save(client3);
	}
	
	private void insertInterview() {
		User user1 = userService.findById(1);
		User user2 = userService.findById(2);
		Client client1 = clientService.findById(1);
		Vendor vendor1 = vendorService.findById(1);
		Technology tech1 = technologyService.findById(1);
		Candidate candidate = null;
		List<InterviewRound> irList = null;
		
		
		Interview interview1 = new Interview(candidate, client1, vendor1, user1,
				user2, tech1, irList);
		
		interviewService.save(interview1);
	}
	
	private void insertCandidate() {
		Interview interview1 = interviewService.findOne(1);
		List<Interview> interviewList = new ArrayList<Interview>();
		interviewList.add(interview1);
		
		Technology tech1 = technologyService.findById(1);
		
		Candidate candidate1 = new Candidate("Binod", "Gurung", "1234567852",
				"123", "456", "email@email.com", "email1@email.com",
				"skype.account1", "skype.account2", CandidateStatus.MARKETING,
				interviewList, tech1);
		
		candidateService.save(candidate1);
	}
	private void insertIntoDb() {
		
		Candidate candidate1 = candidateService.findOne(1);
		
		logger.info("Candidate: "+candidate1);
		
		Interview interview1 = interviewService.findOne(1);
		Round round1 = roundService.findOne(1);
		InterviewType interviewT1 = interviewTypeService.findById(1);
		InterviewRound ir = new InterviewRound(round1, InterviewStatus.PENDING,
				interviewT1, interview1);

		List<InterviewRound> irList = new ArrayList<InterviewRound>();
		irList.add(ir);
		
		interivewRoundService.save(ir);

		interview1.setCandidate(candidate1);
		interview1.setInterviewRound(irList);

		interviewService.save(interview1);
		
	}
}
