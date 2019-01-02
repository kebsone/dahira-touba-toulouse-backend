package com.dahira.touba.toulouse.dahiraapp.service;

import com.dahira.touba.toulouse.dahiraapp.metier.AppRole;
import com.dahira.touba.toulouse.dahiraapp.metier.AppUser;

public interface AccountService {
    public AppUser saveUser(String userName, String password, String confirmPassword);
    public AppRole saveRole(AppRole role);
    public AppUser loadUserByUserName(String userName);
    public void addRoleToUser(String userName, String roleName);
}













