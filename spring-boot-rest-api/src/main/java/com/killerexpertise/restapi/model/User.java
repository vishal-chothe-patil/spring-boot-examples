package com.killerexpertise.restapi.model;

import lombok.Data;

@Data
public class User {
	private Integer id;
	private String name;
	private String email;
	private String mobile;
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", mobile=" + mobile + "]";
	}
	

}