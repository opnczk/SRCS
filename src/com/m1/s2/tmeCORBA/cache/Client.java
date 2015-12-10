package com.m1.s2.tmeCORBA.cache;

import org.omg.CORBA.ORB;

public class Client {
	public static void main(String args[]) throws Exception {
ORB orb = ORB.init(args, null);
		
		String url ="corbaname::localhost:900#serveur";
		org.omg.CORBA.Object obj = orb.string_to_object(url);
		
		FileSystem serv = FileSystemHelper.narrow(obj);
		
		
	}
}
