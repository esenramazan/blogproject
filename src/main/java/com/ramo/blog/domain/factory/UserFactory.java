package com.ramo.blog.domain.factory;

import com.ramo.blog.domain.User;

public interface UserFactory {
    User createUser(String username, String email, String password);
}
