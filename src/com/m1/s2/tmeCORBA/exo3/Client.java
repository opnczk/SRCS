package com.m1.s2.tmeCORBA.exo3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.omg.CORBA.ORB;
import org.omg.CORBA.Object;

import com.m1.s2.tmeCORBA.exo3.DistantHashTable;
import com.m1.s2.tmeCORBA.exo3.DistantHashTableHelper;

public class Client {
	public static void main(String args[]){
		ORB orb = ORB.init(args, null);
		
		String url ="corbaname::localhost:900#serveur";
		org.omg.CORBA.Object obj = orb.string_to_object(url);
		
		DistantHashTable serv = DistantHashTableHelper.narrow(obj);
		
		serv.put("k", "MaBite");
		System.out.println("Get : " + serv.get("k"));
		
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
