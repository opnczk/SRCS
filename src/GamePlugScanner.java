import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;

public class GamePlugScanner extends Thread {

	private static final int SOCKET_TCP = 0;
	private static final int SOCKET_UDP = 1;
	private static final int RMI = 2;
	
	private String distantAddress;
	private int connectionMode;
	private  ArrayList<String> poolGamePlugs;

	public GamePlugScanner(String distantAddress, ArrayList<String> poolGamePlugs){
		this.distantAddress = distantAddress;
		this.connectionMode = SOCKET_TCP;
		this.poolGamePlugs = poolGamePlugs;
		
	}
	
	public void run(){
		//System.out.println("started ?");
		if(this.connectionMode == SOCKET_TCP){
			Socket c = new Socket();
			String thisAddress = "";
			SocketAddress address = InetSocketAddress.createUnresolved(this.distantAddress, 8080);
			//System.out.println(address.toString().split("\\:")[0]);
			try {
				thisAddress = InetAddress.getLocalHost().getHostAddress();
				c.connect(address);
				System.out.println("Connected");
				poolGamePlugs.add(address.toString().split("\\:")[0]);
			} catch (IOException e) {
				if(thisAddress.compareTo(distantAddress) == 0){
					System.out.println("Same Address ShouldWork");
					e.printStackTrace();
				}
			}
		}else 
		if(this.connectionMode == SOCKET_UDP){
			
		}
	}
}
