package com.m1.s2.cours;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class Code {

	public void Sample1_srv() throws IOException{
		ServerSocket s;
		
		s = new ServerSocket(8080);
		Socket c = s.accept(); //ici attente de connexion bloquante
		
		OutputStream os = c.getOutputStream();
		os.write(2);
		
		InputStream is = c.getInputStream();
		int x = is.read(); // read bloquant
		System.out.println("x="+x);
		
		c.close();
		s.close();
	}
	
	public void Sample1_cli() throws IOException{
		Socket c;
		SocketAddress localhost = new InetSocketAddress("localhost", 8080);
		
		c = new Socket(); // choix arbitraire du port
		c.connect(localhost, 8080);
		
		//alt -> c = new Socket("localhost", 8080); Solution deux en uns !
		
		InputStream is = c.getInputStream();
		int x = is.read(); // read bloquant
		System.out.println("x="+x);
		
		OutputStream os = c.getOutputStream();
		os.write(3);
		c.close();
	}
	
	public static void main(String[] args) {
		
		
		
	}

}
