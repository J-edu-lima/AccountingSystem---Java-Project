package com.j_edulima.accouting.config.security.token;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.j_edulima.accouting.repository.UserRegisterRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtSecurityFilter extends OncePerRequestFilter {

	@Autowired
	TokenInterface tokenService;
	@Autowired
	UserRegisterRepository repository;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String token = tokenService.recoverToken(request);
		if (token != null) {
			String username = tokenService.validateToken(token);
			UserDetails user = repository.findByUsername(username);
			var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}

		filterChain.doFilter(request, response);
	}
}
