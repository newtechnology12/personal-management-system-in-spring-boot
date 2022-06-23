package com.manager.information.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


import java.util.Set;
import java.util.stream.Collectors;


import static com.manager.information.security.AplicationUserPermision.*;

public enum AplicationUserRole {
    USER(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(USER_READ,USER_WRITE,USER_DELETE,ADMIN_READ,ADMIN_WRITE,ADMIN_DELETE));

    private final Set<AplicationUserPermision> permissions;

    AplicationUserRole(Set<AplicationUserPermision> permissions) {
        this.permissions = permissions;
    }

    public Set<AplicationUserPermision> getPermissions() {
        return permissions;
    }
    public Set<SimpleGrantedAuthority>getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermision()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
return permissions;
    }
}
