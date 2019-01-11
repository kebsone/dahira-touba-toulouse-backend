package com.dahira.touba.toulouse.dahiraapp.service;

import com.dahira.touba.toulouse.dahiraapp.Utils.AppUserForm;
import com.dahira.touba.toulouse.dahiraapp.metier.AppRole;
import com.dahira.touba.toulouse.dahiraapp.metier.AppUser;
import com.dahira.touba.toulouse.dahiraapp.repository.AppRoleRepository;
import com.dahira.touba.toulouse.dahiraapp.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


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
    public AppUser saveUser(AppUserForm appUserForm) {
        String mail = appUserForm.getMail();
        String password = appUserForm.getPassword();
        String confirmPassword = appUserForm.getConfirmedPassword();
        //Est ce que l'utilisateur existe ou pas
        AppUser user = appUserRepository.findByMail(mail);
        if(user !=null) throw new RuntimeException(" User existe déjà");
        if(!password.equals(confirmPassword)) throw new RuntimeException("Svp confirmez le mot de pass");
        AppUser appUser = new AppUser();
        appUser.setMail(mail);
        appUser.setActived(true);
        appUser.setNom(appUserForm.getNom());
        appUser.setPrenom(appUserForm.getPrenom());
        appUser.setTelephone(appUserForm.getTelephone());
        appUser.setGenre(appUserForm.getGenre());
        appUser.setAdresse(appUserForm.getAdresse());
        // cripter le mot de pass avant de le setter
        appUser.setPassword(bCryptPasswordEncoder.encode(password));
        appUserRepository.save(appUser);
        addRoleToUser(mail, "USER");
        System.out.print("les roles"+ appUser.getRoles());
        return appUser;
    }

    @Override
    public AppRole saveRole(AppRole role) {
        return appRoleRepository.save(role);
    }

    @Override
    public AppUser loadUserByUserName(String userName) {
        return appUserRepository.findByMail(userName);
    }

    @Override
    public void addRoleToUser(String mail, String roleName) {
            AppUser appUser = appUserRepository.findByMail(mail);
        System.out.print("User =============>"+ appUser);
            AppRole appRole = appRoleRepository.findByRoleName(roleName);
        System.out.print("role =============>"+ appRole);
            appUser.getRoles().add(appRole);
        System.out.print("roles User ===========>"+ appUser.getRoles());
    }

    @Override
    public List<AppUser> getAppUsers() {
        return appUserRepository.findAll();
    }
}
