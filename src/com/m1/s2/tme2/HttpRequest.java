package com.m1.s2.tme2;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class HttpRequest implements Runnable{
	Socket s;
	
	InputStream is;
	OutputStream os;
	
	InputStreamReader isr;
	DataOutputStream dos;
	
	BufferedReader br;
	
	public HttpRequest(Socket s){
		this.s = s;
		
	}
	
	protected void processRequest(){
		try {
			is = s.getInputStream();
			os = s.getOutputStream();
		} catch (IOException e) {
			System.out.println("InputStream error");
			e.printStackTrace();
		}	
		isr = new InputStreamReader(is);
		br = new BufferedReader(isr);
		
		String line;
		int lineNb = 1;
		try {
			line = br.readLine();
				System.out.println(line);
				if(lineNb == 1 && line != null){ 
					if(line.startsWith("GET")){
						String[] lineChunks = line.split(" ");
						this.processGet(lineChunks[1]);
						}
					else if(line.startsWith("PUT")){
						String[] lineChunks = line.split(" ");
						this.processPut(lineChunks[1]);}
					else{processUnknowCommand();}
				}else{
					System.out.println("");
				}
		} catch (IOException e) {
			System.out.println("readLine error");
			e.printStackTrace();
		}
		
		
	}
	
	private void processUnknowCommand() throws IOException {
		System.out.println("Processing Unknow Command");
		is.close();
	}

	private void processPut(String lineChunks) throws IOException {
		System.out.println("Processing Put Command");
		is.close();
	}

	protected void processGet(String filePath) throws IOException{
		System.out.println("Processing Get Command");
		
		if(checkFileExistence(filePath)){
			System.out.println("file Exists");
			String message = buildFileMessage(200, filePath);
			sendMessage(message);
		}else{
			System.out.println("File Not Found");
			String message = buildErrorMessage(404,"File Not Found");
			sendMessage(message);
		}
		
		is.close();
	}

	private String buildFileMessage(int code, String filePath) {
		String signification;
		String fileContent = "";
		
		switch (code){
		case 200:
			signification = "OK";
		default :
			signification = "Unknown";
		break;
		}
		
		String message = "HTTP/1.1 "+code+" "+signification+"\r\n"
		+ "\r\n"
		+ fileContent+"\r\n";		
		return message;
		
	}
	
	private String buildErrorMessage(int errorCode, String errorMessage) {
		String errorSignification;
		
		switch (errorCode){
		case 404:
			errorSignification = "Not found";
		break;
		default:
			errorSignification = "Unknown Error";
		break;
		}
		
		String message = "HTTP/1.1 "+errorCode+" "+errorSignification+"\r\n"
		+ "\r\n"
		+ errorMessage+"\r\n";
		
		System.out.println("Message Built : \n"+message);
		
		return message;
	}

	private void sendMessage(String message) {
	System.out.println("Sending Message");
		dos = new DataOutputStream(os);
		try {
			dos.writeUTF(message);
		} catch (IOException e) {
			System.out.println("Error sending message");
			e.printStackTrace();
		}
		try {
			dos.flush();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		try {
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Message Sent");
	}

	private boolean checkFileExistence(String string) {
		
		return false;
	}

	@Override
	public void run() {
		System.out.println("Entering Run");
		this.processRequest();
	}

}