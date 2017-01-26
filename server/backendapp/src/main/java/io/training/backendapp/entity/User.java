package io.training.backendapp.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({
	@NamedQuery(name = "User.findAll", query = "Select u from User u"),
	@NamedQuery(name = "User.findById", query = "Select u from User u where u.id = :id "),
	@NamedQuery(name = "User.findByEmail",query = "Select u from User u where u.email = :email")
})
public class User {
	
	@Id
	private String id;
	private String firstName;
	private String lastName;
	
	@Column(unique = true)
	private String email;
	private String password;
	
	public User(){
		id = UUID.randomUUID().toString();
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
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
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}