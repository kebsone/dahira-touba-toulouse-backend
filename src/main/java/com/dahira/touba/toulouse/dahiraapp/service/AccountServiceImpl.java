package com.dahira.touba.toulouse.dahiraapp.service;

import com.dahira.touba.toulouse.dahiraapp.metier.AppRole;
import com.dahira.touba.toulouse.dahiraapp.metier.AppUser;
import com.dahira.touba.toulouse.dahiraapp.repository.AppRoleRepository;
import com.dahira.touba.toulouse.dahiraapp.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private AppRoleRepository appRoleRepository;

    private AppUserRepository appUserRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AccountServiceImpl(AppRoleRepository appRoleRepository, AppUserRepository appUserRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.appRoleRepository = appRoleRepository;
        this.appUserRepository = appUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public AppUser saveUser(String userName, String password, String confirmPassword) {
        //Est ce que l'utilisateur existe ou pas
        AppUser user = appUserRepository.findByUserName(userName);
        if(user !=null) throw new RuntimeException(" User existe déjà");
        if(!password.equals(confirmPassword)) throw new RuntimeException("Svp confirmez le mot de pass");
        AppUser appUser = new AppUser();
        appUser.setUsername(userName);
        appUser.setActived(true);
        // cripter le mot de pass avant de le setter
        appUser.setPassword(bCryptPasswordEncoder.encode(password));
        appUserRepository.save(appUser);
        addRoleToUser(userName, "USER");
        return appUser;
    }

    @Override
    public AppRole saveRole(AppRole role) {
        return appRoleRepository.save(role);
    }

    @Override
    public AppUser loadUserByUserName(String userName) {
        return appUserRepository.findByUserName(userName);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
            AppUser appUser = appUserRepository.findByUserName(userName);
            AppRole appRole = appRoleRepository.findByRoleName(roleName);
            appUser.getRoles().add(appRole);
    }
}
