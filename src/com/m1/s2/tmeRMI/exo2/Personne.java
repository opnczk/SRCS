package com.m1.s2.tmeRMI.exo2;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Personne implements Serializable{
	private String name;
	private String firstName;
	private String phoneNumber;
	private String address;
	private int nbViews;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getNbViews() {
		return nbViews;
	}
	public void setNbViews(int nbViews) {
		this.nbViews = nbViews;
	}
}
