package com.CU.CurriculumPathTracker.auth;

public class AuthenticationRequest {
	private String username;
	private String password;
	public String getusername() {
		return username;
	}
	public void setusername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public AuthenticationRequest(String username, String password) {
		
		this.username = username;
		this.password = password;
	}
	public AuthenticationRequest() {}
}
