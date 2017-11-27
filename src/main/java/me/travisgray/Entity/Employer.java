package me.travisgray.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String email;
	private String linkedInUrl;
	private String username;
	private String password;

	


	public Employer() {

	}

	public Employer(String username) {
		this.username = username;
	}

	public Employer(String name, String email, String linkedInUrl, String username,String password) {

		this.name = name;
		this.email = email;
		this.linkedInUrl = linkedInUrl;
		this.username = username;
		this.password = password;

	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

}