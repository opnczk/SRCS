package com.m1.s2.tme2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{
	ServerSocket ss;
	int port;
	boolean serverOpen;
	Socket s;
	InputStream is;
	OutputStream os;
	
	
	public Server(){
		
	}
	
	public void open(int port){
		this.port = port;
		
		try {
			ss = new ServerSocket(port);
		} catch (IOException e) {
			System.out.println("ServerSocket error");
			e.printStackTrace();
		}
		
		this.serverOpen = true;
		while(serverOpen){
			try {
				 s = ss.accept();
			} catch (IOException e) {
				System.out.println("Socket accept error");
				e.printStackTrace();
			}

			Thread t = new Thread(new HttpRequest(s));
			t.start(); // lancement du thread car l'utilisation de this.run() dans le constructueur de HttpRequest était bidon....
		}
	}
	
	
	public void close(){
		this.serverOpen = false;
	}
	
	public static void main(String[] args) {
		Server serv = new Server();
		
		System.out.println("serv.open");
		serv.open(8080);
		
		
		//serv.close();
	}

}
