package com.example.day7.controller1;

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

import com.example.day7.model1.model1;
import com.example.day7.service1.service1;
@RestController
public class controller1 
{
	@Autowired
	public service1 hs;
	@PostMapping("/post")
	public String postvegetables(@RequestBody model1 hrr)
	{
		hs.savevegetables(hrr);
		return "Data saved";
	}
	
	/////////GETMAPPING/////////
	
	@GetMapping("/get")
	public List<model1> getvegetablesinfo()
	{
		return hs.getvegetables();
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<?> getUserById(@PathVariable int userId)
	{
		Optional <model1>vegetables=hs.getUserId(userId);
		if(vegetables!=null)
		{
			return ResponseEntity.ok(vegetables);//Return the users data if avail
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("USER NOT AVAIL");
	}
}
