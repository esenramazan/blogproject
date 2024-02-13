package com.ramo.blog.controller;

import com.ramo.blog.domain.User;
import com.ramo.blog.domain.request.Login;
import com.ramo.blog.service.UserService;
import com.ramo.blog.util.GenericResponse;
import com.ramo.blog.util.factory.GenericResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/users")
public class UserController extends GenericController {

    private final UserService userService;
    private final GenericResponseFactory<User> genericResponseFactory;
    private final GenericResponseFactory<List<User>> genericResponseListFactory;
    private final GenericResponseFactory<String> stringGenericResponseFactory;

    @Autowired
    public UserController(UserService userService, GenericResponseFactory<User> genericResponseFactory, GenericResponseFactory<List<User>> genericResponseListFactory, GenericResponseFactory<String> stringGenericResponseFactory) {
        this.userService = userService;
        this.genericResponseFactory = genericResponseFactory;
        this.genericResponseListFactory = genericResponseListFactory;
        this.stringGenericResponseFactory = stringGenericResponseFactory;
    }

    @GetMapping
    public GenericResponse<List<User>> getAllUsers() {
        try {
            return genericResponseListFactory.createSuccessResponse(userService.getAllUsers());
        } catch (Exception e) {
            return genericResponseListFactory.createErrorResponse(e.getMessage());
        }

    }

    @GetMapping("/{id}")
    public GenericResponse<User> getUserById(@PathVariable Long id) {
        try {
            return genericResponseFactory.createSuccessResponse(userService.getUserById(id));
        } catch (Exception e) {
            return genericResponseFactory.createErrorResponse(e.getMessage());
        }

    }

    @PostMapping("/createUser")
    public GenericResponse<User> createUser(@RequestBody User user) {
        try {
            return genericResponseFactory.createSuccessResponse(userService.createUser(user));
        } catch (Exception e) {
            return genericResponseFactory.createErrorResponse(e.getMessage());
        }

    }


    @PostMapping("/login")
    public GenericResponse<User> login(@RequestBody Login login) {

        try {
            return genericResponseFactory.createSuccessResponse(userService.login(login.getUsername(), login.getPassword()));
        } catch (Exception e) {
            return genericResponseFactory.createErrorResponse(e.getMessage());
        }

    }


    @PutMapping("/{id}")
    public GenericResponse<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        try {
            return genericResponseFactory.createSuccessResponse(userService.updateUser(id, user));
        } catch (Exception e) {
            return genericResponseFactory.createErrorResponse(e.getMessage());
        }

    }

    @DeleteMapping("/{id}")
    public GenericResponse<String> deleteUser(@PathVariable Long id) {
        try {
            boolean deleted = userService.deleteUser(id);
            if (deleted) {
                return stringGenericResponseFactory.createSuccessResponse("Success Deleting Id: " + id);
            } else {
                return stringGenericResponseFactory.createSuccessResponse("Error Deleting Id:" + id);
            }
        } catch (Exception e) {
            return stringGenericResponseFactory.createErrorResponse(e.getMessage());
        }
    }


}
