package com.dnd_project.dnd.model;

public enum Permission {

    USERS_STANDARD("users:standard"),
    USERS_SPECIAL("users:special");

    private final String permission;

    Permission(String permission)
    {
        this.permission = permission;
    }

    public String getPermission()
    {
        return permission;
    }
}
