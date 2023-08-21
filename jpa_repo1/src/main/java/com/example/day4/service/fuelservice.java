package com.example.day4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.day4.model.fuelstation;
import com.example.day4.repos.fuelrepo;

@Service
public class fuelservice {
	@Autowired
	fuelrepo r;
	
	public fuelstation saveDetails(fuelstation p)
	{
		return r.save(p);
	}
	public List<fuelstation> getDetails()
	{
		return r.findAll();
	}

}
