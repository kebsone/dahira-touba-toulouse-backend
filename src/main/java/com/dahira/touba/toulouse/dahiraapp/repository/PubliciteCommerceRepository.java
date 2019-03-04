package com.dahira.touba.toulouse.dahiraapp.repository;

import com.dahira.touba.toulouse.dahiraapp.metier.PubliciteCommerce;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PubliciteCommerceRepository extends JpaRepository<PubliciteCommerce, Long> {
    public List<PubliciteCommerce> findAll();
}
