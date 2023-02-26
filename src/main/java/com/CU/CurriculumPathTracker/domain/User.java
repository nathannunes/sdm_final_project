package com.CU.CurriculumPathTracker.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User implements UserDetails{
	public User() {}
	public User(String username, String password, Role role) {
		
		List<Authority> authorities = new ArrayList<Authority>();
		authorities.add(new Authority(role.name()));
		this.username = username;
		this.password = password;
		this.authorities = authorities;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	//@Column
	private String username;
	//@Column
	private String password;
	//@Enumerated(EnumType.STRING)
	
	@OneToMany(fetch=FetchType.EAGER,mappedBy="user")
	@JsonIgnore
	private List<Authority> authorities;
	public List<Authority> getRole() {
		return authorities;
	}
	public void setRole(List<Authority> role) {
		this.authorities = role;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Override
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		List<GrantedAuthority> roles = new ArrayList<>();
		roles.addAll(authorities);
		return roles;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
}
