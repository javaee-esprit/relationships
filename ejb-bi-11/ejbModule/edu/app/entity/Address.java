package edu.app.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table( name = "t_address" )

public class Address implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3546706825152352619L;
	
	private int id;
	private String street;
	private String city;
	private int zipCode;
	
	private Employee employee;
	
	
	
	public Address() {
	}



	public Address(String street, String city, int zipCode) {
		this.street = street;
		this.city = city;
		this.zipCode = zipCode;
	}


	@Id
	@GeneratedValue ( strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getStreet() {
		return street;
	}



	public void setStreet(String street) {
		this.street = street;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public int getZipCode() {
		return zipCode;
	}



	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}


	@OneToOne( mappedBy = "address" )
	public Employee getEmployee() {
		return employee;
	}



	public void setEmployee(Employee employee) {
		this.employee = employee;
	}



	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", city=" + city
				+ ", zipCode=" + zipCode + "]";
	}
	
	
	
	
	

}
