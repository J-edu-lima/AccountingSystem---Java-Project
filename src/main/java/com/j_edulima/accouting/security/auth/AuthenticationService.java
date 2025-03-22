package com.j_edulima.accouting.security.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.j_edulima.accouting.dto.UserLoginRequestDTO;
import com.j_edulima.accouting.dto.UserLoginResponseDTO;
import com.j_edulima.accouting.dto.UserRegisterDTO;
import com.j_edulima.accouting.handler.DataErrorException;
import com.j_edulima.accouting.mapper.UserMapper;
import com.j_edulima.accouting.model.User;
import com.j_edulima.accouting.repository.UserRegisterRepository;
import com.j_edulima.accouting.security.token.TokenInterface;

@Service
public class AuthenticationService implements UserDetailsService {

	@Autowired
	private ApplicationContext context;
	@Autowired
	private UserRegisterRepository repository;
	@Autowired
	private TokenInterface tokenService;

	private AuthenticationManager authenticationManager;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return repository.findByEmail(email);
	}

	public ResponseEntity<Object> login(UserLoginRequestDTO login) {
		try {
			authenticationManager = context.getBean(AuthenticationManager.class);
			var usernamePassword = new UsernamePasswordAuthenticationToken(login.email(), login.password());
			var auth = this.authenticationManager.authenticate(usernamePassword);
			var token = tokenService.generateToken((User) auth.getPrincipal());

			return ResponseEntity.ok(new UserLoginResponseDTO(token));
		} catch (BadCredentialsException e) {
			throw new DataErrorException();
		}
	}

	public void register(UserRegisterDTO userDTO) {
		User user = UserMapper.toEntity(userDTO);

		repository.save(user);
	}
}
