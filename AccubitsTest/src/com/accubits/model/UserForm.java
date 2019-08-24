package com.accubits.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="user")
//@AttributeOverride(name = "id", column =@Column(name="userId"))
public class UserForm {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private  int id;
	
	@NotEmpty(message ="Please Enter Name" )
	@NotNull
	@Column(name="name")
	private String name;

	@Email
	@NotBlank(message ="Please Enter Valid E-Mail" )
	@Column(name="email")
	private String email;
	

	@NotEmpty(message ="Please Enter Password" )
	@NotNull
	@Column(name="password")
	private String password;
	
	@OneToMany(mappedBy="user")
	private List<BlogForm> blogForm;
	
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<BlogForm> getBlogForm() {
		return blogForm;
	}

	public void setBlogForm(List<BlogForm> blogForm) {
		this.blogForm = blogForm;
	}

	
}
