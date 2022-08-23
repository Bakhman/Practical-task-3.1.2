package com.bakh.springsecurity312;

import com.bakh.springsecurity312.models.Role;
import com.bakh.springsecurity312.models.User;
import com.bakh.springsecurity312.repositories.RoleRepository;
import com.bakh.springsecurity312.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SpringSecurity312App implements CommandLineRunner {

	final UserRepository userRepository;
	final RoleRepository roleRepository;

	public SpringSecurity312App(UserRepository userRepository, RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurity312App.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Set<Role> roles = new HashSet<>();
		Role role = new Role(1L,"ROLE_ADMIN");
		Role role2 = new Role(2L, "ROLE_USER");

		roles.add(role);
		roles.add(role2);
		User user = new User("bakhman", "$2a$12$G9UlD404vh7Jxx.SFgvD0OtiCU6k06rYOODt2CX3WCllA6DcIA20y", "bakhmai","admin", roles);
		if(userRepository.findAll().isEmpty()) {
			roleRepository.save(role);
			roleRepository.save(role2);
			userRepository.save(user);
		}
	}
}
