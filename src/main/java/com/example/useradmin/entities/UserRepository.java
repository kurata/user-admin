/**
 * 
 */
package com.example.useradmin.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByName(String name);

}
