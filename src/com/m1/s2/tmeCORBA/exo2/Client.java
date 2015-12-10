package com.m1.s2.tmeCORBA.exo2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.omg.CORBA.ORB;
import org.omg.CORBA.Object;

import com.m1.s2.tmeCORBA.exo2.serveur.Serveur;
import com.m1.s2.tmeCORBA.exo2.serveur.ServeurHelper;

public class Client {
	
	public static void main(String args[]){
		ORB orb = ORB.init(args, null);
		
		String url ="corbaname::localhost:900#serveur";
		org.omg.CORBA.Object obj = orb.string_to_object(url);
		
		Serveur serv = ServeurHelper.narrow(obj);
		
		System.out.println("Add : " + serv.add(4, 6));
	}

	private static Object restore(String fileName, ORB orb) {
		String ior = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			ior = br.readLine();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return orb.string_to_object(ior);
	}
}