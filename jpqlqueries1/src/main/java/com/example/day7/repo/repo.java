package com.example.day7.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.day7.model.model;

import jakarta.transaction.Transactional;

public interface repo extends JpaRepository<model,Integer>
{

	//NATIVE QUERY
	
	@Query (value="select * from flowers",nativeQuery=true)
	public List<model> getAllrows();
	
	
	@Query("select h from model h where h.name like %?1%")
	public List<model> getByname(@Param("name") String name);
	
	
	
	@Query(value="select * from flowers where color=:color and name=:name",nativeQuery=true)
	public List<model> getSpecRows(@Param("color") String color,@Param("name") String name);
	
	//DELETE QUERY
	@Modifying
	@Transactional
	@Query (value="delete from flowers where id=:id1", nativeQuery=true)
	public int deleteId(@Param("id1") int id);
	
	//UPDATE
	@Modifying
	@Transactional
	@Query(value="Update flowers set color=:color where id=:id",nativeQuery=true)
	public Integer updateByid(@Param("color") String color,@Param("id") int id);
	
	
	
}
