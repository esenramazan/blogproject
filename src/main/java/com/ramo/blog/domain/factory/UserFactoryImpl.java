package com.ramo.blog.domain.factory;

import com.ramo.blog.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserFactoryImpl implements UserFactory {
    @Override
    public User createUser(String username, String email, String password) {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        return user;
    }
}
