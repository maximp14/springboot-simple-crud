package com.maxi.crud.security;

import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

public enum UserPermission {
  PERSON_READ("person:read"),
  PERSON_WRITE("person:write");

  private String permission;

  UserPermission(String permission){
    this.permission = permission;
  }

  public String getPermission() {
    return permission;
  }


}
