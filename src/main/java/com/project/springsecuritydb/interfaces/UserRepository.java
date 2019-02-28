/**
 * 
 */
package com.project.springsecuritydb.interfaces;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.springsecuritydb.model.User;

/**
 * @author Emmanuel Raj
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	
	Optional<User> findByUsername(String username);

}
