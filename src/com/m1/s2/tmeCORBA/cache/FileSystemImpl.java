
package com.m1.s2.tmeCORBA.cache;

import java.util.HashMap;

public class FileSystemImpl extends FileSystemPOA {
	private HashMap hash;
	
	public FileSystemImpl(){
		this.hash = new HashMap<>();
		/*
			Object o = hash.get(k);
			o = new Object();
		*/
	}
	
	@Override
	public String read(String Reference) {
		
		return null;
	}

	@Override
	public void write(String Reference, String Donnee) {
		
	}
	
}
