package com.mystore.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserRequest {
    private String username;
    private String password;
    private String email;
    private String name;
}
