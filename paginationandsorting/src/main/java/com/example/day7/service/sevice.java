package com.example.day7.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.day7.model.model;
import com.example.day7.repo.repo;

@Service
public class sevice 
{ 
	@Autowired
	public repo r;
	//POST THE DATA
	public String savefruits(model h)
	{
		r.save(h);
		return "Data is saved to database";
	}
	//GET THE DATA
	public List<model> getfruits()
	{
		return r.findAll();
	}
	public Optional<model> getUserId(int userId)
	{
		Optional<model> fruits=r.findById(userId);
		if(fruits.isPresent())
		{
			return fruits;
		}
		return null;
	}
	public List<model>sortByAsc(String name)
	{
		return r.findAll(Sort.by(name).ascending());
	}
	public List<model> pagination(int pgno,int pgs)
	{
		Page<model> cont=r.findAll(PageRequest.of(pgno,pgs));
		return cont.getContent();
	}
	public List<model>paginationAndSorting(int pgno,int pgs,String nname)
	{
		Page<model> cont1=r.findAll(PageRequest.of(pgno,pgs,Sort.by(nname)));
		return cont1.getContent();
	}

}
