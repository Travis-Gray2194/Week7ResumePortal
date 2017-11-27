package me.travisgray.Entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
public class Candidate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String univName;
	private String email;
	private String linkedInUrl;
	private String username;
	private String password;


	@ManyToMany(mappedBy = "candidates", fetch = FetchType.EAGER)
	private Collection<CandidateResume> candidateResumes;


	private String applicationStatus;


	public Candidate(){

	}

	public Candidate(String name, String univName, String email, String linkedInUrl, String username, String password,Set<CandidateResume> usedresumes, String applicationStatus) {
		this.name = name;
		this.univName = univName;
		this.email = email;
		this.linkedInUrl = linkedInUrl;
		this.username = username;
		this.password = password;
		this.applicationStatus = applicationStatus;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public String getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	public String getUnivName() {
		return univName;
	}

	public void setUnivName(String univName) {
		this.univName = univName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLinkedInUrl() {
		return linkedInUrl;
	}

	public void setLinkedInUrl(String linkedInUrl) {
		this.linkedInUrl = linkedInUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}