package com.m1.s2.tmeRMI.exo2;

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
		
		Personne person = new Personne();
		person.setName("Mabillot");
		person.setAddress("32, rue de Rien");
		person.setFirstName("Paul");
		person.setPhoneNumber("+33 666");
		
		System.out.println("On ajoute quelqu'un ?");
		try {
			annuaire.savePerson("Paul", person);
			
			System.out.println("on a enregistré Paul - on le lit ?");
			Personne paul = annuaire.getPerson("Paul");
			System.out.println("Le numéro de "+paul.getFirstName()+" "+paul.getName()+" sont adresse est "+paul.getAddress());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}
}
