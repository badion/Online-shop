package com.onlineshop.badion.model;

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

	private Integer idRole;
	private Boolean locked;
	private String firstName;
	private String lastName;
	private String email;
	private String login;
	private String password;
	private Role role;
	private Boolean emailConfirmed;
	private String phone;
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
