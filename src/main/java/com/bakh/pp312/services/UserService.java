package com.bakh.pp312.services;

import com.bakh.pp312.models.User;

import java.util.List;

/**
 * @author Bakhmai Begaev
 */
public interface UserService {
    User findUserById(long id);
    List<User> findAllUsers();
    User saveUser(User user);
    void deleteUserById(long id);
    void editUserById(long id);
}
