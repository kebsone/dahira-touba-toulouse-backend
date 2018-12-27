package com.dahira.touba.toulouse.dahiraapp.rest;


import com.dahira.touba.toulouse.dahiraapp.metier.Membre;
import com.dahira.touba.toulouse.dahiraapp.service.MembreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/membres")
@RestController
public class MembreController {

@Autowired
private MembreService membreService;

    @PostMapping()
    private Membre creerMembre(@RequestBody Membre membre){
        return membreService.creerMembre(membre);
    }

    @PutMapping()
    private Membre updateMembre(@RequestBody Membre membre){
        return membreService.updateMembre(membre);
    }

    @GetMapping(path = "/{id}")
    private Membre getMembreById(@PathVariable  Long id){
        Optional<Membre> result = membreService.getMembreById(id);
        if(result.isPresent()){
            return result.get();
        }
        return  null;
    }

    /**
     * Fonction permettant de retourner tous membres du dahira
     * @return
     */
    @GetMapping()
    private List<Membre> getMembres(){
        return membreService.getMembres();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerMembre(@PathVariable Long id){
             return membreService.supprimerMembre(id);
    }
}
