package com.m1.s2.tmeRMI.exo3;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AnnuaireIF extends Remote{
	public void savePerson(String name, PersonneIF person) throws RemoteException;
	public PersonneIF getPerson(String name) throws RemoteException;
}
