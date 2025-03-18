package com.j_edulima.accouting.security;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.j_edulima.accouting.model.entity.User;

@Service
public class JwtTokenService implements TokenInterface {

	private String secret = "senha";

	@Override
	public String generateToken(User user) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			String token = JWT.create().withIssuer("auth").withSubject(user.getUsername()).withClaim("id", user.getId())
					.withExpiresAt(LocalDateTime.now().plusHours(6).toInstant(ZoneOffset.of("-03:00"))).sign(algorithm);

			return token;
		} catch (JWTCreationException e) {
			throw new TokenExpiredException(secret, null);
		}
	}

	@Override
	public String validateToken(String token) throws JWTVerificationException {

		Algorithm algorithm = Algorithm.HMAC256(secret);
		return JWT.require(algorithm).withIssuer("auth").build().verify(token).getSubject();
	}

}
