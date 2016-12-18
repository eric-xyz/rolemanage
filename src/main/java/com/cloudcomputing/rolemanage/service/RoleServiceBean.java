package com.cloudcomputing.rolemanage.service;

import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

import com.cloudcomputing.database.GaeConnection;
import com.cloudcomputing.rolemanage.model.Role;

@Service
public class RoleServiceBean implements RoleService {
	
	private static Map<String, Role> roleMap;
	private static GaeConnection gc=new GaeConnection();

	
	static{
		roleMap = new HashMap<>();
		Role role1 = new Role();
		role1.setRole_name("test1");
		Role role2 = new Role();
		role2.setRole_name("test2");
		roleMap.put("test1", role1);
		roleMap.put("test2", role2);
	}

	@Override
	public Collection<Role> findAll() {
		Collection<Role> roles;
		try {
			roles = gc.findAll();
			return roles;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
	}


}
