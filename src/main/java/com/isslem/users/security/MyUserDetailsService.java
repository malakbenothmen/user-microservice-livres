package com.isslem.users.security;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.isslem.users.entities.User;
import com.isslem.users.service.UserService;


@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	UserService userService;
	
		/* chercher un utilisateur par son nom d'utilisateur */
		@Override
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			User user = userService.findUserByUsername(username);
			
		if (user==null) 
		    throw new UsernameNotFoundException("Utilisateur introuvable !");
			
			/* Récupération des rôles */
			List<GrantedAuthority> auths = new ArrayList<>();
			
			 user.getRoles().forEach(role -> {
				 GrantedAuthority auhority = new SimpleGrantedAuthority(role.getRole());
				 auths.add(auhority);
			 });
			
			 /* Retourne les détails */
			return new org.springframework.security.core.
					//userdetails.User(user.getUsername(),user.getPassword(),auths);
					userdetails.User(user.getUsername(),user.getPassword(),user.getEnabled(),true,true,true,auths);
			
		  }
		
}