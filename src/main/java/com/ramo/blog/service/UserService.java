package com.ramo.blog.service;

import com.ramo.blog.domain.User;

import java.util.List;

public interface UserService {
    User getUserById(Long id);
    User getUserByUsername(String username);
    User createUser(User user);
    Boolean deleteUser(Long id);
    List<User> getAllUsers();
    User login(String userName, String password);
    User updateUser(Long userId, User updatedUser);
}
