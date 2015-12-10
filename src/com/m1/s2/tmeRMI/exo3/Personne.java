package com.m1.s2.tmeRMI.exo3;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

@SuppressWarnings("serial")
public class Personne  extends UnicastRemoteObject implements PersonneIF{
	
	protected Personne() throws RemoteException {
		super();
	}
	
	private String name;
	private String firstName;
	private String phoneNumber;
	private String address;
	private int nbViews;
	
	@Override
	public String getName() {
		return name;
	}
	@Override
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String getFirstName() {
		return firstName;
	}
	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Override
	public String getPhoneNumber() {
		return phoneNumber;
	}
	@Override
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String getAddress() {
		return address;
	}
	@Override
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public int getNbViews() {
		return nbViews;
	}
	@Override
	public void setNbViews(int nbViews) {
		this.nbViews = nbViews;
	}
}
