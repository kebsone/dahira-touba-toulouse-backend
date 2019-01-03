package com.dahira.touba.toulouse.dahiraapp.rest;


import com.dahira.touba.toulouse.dahiraapp.Utils.AppUserForm;
import com.dahira.touba.toulouse.dahiraapp.metier.AppUser;
import com.dahira.touba.toulouse.dahiraapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppUserController {

    @Autowired
    private AccountService accountService;


    @PostMapping("/register")
    public AppUser register(@RequestBody  AppUserForm appUserForm){
       return  accountService.saveUser(appUserForm.getUserName(), appUserForm.getPassword(), appUserForm.getConfirmedPassword());
    }
}
