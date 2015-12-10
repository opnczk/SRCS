import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;


public class GamePlugGetter {

	private String address;
	private int NbOfAdressesInNetwork;
	private ArrayList<String> connectedGamePlugs;
	
	public GamePlugGetter(){
		try {
			this.address = InetAddress.getLocalHost().getHostAddress();	
			this.NbOfAdressesInNetwork = getNbOfAdressesInNetwork(this.address);
			this.connectedGamePlugs = new ArrayList<String>();
				System.out.println(this.address);
		} catch (SocketException | UnknownHostException e) {
			System.out.println("Unable to scan trought network");
			e.printStackTrace();
		}
	}
	
	private int getNbOfAdressesInNetwork(String thisAddress) throws SocketException, UnknownHostException {
		NetworkInterface networkInterface;
		networkInterface = NetworkInterface.getByInetAddress(InetAddress.getByName(thisAddress));
		
		//we only get the first address, as the second is the MAC Address of the interface
		InterfaceAddress address = networkInterface.getInterfaceAddresses().get(0);
		
		short networkPrefixLength = address.getNetworkPrefixLength();
		int networkNbOfAddresses;
		System.out.println(networkPrefixLength);
		if(networkPrefixLength != 32 || networkPrefixLength != 31){
			return networkNbOfAddresses = (int) (Math.pow(2,(32-networkPrefixLength))-2);
		}else if(networkPrefixLength == -1){
			return 0;
		}
		else{
			return networkNbOfAddresses = (int) (Math.pow(2,(32-networkPrefixLength)));
		}
	}
	
	private void scanForGamePlugs(){
		String[] addressChunks = this.address.split("\\.");
		System.out.println("NbOfAddress"+NbOfAdressesInNetwork);
		for(int i = 1; i <= this.NbOfAdressesInNetwork; i++){
			//System.out.println("connectAttempt");
			String distantAddress = addressChunks[0]+"."+addressChunks[1]+"."+addressChunks[2]+"."+i; 
			GamePlugScanner gpscan = new GamePlugScanner(distantAddress, this.connectedGamePlugs); 
			gpscan.start();
		}
		if(NbOfAdressesInNetwork == 0){
			System.out.println("LoopBack");
			GamePlugScanner gpscan = new GamePlugScanner("127.0.0.1", this.connectedGamePlugs);
			gpscan.start();
		}
	}

	public static void main(String [] args){
		GamePlugGetter gpg = new GamePlugGetter();
		gpg.scanForGamePlugs();
	}
	
}
