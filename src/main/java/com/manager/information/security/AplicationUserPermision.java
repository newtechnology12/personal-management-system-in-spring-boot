package com.manager.information.security;

public enum AplicationUserPermision {
    USER_READ("user:read"),
    USER_WRITE("user:write"),
    USER_DELETE("user:delete"),
    ADMIN_READ("activity:read"),
    ADMIN_WRITE("activity: write"),
    ADMIN_DELETE("activity:delete");

    private final  String Permision;

    AplicationUserPermision(String permision) {
        Permision = permision;
    }

    public String getPermision() {
        return Permision;
    }
}
