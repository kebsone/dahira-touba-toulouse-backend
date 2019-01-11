package com.dahira.touba.toulouse.dahiraapp.metier;

import java.io.Serializable;
import java.util.List;

public class Commission implements Serializable {
    private long id;
    private String nom;
    private String description;
    private List<RoleCommission> rolesRoleCommissionList;
}
