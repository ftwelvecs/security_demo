package kz.f12.school.securitydemo.enums;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static kz.f12.school.securitydemo.enums.Permission.*;

public enum Role {
    ADMIN(
            Stream.of(REPORT_READ, STORE_READ, STORE_WRITE)
                    .collect(Collectors.toSet())
    ),
    USER(
            Stream.of(STORE_READ)
                    .collect(Collectors.toSet())
    ),
    MODERATOR(
            Stream.of(REPORT_READ, REPORT_WRITE)
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
