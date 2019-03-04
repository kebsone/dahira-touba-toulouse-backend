package com.dahira.touba.toulouse.dahiraapp.service;

import com.dahira.touba.toulouse.dahiraapp.metier.Poste;
import com.dahira.touba.toulouse.dahiraapp.repository.PosteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PosteService {

    @Autowired
    private PosteRepository posteRepository;

    public List<Poste> getAllPostes(){
        return  posteRepository.findAll();
    }

    public List<Poste>getPostesByCommissions(Long id){
        return posteRepository.getPostesByCommission(id);
    }
}
