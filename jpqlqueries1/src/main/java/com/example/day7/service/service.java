package com.example.day7.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.day7.model.model;
import com.example.day7.repo.repo;

@Service
public class service 
{
    @Autowired    
	public repo r;
	public List<model> getflowers()
	{
		return r.findAll();
	}
	public model updateflowers(model hm)
	{
		return r.saveAndFlush(hm);
	}
	
	public List<model> getAllrows()
	{
		return r.getAllrows();
	}
	public List<model>getSpecrows(String color,String name)
	{
		return r.getSpecRows(color,name);
	}
	public List<model>getByName(String name)
	{
		return r.getByname(name);
	}
	//delete the data
	public int deleteRowByid(int id)
	{
		return r.deleteId(id);
	}
	public int updateRow(String color,int id)
	{
		return r.updateByid(color, id);
	}
}
