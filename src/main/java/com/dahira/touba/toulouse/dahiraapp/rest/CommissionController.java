package com.dahira.touba.toulouse.dahiraapp.rest;

import com.dahira.touba.toulouse.dahiraapp.metier.Commission;
import com.dahira.touba.toulouse.dahiraapp.service.CommissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommissionController {

    @Autowired
    private CommissionService commissionService;

    @GetMapping("/commissions")
    public List<Commission> findAllCommisions(){
        return commissionService.findAllCommissions();
    }

}
