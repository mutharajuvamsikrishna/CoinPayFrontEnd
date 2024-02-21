package com.web.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.web.model.Converter;

public interface ProRepo extends CrudRepository<Converter, String> {

	Converter findByMob(String mob);

	Converter findBypassword(String password);

	Converter findByMobAndPassword(String mob, String password);

	Converter findByEmailAndPassword(String email, String password);

	List<Converter> findAll();

	Converter findByEmailAndMob(String email, String mob);

	Converter findByEmail(String email);

}
