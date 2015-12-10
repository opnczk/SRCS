package com.m1.s2.tme1;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

public class CesarWriter extends FilterWriter {

	int decalage;
	
	CesarWriter(Writer w) {
		super(w);
	}
	
	CesarWriter(Writer w, int decalage){
		super(w);
		this.decalage = decalage;
	}

	@Override
	public void write(String str, int a, int b) throws IOException{
		StringBuffer res = new StringBuffer(str);
		
		char c;
		
		for(int i = 0; i < str.length() ; i ++){
			//c = (char)str.charAt(i);
			// attr decalage
			res.setCharAt(i,((char)('a' + ((res.charAt(i) - 'a' + decalage)%26))));
			System.out.println(res.charAt(i));
		}
		
		super.write(res.toString(), a, b);
	}
	
	public void setDecalage(int i){
		this.decalage = i;
	}
	
}
