package com.example.day4.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.day4.model.hotelmodel;

public interface hotelrepo extends JpaRepository<hotelmodel,Integer> {
 
}
