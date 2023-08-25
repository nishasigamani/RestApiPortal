package com.example.day7.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.day7.model.model;
import com.example.day7.service.service;

@RestController
public class controller 
{
	@Autowired
     public service s;
	@GetMapping("/get")
	public List<model> getflowersinfo()
	{
		return s.getflowers();
	}
	@PutMapping("/put")
	public model updateflowers(@RequestBody model ha)
	{
		return s.updateflowers(ha);
	}
	//get all the data
	@GetMapping("/getrow")
	public List<model> getAllrows()
	{
		return s.getAllrows();
	}
	 //get specific data
	@GetMapping("/gets/{color}/{name}")
	public List<model>getSpec(@PathVariable("color")String color,@PathVariable("name")String name)
	{
		return s.getSpecrows(color, name);
	}
	@GetMapping("/getn/{name}")
	public List<model>getname(@PathVariable("name") String name)
	{
		return s.getByName(name);
	}
	
	@DeleteMapping("/deleterow/{id}")
	public String deleteRow(@PathVariable("id") int id)
	{
		return s.deleteRowByid(id)+" deleted successfully";
	}
	//UPDATE
	@PutMapping("/updaterow/{color}/{id}")
	public String updateinfo(@PathVariable("color") String color,@PathVariable("id") int id)
	{
		return s.updateRow(color,id)+" rows updated successfully";
	}
}
