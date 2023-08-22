package com.example.day4.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.day4.model.hotelmodel;
import com.example.day4.service.hotelservice;

@RestController
public class hotelcontroller {

	@Autowired
	public hotelservice hs;
	/////////POSTMAPPING//////////////
	
	@PostMapping("/posthotel")
	public String posthotel(@RequestBody hotelmodel hrr)
	{
		hs.savehotel(hrr);
		return "Data saved";
	}
	
	/////////GETMAPPING/////////
	
	@GetMapping("/gethotel")
	public List<hotelmodel> gethotelinfo()
	{
		return hs.gethotel();
	}
	
	///////PUT MAPPING///////////
	
	@PutMapping("/Updatehotel")
	public hotelmodel updatehotel(@RequestBody hotelmodel ha)
	{
		return hs.updatehotel(ha);
	}
	
	@PutMapping("/updateHotel/{id}")
	public ResponseEntity<String>updateHotelInfo(@PathVariable int id,@RequestBody hotelmodel ha)
	{
		boolean updated=hs.updateHotelif(id,ha);
		if(updated)
		{
			return ResponseEntity.ok("Hotel with Id "+ id + " is updated  successfully");		
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hotel with Id "+ id + " is not found");
		}
	}
	
	////////////DELETE MAPPING USING PATH VARIABLE/////////////
	
	@DeleteMapping("/deleteHotel/{id}")
	public String deleteHotel(@PathVariable("id") int hid)
	{
		hs.deletehotel(hid);
		return "Hotel With Id "+hid+" is deleted "; 
	}
	
	/////////DELETE MAPPING USING REQUEST PARM///////////////
	
	@DeleteMapping("/byReqParm")
	public String removeByRequestPam(@RequestParam("id") int id)
	{
		hs.deletehotel(id);
		return "Hotel with Id "+ id + " is deleted ";
	}
	@DeleteMapping("/deleteHotelif/{id}")
	public ResponseEntity<String>deleteHotelInfo(@PathVariable int id)
	{
		boolean deleted=hs.deleteHotelif(id);
		if(deleted)
		{
			return ResponseEntity.ok("Hotel with Id "+ id + " is deleted  successfully");		
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hotel with Id "+ id + " is not found");
		}
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<?> getUserById(@PathVariable int userId)
	{
		Optional <hotelmodel>hotel=hs.getUserId(userId);
		if(hotel!=null)
		{
			return ResponseEntity.ok(hotel);//Return the users data if avail
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("USER NOT AVAIL");
	}
}
