package com.danielpm1982.REST_WS6.dao;
import com.danielpm1982.REST_WS6.entity.Role;

public interface RoleDaoInterface {
	public abstract Role findRoleByName(String roleName);
}
