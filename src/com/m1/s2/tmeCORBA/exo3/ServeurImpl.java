package com.m1.s2.tmeCORBA.exo3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import org.omg.CORBA.ORB;
import org.omg.CORBA.Object;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

import com.m1.s2.tmeCORBA.exo3.DistantHashTablePOA;

public class ServeurImpl extends DistantHashTablePOA{
	private HashMap<String, String> hash;
	
	public ServeurImpl(){
		this.hash = new HashMap<String,String>();
		
	}
	@Override
	public boolean containsKey(String k) {
		return hash.containsKey(k);
	}

	@Override
	public String get(String k) {
		return hash.get(k);
	}

	@Override
	public void put(String k, String val) {
		hash.put(k, val);
	}
		
	public static void main(String args[]){
			
		// dont forget to lauch in terminal 
		//orbd -ORBInitialHost localhost -ORBInitialPort 900
		
		

		ORB orb = ORB.init(args, null);
		org.omg.CORBA.Object obj = null;
		try{
		
		org.omg.CORBA.Object rootobj;
			rootobj = orb.resolve_initial_references("RootPOA");
		
		POA poa = POAHelper.narrow(rootobj);
			poa.the_POAManager().activate();
		
		org.omg.CORBA.Object ncobj = orb.resolve_initial_references("NameService");
		NamingContext nc = NamingContextHelper.narrow(ncobj);
		
		DistantHashTablePOA servant = new ServeurImpl();
	
			obj = poa.servant_to_reference(servant);
	
		NameComponent[] names = 
				new NameComponent[]{new NameComponent("serveur","")};
		nc.rebind(names, obj);
		} catch (ServantNotActive | WrongPolicy | AdapterInactive | InvalidName e) {
			e.printStackTrace();
		} catch (NotFound e) {
			e.printStackTrace();
		} catch (CannotProceed e) {
			e.printStackTrace();
		} catch (org.omg.CosNaming.NamingContextPackage.InvalidName e) {
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
