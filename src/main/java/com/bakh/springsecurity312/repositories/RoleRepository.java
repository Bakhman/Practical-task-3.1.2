package com.bakh.springsecurity312.repositories;

import com.bakh.springsecurity312.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Bakhmai Begaev
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
