package com.ramo.blog.domain.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Login {
    private String username;
    private String password;
}
