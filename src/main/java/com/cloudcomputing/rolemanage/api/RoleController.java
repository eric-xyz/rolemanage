package com.cloudcomputing.rolemanage.api;

import com.cloudcomputing.rolemanage.model.Role;
import com.cloudcomputing.rolemanage.service.RoleServiceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class RoleController {	
	
	@Autowired
	private RoleServiceBean roleService;
	
	@RequestMapping(
		value = "/api/roles", 
		method = RequestMethod.GET, 
		produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Role>> getUsers(){
		Collection<Role> roles = roleService.findAll();
		return new ResponseEntity<Collection<Role>>(roles,
						HttpStatus.OK);
				
	}
}
