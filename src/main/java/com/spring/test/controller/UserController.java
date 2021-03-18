package com.spring.test.controller;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.test.dto.ChangePasswordDTO;
import com.spring.test.dto.EmailDTO;
import com.spring.test.dto.LoginDTO;
import com.spring.test.dto.MailDTO;
import com.spring.test.entity.Mail;
import com.spring.test.entity.UserData;
import com.spring.test.service.MailServiceImpl;
import com.spring.test.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
@RestController
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;

	@Autowired
	MailServiceImpl mailService;

	private int randomNumber;

	@PostMapping("/user")
	public UserData save(@RequestBody UserData user) {
		UserData userData = null;
		try {
			userData = userService.getByEmail(user.getEmail());
			if(userData != null) {
				return null;
			}else {
				userData = userService.save(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userData;
	}

	@PutMapping("/user")
	public UserData updateUser(@RequestBody UserData user) {
		UserData userModel = userService.findById(user.getId());
		if (userModel != null) {
			return userService.save(user);
		} else {
			return null;
		}
	}

	@DeleteMapping("/user/{Id}")
	public UserData deleteUserById(@PathVariable("Id") int id) {
		return userService.deleteUserById(id);
	}

	@PutMapping("/sendemail")
	public UserData getByEmail(@RequestBody EmailDTO email) {
		UserData user = userService.getByEmail(email.getMail());
		if(user != null) {
			if (email.getCode() == randomNumber) {
				user = userService.resetPassword(email);
			} else {
				user = null;
			}
		}
		
		return user;
	}

	@GetMapping("/user")
	public List<UserData> findAllUsers() {
		return userService.findAllUsers();
	}
	
	@GetMapping("/driver")
	public List<UserData> findAllDrivers() {
		return userService.findAllDrivers();
	}
	
	@GetMapping("/user/{id}")
	public UserData getUserById(@PathVariable("id")int id) {
		return userService.findById(id);
	}

	@PostMapping("/get")
	public UserData getUser(@RequestBody LoginDTO credentials) {
		credentials.setPassword(bCryptPasswordEncoder.encode(credentials.getPassword()));
		return userService.login(credentials);
	}

	@PostMapping(value = "/sendemail")
	public int sendEmail(@RequestBody MailDTO email) throws AddressException, MessagingException, IOException {
		Random random = new Random();
		randomNumber = random.nextInt(9000) + 1000;
		Mail mail = new Mail();
		mail.setMailFrom("mahmoudhamad838@gmail.com");
		mail.setMailTo(email.getMail());
		mail.setMailSubject("Password Reset");
		mail.setMailContent("Your Code is:- " + randomNumber);
		mailService.sendEmail(mail);
		return randomNumber;
	}
	
	@PostMapping("/change")
	public UserData checkPassword(@RequestBody ChangePasswordDTO passwordDTO) {
		String encodedPassword = userService.getOldPassword(passwordDTO);
		String newPassword;
		UserData user = null;
		boolean oldExists;
		oldExists = bCryptPasswordEncoder.matches(passwordDTO.getOldPassword(), encodedPassword);
		if(oldExists) {
			newPassword = bCryptPasswordEncoder.encode(passwordDTO.getNewPassword());
			user = userService.getByEmail(passwordDTO.getEmail());
			user.setPassword(newPassword);
			user = userService.save(user);
		}
		return user;
	}
	
	@GetMapping("/user/count")
	public long getUserCount() {
		return userService.countUserByEmail();
	}

}
