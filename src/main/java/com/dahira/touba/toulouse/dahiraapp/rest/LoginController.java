package com.dahira.touba.toulouse.dahiraapp.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public String getLogin(){
        return "hello world jkjkj";
    }
}
