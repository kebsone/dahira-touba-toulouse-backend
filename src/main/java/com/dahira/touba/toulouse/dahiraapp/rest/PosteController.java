package com.dahira.touba.toulouse.dahiraapp.rest;

import com.dahira.touba.toulouse.dahiraapp.metier.Poste;
import com.dahira.touba.toulouse.dahiraapp.service.PosteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PosteController {
    @Autowired
    private PosteService posteService;


    @GetMapping("/postes")
    public List<Poste> getAllPostes(){
        return posteService.getAllPostes();
    }

    @GetMapping("postes/id")
    public List<Poste> getPostesByCommissions(Long id){
        return posteService.getPostesByCommissions(id);
    }
}
