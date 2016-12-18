package com.cloudcomputing.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cloudcomputing.rolemanage.model.Role;


public class GaeConnection {
	
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		String driverClassName = "com.mysql.jdbc.Driver";
		String connectionUrl = "jdbc:mysql://104.154.142.10/robocode";
		String dbUser = "himanshi";
		String dbPwd = "aggarwal";
		Class.forName(driverClassName);
		Connection conn=DriverManager.getConnection(connectionUrl,dbUser,dbPwd);
		return conn;
	}
	public Collection<Role> findAll() throws SQLException, ClassNotFoundException{
		List<Role> roles=new ArrayList<>();
		Connection conn=getConnection();
		if(conn==null){
			System.out.println("Connection Not made");
			return null;
		}
		else{
			System.out.println("Successfull Connection");
			String s="select * from role;";
			PreparedStatement ps=conn.prepareStatement(s);
			ResultSet rs=ps.executeQuery();
			if(rs==null){
				return null;
			}
			else
			{	
				while(rs.next()){
					Role role= new Role();
					role.setRole_name(rs.getString("role_name"));
					role.setGae_role(rs.getString("gae_role"));
					role.setNew_robot(rs.getString("new_robot"));
					role.setEdit_robot(rs.getString("edit_robot"));
                    role.setView_robot(rs.getString("view_robot"));
                    role.setEdit_role(rs.getString("edit_role"));
                    role.setEdit_user(rs.getString("edit_user"));
					System.out.println(rs.getString("role_name"));
					roles.add(role);
				}
			}
			return roles;
		}
	}
}
