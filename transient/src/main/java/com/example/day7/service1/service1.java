package com.example.day7.service1;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.day7.model1.model1;
import com.example.day7.repo1.repo1;


@Service
public class service1 
{
	@Autowired
	public repo1 r;
	//POST THE DATA
	public String savevegetables(model1 h)
	{
		r.save(h);
		return "Data is saved to database";
	}
	//GET THE DATA
	public List<model1> getvegetables()
	{
		return r.findAll();
	}
	public Optional<model1> getUserId(int userId)
	{
		Optional<model1> vegetables=r.findById(userId);
		if(vegetables.isPresent())
		{
			return vegetables;
		}
		return null;
	}
}
