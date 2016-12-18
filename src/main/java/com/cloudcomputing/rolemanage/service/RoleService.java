package com.cloudcomputing.rolemanage.service;

import java.util.Collection;

import com.cloudcomputing.rolemanage.model.Role;



public interface RoleService {
	
	Collection<Role> findAll();
}
