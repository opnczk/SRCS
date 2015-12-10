package com.m1.s2.tme1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CryptoLog {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("file.txt"));
			Monologue.readChars("filend.txt", 10);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
