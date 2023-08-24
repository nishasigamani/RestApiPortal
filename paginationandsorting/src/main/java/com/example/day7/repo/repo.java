package com.example.day7.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.day7.model.model;

public interface repo extends JpaRepository<model,Integer>
{

}
