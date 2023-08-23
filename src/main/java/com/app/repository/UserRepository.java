package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> 
{
	  Optional<User> findByEmail(String email);

	  Boolean existsByEmail(String email);

	  Boolean existsByPanNumber(String pan);
	  
	  Optional<User> findByEmailAndPassword(String em,String pass);
	  
}
