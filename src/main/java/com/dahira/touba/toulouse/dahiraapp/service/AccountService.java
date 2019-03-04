package com.dahira.touba.toulouse.dahiraapp.service;

import com.dahira.touba.toulouse.dahiraapp.Utils.AppUserForm;
import com.dahira.touba.toulouse.dahiraapp.metier.AppRole;
import com.dahira.touba.toulouse.dahiraapp.metier.AppUser;

import java.util.List;

public interface AccountService {
    public AppUser saveUser(AppUserForm appUserForm);
    public AppRole saveRole(AppRole role);
    public AppUser loadUserByUserName(String userName);
    public void addRoleToUser(String userName, String roleName);
    public List<AppUser> getAppUsers();
    public AppUser updateUser(AppUserForm appUserForm);
    //public AppUser getUserById(Long id);
}













