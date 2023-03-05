package com.CU.CurriculumPathTracker.entity;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Authority implements GrantedAuthority{

	public Authority() {}
	public Authority(String authority) {
		this.authority = authority;
	}
	private static final long serialVersionUID = 2147692281894737207L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String authority;
	@ManyToOne(optional=false)
	@JsonIgnore
	public User user;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return authority;
	}

}
