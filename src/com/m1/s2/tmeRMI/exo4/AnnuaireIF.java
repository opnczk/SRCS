package com.m1.s2.tmeRMI.exo4;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AnnuaireIF extends Remote{
	public void savePerson(String name, String number) throws RemoteException;
	public String getNumber(String name) throws RemoteException;
}
