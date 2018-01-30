package com.example.useradmin.entities;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class RoleRepositoryImpl implements RoleRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Role> findById(String id) {
		return this.entityManager.createQuery("FROM Role as r WHERE r.id = " + id).getResultList();
	}

}
