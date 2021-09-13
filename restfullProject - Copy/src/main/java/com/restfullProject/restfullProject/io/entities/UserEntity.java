package com.restfullProject.restfullProject.io.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name = "users")
public class UserEntity implements Serializable {

	private static final long serialVersionUID = 7710419556138306081L;
	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String userId;
	
	@Column(nullable = false, length = 50)
	private String firstName;
	
	@Column(nullable = false, length = 50)
	private String lastName;
	
	@Column(nullable = false, length = 100)
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String encryptedPassword;
	
	private String emailVerficationToken;
	
	@Column(nullable = false)
	private Boolean emailVerficationStatus=false;
	
	@ManyToMany(cascade = {CascadeType.ALL}, fetch=FetchType.EAGER)
	@JoinTable(name = "users_roles" ,
			joinColumns =@JoinColumn(name="user_id" , referencedColumnName = "id") ,
	        inverseJoinColumns =@JoinColumn(name="role_id" , referencedColumnName = "id")	)
   private Collection<RoleEntity> role ;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public String getEmailVerficationToken() {
		return emailVerficationToken;
	}

	public void setEmailVerficationToken(String emailVerficationToken) {
		this.emailVerficationToken = emailVerficationToken;
	}

	public Boolean isEmailVerficationStatus() {
		return emailVerficationStatus;
	}

	public void setEmailVerficationStatus(Boolean emailVerficationStatus) {
		this.emailVerficationStatus = emailVerficationStatus;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEmailVerficationStatus() {
		return emailVerficationStatus;
	}

	public Collection<RoleEntity> getRole() {
		return role;
	}

	public void setRole(Collection<RoleEntity> role) {
		this.role = role;
	}
	
	
	
	
	
	
}
