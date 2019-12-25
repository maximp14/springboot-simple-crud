package com.maxi.crud.security;

import static com.maxi.crud.security.UserPermission.PERSON_READ;
import static com.maxi.crud.security.UserPermission.PERSON_WRITE;

import com.google.common.collect.Sets;
import java.util.Set;

public enum UserRole {
  ADMIN(Sets.newHashSet(PERSON_READ, PERSON_WRITE)),
  GUEST(Sets.newHashSet());

  private final Set<UserPermission> permissions;

  UserRole(Set<UserPermission> permissions) {
    this.permissions = permissions;
  }

  public Set<UserPermission> getPermissions() {
    return permissions;
  }
}
