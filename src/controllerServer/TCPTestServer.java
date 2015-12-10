package controllerServer;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class TCPTestServer {

	/**
	 * @param args
	 */
	@SuppressWarnings({ "resource" })
	public static void main(String[] args) {
		System.out.println("Launched");
		while(true){
			try {
				ServerSocket ss = new ServerSocket(5099);
				Socket c = ss.accept();
				c.close();
				System.out.println("accepted"+c.getRemoteSocketAddress().toString());
			} catch (IOException e) {
				//System.out.println("reject "+y);
				//e.printStackTrace();
			}
		}
	}

}
