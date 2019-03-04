package com.dahira.touba.toulouse.dahiraapp.repository;

import com.dahira.touba.toulouse.dahiraapp.metier.Poste;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PosteRepository extends JpaRepository<Poste, Long> {

    public List<Poste> getPostesByCommission(Long id);
}
