package com.spring.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.test.entity.UserData;

@Repository
public interface UserRepository extends JpaRepository<UserData, Integer> {

	@Query("select u from UserData u Where u.email=?1 and u.password=?2")
	public UserData findByCredentials(String email, String password);
	
	public UserData findByEmail(String email);
	
	@Query("select u from UserData u where u.email=?1 And u.verified=1")
	public UserData findByEmailAndVerified(String email);
	
	public List<UserData> findAll();
	
	@Query("select u from UserData u where u.roleId = 4")
	public List<UserData> findAllDrivers();
	
	@Query("select u.password from UserData u where u.email=?1")
	public String getPasswordByEmail(String email);
	
	public long countByEmail(String email);
}
