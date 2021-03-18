package com.spring.test.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String roleName;
	
	@OneToMany(mappedBy = "roleId")
	private List<UserData> users;
	
	public Role() {
	}
	
	public Role(String roleName) {
		this.roleName = roleName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

//	public List<UserData> getUsers() {
//		return users;
//	}
//
//	public void setUsers(List<UserData> users) {
//		this.users = users;
//	}
	
}
