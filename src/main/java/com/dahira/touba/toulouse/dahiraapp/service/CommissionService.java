package com.dahira.touba.toulouse.dahiraapp.service;

import com.dahira.touba.toulouse.dahiraapp.metier.Commission;
import com.dahira.touba.toulouse.dahiraapp.repository.CommissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommissionService {

    @Autowired
    private CommissionRepository commissionRepository;

    public List<Commission>findAllCommissions(){
        return commissionRepository.findAll();
    }
}
