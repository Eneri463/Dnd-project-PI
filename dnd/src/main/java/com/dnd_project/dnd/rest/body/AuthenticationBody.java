package com.dnd_project.dnd.rest.body;

import lombok.Data;

@Data
public class AuthenticationBody {
    private String login;
    private String password;
}
