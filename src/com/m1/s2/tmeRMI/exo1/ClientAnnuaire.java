package com.m1.s2.tmeRMI.exo1;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientAnnuaire {

	
	public static void main(String args[]){
		Registry registry = null;
		try {
			registry = LocateRegistry.getRegistry("localhost", 5500);
		} catch (RemoteException e) {
			System.out.println("Erreur lors du locate registry");
			e.printStackTrace();
			System.exit(0);
		}
		
		AnnuaireIF annuaire = null;
		try {
			annuaire = (AnnuaireIF)registry.lookup("Annuaire");
		} catch (RemoteException | NotBoundException e) {
			System.out.println("Erreur lors du lookup");
			e.printStackTrace();
			System.exit(0);
		}
		
		System.out.println("On ajoute quelqu'un ?");
		try {
			annuaire.savePerson("Paul", "+33 666");
			
			System.out.println("on a enregistré Paul - on le lit ?");
			
			System.out.println("Le numéro de Paul est "+annuaire.getNumber("Paul"));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}
}
