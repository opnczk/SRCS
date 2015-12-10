package com.m1.s2.tmeRMI.exo3;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PersonneIF extends Remote{

	public void setFirstName(String firstName)throws RemoteException;

	public String getName()throws RemoteException;

	public void setName(String name)throws RemoteException;

	public String getFirstName()throws RemoteException;

	public void setNbViews(int nbViews)throws RemoteException;

	public int getNbViews()throws RemoteException;

	public void setAddress(String address)throws RemoteException;

	public String getAddress()throws RemoteException;

	public void setPhoneNumber(String phoneNumber)throws RemoteException;

	public String getPhoneNumber()throws RemoteException;
	
}
