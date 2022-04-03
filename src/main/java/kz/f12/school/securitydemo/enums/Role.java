package kz.f12.school.securitydemo.enums;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Role {
    ADMIN(
            Stream.of(Permission.READ, Permission.WRITE)
                    .collect(Collectors.toSet())
    ),
    USER(
            Stream.of(Permission.READ)
                    .collect(Collectors.toSet())
    );

    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities() {
        return permissions.stream()
                .map(permission -> new SimpleGrantedAuthority(permission.name()))
                .collect(Collectors.toSet());
    }
}
