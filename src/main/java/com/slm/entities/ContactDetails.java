package com.slm.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "contactdetails")
@Entity
public class ContactDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "Email", unique = true)
	private String email;

	@Column(name = "CountryCode")
	private int countryCode;

	@Column(name = "Mobile", unique = true)
	private String mobile;

	@Column(name = "ContactType")
	private String contact_Type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(int countryCode) {
		this.countryCode = countryCode;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getContact_Type() {
		return contact_Type;
	}

	public void setContact_Type(String contact_Type) {
		this.contact_Type = contact_Type;
	}

}
