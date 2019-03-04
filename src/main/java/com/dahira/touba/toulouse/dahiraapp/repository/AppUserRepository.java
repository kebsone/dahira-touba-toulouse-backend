package com.dahira.touba.toulouse.dahiraapp.repository;

import com.dahira.touba.toulouse.dahiraapp.metier.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    public AppUser findByMail(String mail);
    public List<AppUser> findAll();
}
