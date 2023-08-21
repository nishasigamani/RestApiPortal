package com.example.day4.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="petrolBunk")
public class fuelstation 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int sap;
	@Column(name="bunkname")
    private String bunkname;
    private String address;
	public int getSap() {
		return sap;
	}
	public void setSap(int sap) {
		this.sap = sap;
	}
	public String getBunkname() {
		return bunkname;
	}
	public void setBunkname(String bunkname) {
		this.bunkname = bunkname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
    
    
}
