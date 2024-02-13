package com.ramo.blog.controller;

import com.ramo.blog.domain.Role;
import com.ramo.blog.service.RoleService;
import com.ramo.blog.util.GenericResponse;
import com.ramo.blog.util.factory.GenericResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/roles")
public class RoleController extends GenericController {

    private final RoleService roleService;
    private final GenericResponseFactory<Role> genericResponseFactory;
    private final GenericResponseFactory<List<Role>> genericResponseListFactory;

    private final GenericResponseFactory<String> stringGenericResponseFactory;

    @Autowired
    public RoleController(RoleService roleService, GenericResponseFactory<Role> genericResponseFactory, GenericResponseFactory<List<Role>> genericResponseListFactory, GenericResponseFactory<String> stringGenericResponseFactory) {
        this.roleService = roleService;
        this.genericResponseFactory = genericResponseFactory;
        this.genericResponseListFactory = genericResponseListFactory;
        this.stringGenericResponseFactory = stringGenericResponseFactory;
    }

    @GetMapping
    public GenericResponse<List<Role>> getAllRoles() {

        try {
            return genericResponseListFactory.createSuccessResponse(roleService.getAllRoles());
        } catch (Exception e) {
            return genericResponseListFactory.createErrorResponse(e.getMessage());
        }

    }

    @GetMapping("/{id}")
    public GenericResponse<Role> getRoleById(@PathVariable Long id) {
        try {
            return genericResponseFactory.createSuccessResponse(roleService.getRoleById(id));
        } catch (Exception e) {
            return genericResponseFactory.createErrorResponse(e.getMessage());
        }
    }

    @PostMapping
    public GenericResponse<Role> createRole(@RequestBody Role role) {
        try {
            return genericResponseFactory.createSuccessResponse(roleService.createRole(role));
        } catch (Exception e) {
            return genericResponseFactory.createErrorResponse(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public GenericResponse<Role> updateRole(@PathVariable Long id, @RequestBody Role role) {
        try {
            return genericResponseFactory.createSuccessResponse(roleService.updateRole(id, role));
        } catch (Exception e) {
            return genericResponseFactory.createErrorResponse(e.getMessage());
        }

    }

    @DeleteMapping("/{id}")
    public GenericResponse<String> deleteRole(@PathVariable Long id) {
        try {
            boolean deleted = roleService.deleteRole(id);
            if (deleted) {
                return stringGenericResponseFactory.createSuccessResponse("Deleted Id :" + id);
            } else {
                return stringGenericResponseFactory.createSuccessResponse("!!!Error Id:" + id);
            }
        } catch (Exception e) {
            return stringGenericResponseFactory.createErrorResponse(e.getMessage());
        }

    }
}
