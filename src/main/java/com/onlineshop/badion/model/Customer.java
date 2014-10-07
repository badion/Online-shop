package com.onlineshop.badion.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.sun.istack.internal.NotNull;

@Table(name="Ñustomer", uniqueConstraints = {
		@UniqueConstraint(columnNames = "id"),
		@UniqueConstraint(columnNames = "email"),
		@UniqueConstraint(columnNames = "login") 
})
public class Customer {
	
	public Customer() {
		super();
	}
	
	public Customer(Integer id, Integer idRole, Boolean locked,
			String firstName, String lastName, String email, String login,
			String password, Role role, Boolean emailConfirmed, String phone) {
		super();
		this.id = id;
		this.idRole = idRole;
		this.locked = locked;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.login = login;
		this.password = password;
		this.role = role;
		this.emailConfirmed = emailConfirmed;
		this.phone = phone;
	}

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	public Integer getId() {
		return id;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPhone() {
		return phone;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdRole() {
		return idRole;
	}

	public void setIdRole(Integer idRole) {
		this.idRole = idRole;
	}

	public Boolean getLocked() {
		return locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEmailConfirmed() {
		return emailConfirmed;
	}

	public void setEmailConfirmed(Boolean emailConfirmed) {
		this.emailConfirmed = emailConfirmed;
	}

	@Column(name = "id_role", unique = false, nullable = false, length = 100)
	private Integer idRole;
	@Column(name = "locked", unique = false, nullable = false)
	private Boolean locked;
	@Column(name = "fname", unique = false, nullable = false, length = 100)
	private String firstName;
	@Column(name = "lname", unique = false, nullable = false, length = 100)
	private String lastName;
	@Column(name = "email", unique = true, nullable = false, length = 100)
	private String email;
	@Column(name = "login", unique = true, nullable = false, length = 100)
	private String login;
	@Column(name = "password", unique = false, nullable = false, length = 100)
	private String password;
	private Role role;
	@Column(name = "email_confirm", unique = false, nullable = false)
	private Boolean emailConfirmed;
	@Column(name = "phone", unique = false, nullable = false, length = 100)
	private String phone;


	public void setRole(Role role) {
		this.role = role;
		if (role != null){
			this.idRole = role.getId();
		}
		else{
			this.idRole = null;
		}
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", idRole=" + idRole + ", locked="
				+ locked + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email
				+ ", login=" + login + ", password=" + password + ", role="
				+ role + ", emailConfirmed=" + emailConfirmed + "]";
	}
}
