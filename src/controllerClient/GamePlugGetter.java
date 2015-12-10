package controllerClient;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;


public class GamePlugGetter {
	private int accessPort = 5099;
	private InetAddress address;
	private int NbOfAdressesInNetwork;
	private ArrayList<String> connectedGamePlugs;
	
	public GamePlugGetter(){
		try {
			this.address = InetAddress.getLocalHost();	
			this.NbOfAdressesInNetwork = getNbOfAdressesInNetwork(this.address);
			this.connectedGamePlugs = new ArrayList<String>();
		} catch (SocketException | UnknownHostException e) {
			System.out.println("Unable to scan trought network");
			e.printStackTrace();
		}
	}
	
	private int getNbOfAdressesInNetwork(InetAddress thisAddress) throws SocketException, UnknownHostException {
		NetworkInterface networkInterface;
		networkInterface = NetworkInterface.getByInetAddress(thisAddress);
		
		//we only get the first address, as the second is the MAC Address of the interface
		InterfaceAddress address = networkInterface.getInterfaceAddresses().get(0);
		
		short networkPrefixLength = address.getNetworkPrefixLength();
		if(networkPrefixLength != 32 || networkPrefixLength != 31){
			return (int) (Math.pow(2,(32-networkPrefixLength))-2);
		}else if(networkPrefixLength == -1){
			return 0;
		}
		else{
			return (int) (Math.pow(2,(32-networkPrefixLength)));
		}
	}
	
	private void scanForGamePlugs(int connectionMode){
		byte[] distantAddress = this.address.getAddress();
		for(int i = 1; i <= this.NbOfAdressesInNetwork; i++){
			distantAddress[3]= (byte)i; 
			GamePlugScanner gpscan = new GamePlugScanner(connectionMode, distantAddress, this.accessPort, this.connectedGamePlugs); 
			gpscan.start();
		}
		
		if(NbOfAdressesInNetwork == 0){
			System.out.println("LoopBack");
			GamePlugScanner gpscan = new GamePlugScanner(connectionMode, this.address.getAddress(), this.accessPort, this.connectedGamePlugs);
			gpscan.start();
		}
	}

	public static void main(String [] args){
		long startingTime = System.currentTimeMillis();
		int usedProtocol = NetworkConst.SOCKET_TCP;
		System.out.println("Launched");
		GamePlugGetter gpg = new GamePlugGetter();
		gpg.scanForGamePlugs(usedProtocol);
		
		
		for(int i = 0; i< gpg.connectedGamePlugs.size(); i++){
			System.out.println("Found GamePlugs : "+gpg.connectedGamePlugs.get(i));
		}	
		if(usedProtocol == NetworkConst.SOCKET_UDP){System.out.println("udp");}else{
			System.out.println("tcp");
		}
		System.out.println("ElapsedTime for  : "+(System.currentTimeMillis() - startingTime)+"ms");
	}
}
