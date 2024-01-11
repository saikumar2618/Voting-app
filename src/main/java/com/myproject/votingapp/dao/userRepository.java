package com.myproject.votingapp.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.votingapp.entities.participants;

public interface userRepository extends CrudRepository<participants, Integer>{

	public String getByName(String name);
	
	@Query("select count from participants u where name =:n")  
	public int getByCount(@Param("n") String name);
	
	@Transactional
	@Modifying
	@Query("update participants set count = count+1 where name=:n")
	public void setCount(@Param("n") String name);
	
	
}
