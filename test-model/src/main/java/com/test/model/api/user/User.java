package com.test.model.api.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "test_user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_user")
	private long id;
	
	@Column(name = "name")
	@JsonProperty(value = "name")
	@NotBlank(message = "The name is required.")
	private String name;
	
	@Column(name = "email")
	@JsonProperty(value = "email")
	@NotBlank(message = "The email is required.")
	private String email;
	
	@Column(name = "telephone_number")
	@JsonProperty(value = "telephone_number")
	@NotBlank(message = "The telephone number is required.")
	private String telephoneNumber;
	
	@Column(name = "gender")
	@JsonProperty(value = "gender")
	@NotBlank(message = "The gender is required.")
	private String gender;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "[User: " + name + ", email: " + email + ", telephone number: " + telephoneNumber + ", gender:" + gender + "]";
	}

}
