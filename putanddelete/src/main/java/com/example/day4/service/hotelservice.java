package com.example.day4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.day4.model.hotelmodel;
import com.example.day4.repo.hotelrepo;

@Service
public class hotelservice {
 
	@Autowired
	public hotelrepo hr;
	//POST THE DATA
	public String savehotel(hotelmodel h)
	{
		hr.save(h);
		return "Data is saved to database";
	}
	//GET THE DATA
	public List<hotelmodel> gethotel()
	{
		return hr.findAll();
	}
	//UPDATE THE DATA(PUT)
	
	public boolean updateHotelif(int hid,hotelmodel hm)
	{
		if(hr.existsById(hid))
		{
			hr.save(hm);
			return true;
		}
		return false;
	}
	public hotelmodel updatehotel(hotelmodel hm)
	{
		return hr.saveAndFlush(hm);
	}
	//Delete if id is present
	public boolean deleteHotelif(int hid)
	{
		if(hr.existsById(hid))
		{
			hr.deleteById(hid);
			return true;
		}
		return false;
	}
	//DELETE THE DATA
	public void deletehotel(int id)
	{
		System.out.println("Deleted");
		hr.deleteById(id);
	}
	
	
	public Optional<hotelmodel> getUserId(int userId)
	{
		Optional<hotelmodel> hotel=hr.findById(userId);
		if(hotel.isPresent())
		{
			return hotel;
		}
		return null;
	}
}
