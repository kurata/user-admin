package com.example.useradmin.entities;

import java.util.List;

public interface RoleRepository {

	List<Role> findById(String id);

}
