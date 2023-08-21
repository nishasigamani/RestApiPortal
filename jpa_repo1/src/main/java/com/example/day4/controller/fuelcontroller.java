package com.example.day4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.day4.model.fuelstation;
import com.example.day4.service.fuelservice;

@RestController
public class fuelcontroller {
	        @Autowired
            fuelservice f;
	        @PostMapping("/savefuel")
	        public fuelstation savefuelstationde( @RequestBody fuelstation fb)
	        {
	        	return f.saveDetails(fb);
	        }
	        @GetMapping("/getfuel")
	        public List<fuelstation>getfuelstationde()
	        {
	        	return f.getDetails();
	        }
}
