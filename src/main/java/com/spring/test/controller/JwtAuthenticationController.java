package com.spring.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.test.config.JwtTokenUtil;
import com.spring.test.dto.LoginDTO;
import com.spring.test.entity.JwtRequest;
import com.spring.test.entity.JwtResponse;
import com.spring.test.entity.UserData;
import com.spring.test.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class JwtAuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private UserService userDetailsService;
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());
		UserData user = userDetailsService.getByEmail(authenticationRequest.getEmail());
//		final UserDetails userDetails = userDetailsService
//				.loadUserByUsername(authenticationRequest.getEmail());
		
		final UserDetails userDetails = userDetailsService
				.loadUserByEmailAndVerified(authenticationRequest.getEmail());
		if(userDetails != null) {
			final String token = jwtTokenUtil.generateToken(userDetails);
			LoginDTO credentials = new LoginDTO(user.getEmail(), user.getPassword());
			final UserData data = userDetailsService.login(credentials);
			return ResponseEntity.ok(new JwtResponse(token, data));
		}else {
			return null;
		}
		
	}
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}

}
