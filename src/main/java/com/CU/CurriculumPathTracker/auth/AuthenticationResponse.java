package com.CU.CurriculumPathTracker.auth;

import com.CU.CurriculumPathTracker.domain.User;

public class AuthenticationResponse {

	private String token;
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public AuthenticationResponse(String token,User user) {
		this.token = token;
		this.user = user;
	}
	public AuthenticationResponse() {}
}
