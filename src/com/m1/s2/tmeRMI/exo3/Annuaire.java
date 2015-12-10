package com.m1.s2.tmeRMI.exo3;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class Annuaire implements AnnuaireIF {
	private HashMap<String,PersonneIF> data = new HashMap<String, PersonneIF>();
	
	@Override
	public void savePerson(String name, PersonneIF person) throws RemoteException {
		data.put(name, person);
	}

	@Override
	public PersonneIF getPerson(String name) throws RemoteException {
		PersonneIF person;
		person = data.get(name);
		person.setNbViews(person.getNbViews() + 1);
		return person;
	}

	public static void main(String args[]){
		AnnuaireIF annuaire = new Annuaire();
		try {
			UnicastRemoteObject.exportObject(annuaire, 0);
		} catch (RemoteException e) {
			System.out.println("Lancé de nain lors de l'export de l'objet !");
			e.printStackTrace();
			System.exit(0);
		}
		
		Registry registry = null;
		try {
			registry = LocateRegistry.createRegistry(5500);
			//registry = LocateRegistry.getRegistry("localhost", 5500);
		} catch (RemoteException e) {
			System.out.println("Lancé de nain lors de la localisation de registry !");
			e.printStackTrace();
			System.exit(0);
		}
		try {
			registry.bind("Annuaire", annuaire);
		} catch (RemoteException | AlreadyBoundException e) {
			System.out.println("Lancé de nain lors du bind !");
			e.printStackTrace();
			System.exit(0);
		}
		
		System.out.println("Serveur lancé sans lancé de nain !");
		
	}//fin du main
}
