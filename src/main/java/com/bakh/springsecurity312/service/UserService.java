package com.bakh.springsecurity312.service;

import com.bakh.springsecurity312.model.User;

import java.util.List;

/**
 * @author Bakhmai Begaev
 */
public interface UserService {
    User findUserById(Long id);
    List<User> findAllUsers();
    boolean deleteUserById(Long id);
    User editUser(User user);
    boolean save(User user);
}
