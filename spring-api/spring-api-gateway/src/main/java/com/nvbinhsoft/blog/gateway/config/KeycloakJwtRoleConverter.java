package com.nvbinhsoft.blog.gateway.config;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

/** Extracts Keycloak realm/resource roles and maps them to Spring Security authorities. */
class KeycloakJwtRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

  private final String clientId;

  KeycloakJwtRoleConverter(String clientId) {
    this.clientId = clientId;
  }

  @Override
  public Collection<GrantedAuthority> convert(Jwt jwt) {
    Set<String> roles = new HashSet<>();

    Map<String, Object> realmAccess = jwt.getClaim("realm_access");
    if (realmAccess != null) {
      roles.addAll(extractRoles(realmAccess.get("roles")));
    }

    Map<String, Object> resourceAccess = jwt.getClaim("resource_access");
    if (resourceAccess != null && StringUtils.hasText(clientId)) {
      Object clientResource = resourceAccess.get(clientId);
      if (clientResource instanceof Map<?, ?> clientAccess) {
        roles.addAll(extractRoles(clientAccess.get("roles")));
      }
    }

    if (CollectionUtils.isEmpty(roles)) {
      return Collections.emptyList();
    }

    return roles.stream()
        .filter(StringUtils::hasText)
        .map(role -> role.startsWith("ROLE_") ? role : "ROLE_" + role)
        .map(SimpleGrantedAuthority::new)
        .collect(Collectors.toUnmodifiableSet());
  }

  @SuppressWarnings("unchecked")
  private Collection<String> extractRoles(Object roles) {
    if (roles instanceof Collection<?>) {
      return ((Collection<Object>) roles).stream().map(Object::toString).toList();
    }
    return Collections.emptyList();
  }
}
