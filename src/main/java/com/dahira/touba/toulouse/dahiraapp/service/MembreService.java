package com.dahira.touba.toulouse.dahiraapp.service;

import com.dahira.touba.toulouse.dahiraapp.metier.Membre;
import com.dahira.touba.toulouse.dahiraapp.repository.MembreRepository;
import net.bytebuddy.asm.Advice;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("membreService")
@Transactional
public class MembreService {
@Autowired
private MembreRepository membreRepository;
    public Membre creerMembre(Membre membre) throws ConstraintViolationException {
        Membre membreCreer = null;
        try {
            membreCreer = membreRepository.save(membre);
            membreRepository.flush();
        }catch (DataIntegrityViolationException ex){
            throw new RuntimeException(ex);
        }
        return membreCreer;
    }

    public List<Membre> getMembres() {
        return membreRepository.findAll();
    }

    public ResponseEntity<Void> supprimerMembre(Long id) {

         try {
             membreRepository.deleteById(id);
             membreRepository.flush();
         } catch(Exception ex) {
            throw new RuntimeException(ex);
        }

        return ResponseEntity.noContent().build();
    }

    public Optional<Membre> getMembreById(Long id) {
        return membreRepository.findById(id);
    }

    public Membre updateMembre(Membre membre) {
        Membre result = null;
        try{
            result=  membreRepository.save(membre);
            membreRepository.flush();
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
        return result;
    }
}
