package com.bakh.springsecurity312.repository;

import com.bakh.springsecurity312.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author Bakhmai Begaev
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
    @EntityGraph(value = User.ROLE)
    @Query("select u from User u where u.email = :email")
    User findByEmail(String email);

    User findByName(String name);

}
