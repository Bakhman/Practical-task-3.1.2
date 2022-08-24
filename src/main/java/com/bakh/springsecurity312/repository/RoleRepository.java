package com.bakh.springsecurity312.repository;

import com.bakh.springsecurity312.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Bakhmai Begaev
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
