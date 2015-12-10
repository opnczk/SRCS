package com.m1.s2.tmeCORBA.exo1.serveur;

import java.io.FileWriter;
import java.io.IOException;

import org.omg.CORBA.ORB;
import org.omg.CORBA.Object;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

public class ServerImpl extends ServeurPOA {

	@Override
	public double add(double x, double y) {
		return x + y;
	}

	@Override
	public double sub(double x, double y) {
		return x - y;
	}

	@Override
	public double mult(double x, double y) {
		return x * y;
	}

	@Override
	public double div(double x, double y) {
		return x / y;
	}

	public static void main(String args[]) {
		ORB orb = ORB.init(args, null);
		org.omg.CORBA.Object obj = null;
		try {

			org.omg.CORBA.Object rootobj;
			rootobj = orb.resolve_initial_references("RootPOA");

			POA poa = POAHelper.narrow(rootobj);
			poa.the_POAManager().activate();

			ServeurPOA servant = new ServerImpl();

			obj = poa.servant_to_reference(servant);
		} catch (ServantNotActive | WrongPolicy | AdapterInactive | InvalidName e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		saveIOR("serveur.ior", orb, obj);

		orb.run();
	}

	private static void saveIOR(String fileName, ORB orb, Object obj) {
		String ior = orb.object_to_string(obj);
		FileWriter fw;
		try {
			fw = new FileWriter(fileName);
			fw.write(ior);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
