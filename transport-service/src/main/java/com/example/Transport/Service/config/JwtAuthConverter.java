package com.example.Transport.Service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;

import java.nio.file.AccessDeniedException;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Configuration
public class JwtAuthConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

    private static final String REALM_CLAIM = "realm_access";
    private static final String ROLES_CLAIM = "roles";

    private static final Set<String> ALLOWED_ROLES = Set.of("ADMIN", "OPERATOR", "USER");

    @Override
    public Collection<GrantedAuthority> convert(Jwt jwt) {
        var authoritiesConverter = new JwtGrantedAuthoritiesConverter();
        Collection<GrantedAuthority> grantedAuthorities = new HashSet<>(authoritiesConverter.convert(jwt));

        var realmAccess = jwt.getClaimAsMap(REALM_CLAIM);
        if (realmAccess != null && realmAccess.containsKey(ROLES_CLAIM)) {
            List<String> roles = (List<String>) realmAccess.get(ROLES_CLAIM);
            Boolean isTrue = roles.stream().anyMatch(ALLOWED_ROLES::contains);
            if (!isTrue) {
                try {
                    throw new AccessDeniedException("Недостаточно прав");
                } catch (AccessDeniedException e) {
                    throw new RuntimeException(e);
                }
            }else{
                grantedAuthorities.addAll(roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
            }
        }



        return grantedAuthorities;
    }

}
