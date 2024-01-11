package com.myproject.votingapp.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.votingapp.entities.user;

public interface registerRepository extends CrudRepository<user, Integer>{
	
//	public String findByrole(String name);
	
	@Transactional
	@Modifying
	@Query("update user set voted=:v where name=:n")
	public void setVoted(@Param("v") String voted ,@Param("n") String name);
	
	@Query("select password from user u where name =:n")
	public String getPassword(@Param("n") String name);
	
	@Query("select voted from user u where name =:n")  
	public String getByVoted(@Param("n") String name);
	
	@Query("select u from user u where id =:n")  
	public user getByUser(@Param("n") int id);
	
	@Query("select role from user u where name =:n")  
	public String getByRole(@Param("n") String name);
	
	
}
