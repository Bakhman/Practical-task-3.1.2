package com.bakh.pp312.repositories;

import com.bakh.pp312.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Bakhmai Begaev
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
