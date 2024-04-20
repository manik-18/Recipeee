package com.manik.recipeee.config;

import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import javax.crypto.SecretKey;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtTokenValidator extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,
			@NonNull FilterChain filterChain)
			throws ServletException, IOException {
		String jwt = request.getHeader(JwtConstants.JWT_HEADER);
		if (jwt != null) {
			jwt = jwt.substring(7);
			try {
				SecretKey key = Keys.hmacShaKeyFor(JwtConstants.JWT_SECRET.getBytes());
				Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt).getBody();
				String email = String.valueOf(claims.get("email"));
				Date expirationDate = claims.getExpiration();
				if (expirationDate.before(Date.from(Instant.now()))) {
					throw new BadCredentialsException("Token has expired");
				}
				Authentication authentication = new UsernamePasswordAuthenticationToken(email, null, null);
				SecurityContextHolder.getContext().setAuthentication(authentication);
			} catch (Exception e) {
				throw new BadCredentialsException("Invalid token", e);
			}
		}
		filterChain.doFilter(request, response);
	}
}