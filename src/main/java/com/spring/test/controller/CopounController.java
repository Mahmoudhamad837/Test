package com.spring.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.test.entity.Copoun;
import com.spring.test.service.CopounService;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
@RestController
public class CopounController {

	@Autowired
	private CopounService copounService;
	
	@GetMapping("/copouns")
	public List<Copoun> getAllCopouns() {
		return copounService.getAllCopouns();
	}
	
	@GetMapping("/copouns/{id}")
	public Copoun getCopounById(@PathVariable("id")int id) {
		return copounService.findById(id);
	}
	
	@PostMapping("/copouns")
	public Copoun saveCopoun(@RequestBody Copoun copoun) {
		return copounService.save(copoun);
	}
	
	@DeleteMapping("/copouns/{id}")
	public Copoun deleteCopoun(@PathVariable("id") int id) {
		return copounService.deleteById(id);
	}
}
