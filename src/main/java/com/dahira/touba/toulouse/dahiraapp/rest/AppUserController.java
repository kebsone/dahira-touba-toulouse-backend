package com.dahira.touba.toulouse.dahiraapp.rest;


import com.dahira.touba.toulouse.dahiraapp.Utils.AppUserForm;
import com.dahira.touba.toulouse.dahiraapp.metier.AppUser;
import com.dahira.touba.toulouse.dahiraapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppUserController {

    @Autowired
    private AccountService accountService;


    @PostMapping("/register")
    public AppUser register(@RequestBody  AppUserForm appUserForm){
       return  accountService.saveUser(appUserForm);
    }

    @GetMapping("/user/{username}")
    public AppUser getUserByUserName(@PathVariable String username){
        return accountService.loadUserByUserName(username);
    }


    @PutMapping("/user")
    public AppUser updateUser(@RequestBody AppUserForm appUserForm){
        return accountService.updateUser(appUserForm);
    }
    @GetMapping("/appUsers")
    public List<AppUser> getAppUsers(){
        return accountService.getAppUsers();
    }
}
