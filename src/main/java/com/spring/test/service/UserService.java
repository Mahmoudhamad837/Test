package com.spring.test.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.test.dto.ChangePasswordDTO;
import com.spring.test.dto.EmailDTO;
import com.spring.test.dto.LoginDTO;
import com.spring.test.entity.Role;
import com.spring.test.entity.UserData;
import com.spring.test.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;

	UserData principal;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		try {
			principal = userRepository.findByEmail(email);
			return new User(email, principal.getPassword(), new ArrayList<>());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public UserDetails loadUserByEmailAndVerified(String email) {
		try {
			principal = userRepository.findByEmailAndVerified(email);
			if(principal != null) {
				return new User(email, principal.getPassword(), new ArrayList<>());
			}else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public UserData resetPassword(EmailDTO email) {
		UserData user = new UserData();
		user = userRepository.findByEmail(email.getMail());
		user.setPassword(bCryptPasswordEncoder.encode(email.getNewPassword()));
		return userRepository.save(user);
//		userRepository.resetPassword(email.getMail(), email.getNewPassword());
	}

	public UserData login(LoginDTO credentials) {
		return userRepository.findByCredentials(credentials.getEmail(), credentials.getPassword());
	}

	public UserData getByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public List<UserData> findAllUsers() {
		return userRepository.findAll();
	}
	
	public List<UserData> findAllDrivers() {
		return userRepository.findAllDrivers();
	}

	public UserData save(UserData user) {
		try {
			if(user.getId() > 0) {
				return userRepository.save(user);
			}else {
				String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
				user.setPassword(encodedPassword);
				return userRepository.save(user);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public UserData findById(int id) {
		Optional<UserData> user = userRepository.findById(id);
		UserData theUser = null;
		if (user.isPresent()) {
			theUser = user.get();
		} else {
			throw new RuntimeException("User is not found");
		}
		return theUser;
	}

	public UserData deleteUserById(int id) {
		UserData user = findById(id);
		if (user != null) {
			userRepository.deleteById(id);
			return user;
		} else {
			return null;
		}
	}
	
	public String getOldPassword(ChangePasswordDTO passwordDTO) {
		return userRepository.getPasswordByEmail(passwordDTO.getEmail());
	}
	
	public long countUserByEmail() {
		return userRepository.count();
	}

}
