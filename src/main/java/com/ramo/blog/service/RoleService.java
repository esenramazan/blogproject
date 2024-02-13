package com.ramo.blog.service;

import com.ramo.blog.domain.Role;

import java.util.List;

public interface RoleService {
    Role getRoleById(Long id);
    Role getRoleByName(String name);
    Role createRole(Role role);
    Role updateRole(Long id, Role updatedRole);
    boolean deleteRole(Long id);

    List<Role> getAllRoles();
}
