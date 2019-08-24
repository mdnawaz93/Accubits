package com.accubits.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="blog")
public class BlogForm {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private  int id;
	
	@Column(name="title")
	private String title;
	@Column(name="description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private UserForm user;

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UserForm getUser() {
		return user;
	}

	public void setUser(UserForm user) {
		this.user = user;
	}
	
	
	
}
