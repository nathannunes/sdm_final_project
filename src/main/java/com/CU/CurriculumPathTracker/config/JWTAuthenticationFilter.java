package com.CU.CurriculumPathTracker.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter{

	private final JWTService jWTService;
	private final UserDetailsService userDetailsService;
	@Autowired
	public JWTAuthenticationFilter(JWTService jWTService, UserDetailsService userDetailsService) {
		this.jWTService = jWTService;
		this.userDetailsService = userDetailsService;
	}
	public JWTAuthenticationFilter() {
		this.jWTService = new JWTService();
		this.userDetailsService = null;}
	@Override
	protected void doFilterInternal(@NonNull HttpServletRequest request,
			@NonNull HttpServletResponse response,
			@NonNull FilterChain filterChain)
			throws ServletException, IOException {
				final String authHeader = request.getHeader("Authorization");
				final String jwt;
				final String userName;
				if(authHeader == null || !authHeader.startsWith("Bearer ")) {
					filterChain.doFilter(request, response);
					return;
				}
				jwt = authHeader.substring(7);//auth header starts with Bearer, hence extracting everything after it
				userName = jWTService.extractUserName(jwt);
				if(userName != null && SecurityContextHolder.getContext().getAuthentication() == null ) {
					UserDetails userDetails = this.userDetailsService.loadUserByUsername(userName);
					if(jWTService.isTokenValid(jwt, userDetails)) {
						UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
						authToken.setDetails(
									new WebAuthenticationDetailsSource().buildDetails(request)
								);
						SecurityContextHolder.getContext().setAuthentication(authToken);
					}
				}
				filterChain.doFilter(request, response);
	}

}
