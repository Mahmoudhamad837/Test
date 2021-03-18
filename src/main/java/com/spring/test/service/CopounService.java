package com.spring.test.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.test.entity.Copoun;
import com.spring.test.repository.CopounRepository;

@Service
public class CopounService {

	@Autowired
	private CopounRepository copounRepository;
	
	
	public Copoun save(Copoun copoun) {
		Copoun theCopoun = copounRepository.getCopounByCopounName(copoun.getCopounName());
		if(theCopoun == null) {
			theCopoun = copounRepository.save(copoun);
		}else {
			theCopoun = null;
		}
		return theCopoun;
	}
	
	public List<Copoun> getAllCopouns(){
		return copounRepository.findAll();
	}
	
	public Copoun findById(int id) {
		Copoun theCopoun = null;
		Optional<Copoun> copoun = copounRepository.findById(id);
		if(copoun.isPresent()) {
			theCopoun = copoun.get();
		}
		
		return theCopoun;
	}
	
	public Copoun deleteById(int id) {
		Copoun copoun = findById(id);
		copounRepository.deleteById(id);
		return copoun;
	}
}
