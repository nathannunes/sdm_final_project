package com.CU.CurriculumPathTracker.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CU.CurriculumPathTracker.entity.User;

import io.jsonwebtoken.ExpiredJwtException;

@RestController
@RequestMapping("/soc/auth")
public class AuthenticationController {
	private final AuthenticateService service;
	@Autowired
	public AuthenticationController(AuthenticateService service) {
		this.service = service;
	}
	public AuthenticationController() {
		this.service = new AuthenticateService();}
	
	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> register(
			@RequestBody RegisterRequest request
	){
		return ResponseEntity.ok(service.register(request));
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> authenticate(
			@RequestBody AuthenticationRequest request
	){
		AuthenticationResponse response = service.authenticate(request);
		return ResponseEntity.ok()
				.header(HttpHeaders.AUTHORIZATION,response.getToken())
				.body(response.getUser());
	}
	
	@GetMapping("/validate")
	public ResponseEntity<?> validate(@RequestParam String token, @AuthenticationPrincipal User user){
		try {
			Boolean isTokenValid = service.isTokenValid(token,user);
			return ResponseEntity.ok(isTokenValid);
		}
		catch(ExpiredJwtException ex) {
			return ResponseEntity.ok(false);
		}
	}
}
