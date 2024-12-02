package com.isslem.users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.isslem.users.entities.Role;


public interface RoleRepository extends JpaRepository<Role, Long> {
	
	Role findByRole(String role);


}
