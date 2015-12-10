package com.m1.s2.tme1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class Monologue {

	
	static void readChars(String file, int decalage){
		InputStream is = System.in;
		Reader r = new BufferedReader(new InputStreamReader(is));
		
		OutputStream os = null;
		try {
			os = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Writer w = new CesarWriter(new BufferedWriter(new OutputStreamWriter(os)), decalage);
		
		int i;
		try {
		while((i = r.read()) != -1){
			
				w.write(""+(char)i);
		
			w.flush();
			
			System.out.print((char)i);
			System.out.flush();
		}
		
		
		r.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void writeToFile(Writer w){
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
			int decalage = 20;
			Monologue.readChars("file.txt", decalage);
		
		
	}

}
