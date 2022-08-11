package com.bakh.springsecuritydemo.repository;

import com.bakh.springsecuritydemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Bakhmai Begaev
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
