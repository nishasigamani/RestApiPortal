package com.example.day7.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.day7.model.model;
import com.example.day7.service.sevice;

@RestController
public class controller 
{


	@Autowired
	public sevice hs;
	/////////POSTMAPPING//////////////
	
	@PostMapping("/fruitspost")
	public String postfruits(@RequestBody model hrr)
	{
		hs.savefruits(hrr);
		return "Data saved";
	}
	
	/////////GETMAPPING/////////
	
	@GetMapping("/fruitsget")
	public List<model> getfruitsinfo()
	{
		return hs.getfruits();
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<?> getUserById(@PathVariable int userId)
	{
		Optional <model>fruits=hs.getUserId(userId);
		if(fruits!=null)
		{
			return ResponseEntity.ok(fruits);//Return the users data if avail
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("USER NOT AVAIL");
	}
	//SORT
	
	@GetMapping("/sortAsc/{name}")
	public List<model>sortasc(@PathVariable("name") String name)
	{
		return hs.sortByAsc(name);
	}
	@GetMapping("/pg/{pgno}/{pgs}/{name}")
	public List<model>paginationAndSorting(@PathVariable("pgno")int pgno,@PathVariable("pgs")int pgs,@PathVariable("name") String name)
	{
		return hs.paginationAndSorting(pgno, pgs, name);
	}
}
