package com.web.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.web.model.Register;
import com.web.model.Register1;

import java.util.List;

@Repository
public interface Register1Repo extends CrudRepository<Register1,String> {
	Register1 findByIdAndPassword(String id, String password);

	Register1 findByEmailAndPassword(String email, String password);

	Register1 findByEmailAndMob(String email, String mob);

	Register1 findByEmail(String email);

List<Register1> findAll();
	 

	
	

}
