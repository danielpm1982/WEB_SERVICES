package com.danielpm1982.REST_WS6.dao;
import com.danielpm1982.REST_WS6.entity.Role;

public interface RoleDaoInterface {
	public abstract Role findRoleByName(String roleName);
}

/*could have used Spring Data automatic CRUD repositories generation 
by extending any extension of the Repository interface, for instance, 
org.springframework.data.jpa.repository.JpaRepository . And later adding
any custom method or implementation needed.*/
