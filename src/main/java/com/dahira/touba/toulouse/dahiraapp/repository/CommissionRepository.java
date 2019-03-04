package com.dahira.touba.toulouse.dahiraapp.repository;

import com.dahira.touba.toulouse.dahiraapp.metier.Commission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommissionRepository extends JpaRepository<Commission, String>{

    public List<Commission> findAll();

}
