package com.ramo.blog.domain.factory;

import com.ramo.blog.domain.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleFactoryImpl implements RoleFactory {
    @Override
    public Role createRole(String name) {
        Role role = new Role();
        role.setName(name);
        return role;
    }
}
