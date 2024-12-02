package com.isslem.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.isslem.users.entities.Role;
import com.isslem.users.entities.User;
import com.isslem.users.service.UserService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class UsersMicroserviceApplication {
	
	
	@Autowired
	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(UsersMicroserviceApplication.class, args);
	}
	
	/*
	@PostConstruct
	void init_users() {
		userService.addRole(new Role(null,"ADMIN"));
		userService.addRole(new Role(null,"USER"));
		
		userService.saveUser(new User(null,"admin","123",true,null));
		userService.saveUser(new User(null,"isslem","123",true,null));
		userService.saveUser(new User(null,"eya","123",true,null));
		
		userService.addRoleToUser("admin", "ADMIN");
		userService.addRoleToUser("admin", "USER");
		userService.addRoleToUser("isslem", "USER");
		userService.addRoleToUser("eya", "USER");

	}
	*/
	 
	 
}
