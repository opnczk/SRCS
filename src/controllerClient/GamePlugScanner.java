package controllerClient;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class GamePlugScanner extends Thread {

	private String distantAddress;
	private int accessPort;
	private int connectionMode;
	private  ArrayList<String> poolGamePlugs;

	public GamePlugScanner(int connectionMode, byte[] distantAddress, int accessPort, ArrayList<String> poolGamePlugs){
		InetAddress address = null;
		try {
			address = InetAddress.getByAddress(distantAddress);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		this.distantAddress = address.toString().replaceAll("/", "").split("\\:")[0];
		this.accessPort = accessPort;
		this.connectionMode = connectionMode;
		this.poolGamePlugs = poolGamePlugs;
	}
	
	public void run(){
		//System.out.println("started ?");
		if(this.connectionMode == NetworkConst.SOCKET_TCP){
			try {
				Socket socket = new Socket(distantAddress, this.accessPort); // this == new Socket() + socket.connect(distantAddress, this.accessPort)
				System.out.println("Socket created");
				socket.close();
				System.out.println("Connected");
				poolGamePlugs.add(distantAddress);
			} catch (IOException e) {
				//e.printStackTrace();
			}
		}else 
			if(this.connectionMode == NetworkConst.SOCKET_UDP){
				String testString = "quailsHill";
				try {
					DatagramSocket socket = new DatagramSocket();
					byte[] sendData = new byte[1024];
					sendData = testString.getBytes();
					DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, InetAddress.getByName(distantAddress), 28555);
					socket.send(sendPacket);
					
					byte[] receiveData = new byte[1024];
					DatagramPacket receivePacket = 
					         new DatagramPacket(receiveData, receiveData.length); 
					  
					socket.setSoTimeout(10000);

		            socket.receive(receivePacket); 
		            String modifiedSentence = new String(receivePacket.getData());
					
		            socket.close();
					
		            if(modifiedSentence.contains(testString.toUpperCase()))
					poolGamePlugs.add(distantAddress);
				} catch (SocketException e) {
					//e.printStackTrace();
				} catch (UnknownHostException e) {
					//e.printStackTrace();
				} catch (IOException e) {
					//e.printStackTrace();
				}
		}else 
			if(this.connectionMode == NetworkConst.RMI){
				
		}
	}
}
