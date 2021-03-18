package com.spring.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.test.entity.Role;
import com.spring.test.service.RoleService;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
@RestController
public class RoleController {

	@Autowired
	RoleService roleService;
	
	@GetMapping("/role")
	public List<Role> getAllRoles(){
		return roleService.getAllRoles();
	}
	
}
