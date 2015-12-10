package com.m1.s2.tmeRMI.exo2;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AnnuaireIF extends Remote{
	public void savePerson(String name, Personne person) throws RemoteException;
	public Personne getPerson(String name) throws RemoteException;
}
