package com.bakh.springsecurity312;

import com.bakh.springsecurity312.model.Role;
import com.bakh.springsecurity312.model.User;
import com.bakh.springsecurity312.repository.RoleRepository;
import com.bakh.springsecurity312.repository.UserRepository;
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
		Set<Role> roles1 = new HashSet<>();
		Role role1 = new Role(1L,"ROLE_ADMIN");
		Role role2 = new Role(2L, "ROLE_USER");

		roles.add(role1);
		roles.add(role2);
		roles.add(role2)
		User admin = new User("bakhman", "$2a$12$G9UlD404vh7Jxx.SFgvD0OtiCU6k06rYOODt2CX3WCllA6DcIA20y", "Bakhmai","admin", roles);
		User user = new User("John", "$2a$12$SXxF.BgRpKyaLgWEoP8Qe.GPaaAzVT21DsdhvXAhq3u5OQV7dJjre", "Doe","user", roles1);
		if (userRepository.findAll().isEmpty()) {
			roleRepository.save(role1);
			roleRepository.save(role2);
			userRepository.save(admin);
			userRepository.save(user);
		}
	}
}
